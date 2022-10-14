package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> filePaths = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (!str.equals("0")) {
                filePaths.add(str);
            } else {
                br.close();
                break;
            }
        }

        for(int i = 0;i< filePaths.size();i++){
            Reader.readDoc(Path.of(filePaths.get(i)));
        }



    }
}


class Reader {
    public static void readDoc(Path path) throws IOException {
        //List<String> strings = Files.readAllLines(path);
        HashSet<String> strings = new HashSet<>(Files.readAllLines(path));
        BufferedWriter validWriter = Files.newBufferedWriter(Path.of("ValidStrings.txt"));
        BufferedWriter invalidWriter = Files.newBufferedWriter(Path.of("InvalidStrings.txt"));
        BufferedWriter feedBackWriter = Files.newBufferedWriter(Path.of("FileFeedback.txt"));
        for (String s : strings) {
            if (s.length() == 15 && (s.startsWith("docnum") || s.startsWith("contract"))) {
                validWriter.write(s + "\n");
            }
        }
        validWriter.close();
        for (String s : strings) {
            if (s.length() != 15 && (!s.startsWith("docnum") || !s.startsWith("contract"))) {
                invalidWriter.write(s + "\n");
            }
        }
        invalidWriter.close();

        for (String s:strings){
            feedBackWriter.write(s+"\n");
        }
        feedBackWriter.close();
    }



}


