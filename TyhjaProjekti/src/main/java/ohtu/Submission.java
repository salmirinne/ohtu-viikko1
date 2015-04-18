package ohtu;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Submission {
    private int week;
    protected int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    
    protected int tehdyt;
    private List<String> tehtavat = new ArrayList<String>();
    
    private void init() {
        for (Field f : getClass().getDeclaredFields()) {
            if (f.getType() == Boolean.TYPE) {
                try {
                    if (f.getBoolean(this)) {
                        tehdyt++;
                        tehtavat.add(f.getName().substring(1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        init();
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + tehdyt + ", aikaa kului " + hours + " tuntia,"
                + " tehdyt tehtävät: " + Arrays.toString(tehtavat.toArray(new String[0])).replaceAll("\\[|\\]", "");
    }
    
}