package ohtu.data_access;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ohtu.domain.User;

public class FileUserDAO implements UserDao {

    private File file;

    public FileUserDAO(String file) {
        this.file = new File(file);
    }

    @Override
    public List<User> listAll() {
        List<User> results = new ArrayList<User>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String user, pass;
            while ((user = in.readLine()) != null && (pass = in.readLine()) != null) {
                results.add(new User(user, pass));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) { 
                    
                }
            } 
        }
        return results;
    }

    @Override
    public User findByName(String name) {
        List<User> users = listAll();
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file, true));
            out.write(user.getUsername());
            out.newLine();
            out.write(user.getPassword());
            out.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    
                }
            }
        }
    }
}
