package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Crawler2 {
    private static ArrayList<String> terminal(String commandStr) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            ArrayList<String> returns = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                returns.add(line);
            }
            return returns;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String command = "bash crawl.sh";
        ArrayList<String> strings = terminal(command);
        assert strings != null;
        System.out.println(strings.get(0));
    }
}
