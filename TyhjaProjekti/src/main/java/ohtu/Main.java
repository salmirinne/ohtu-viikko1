package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats-2015.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        int tehtavat = 0, tunnit = 0;
        System.out.println("opiskelijanumero " + studentNr + "\n");
        for (Submission submission : subs) {
            System.out.println(submission);
            tehtavat += submission.tehdyt;
            tunnit += submission.hours;
        }
        System.out.println("\n" + "yhteensä: " + tehtavat + " tehtävää " + tunnit + " tuntia");
    }
}
