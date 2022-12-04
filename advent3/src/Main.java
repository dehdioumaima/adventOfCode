import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent3/input/rucksacks.txt"));

        int lowerCase = (int)'a';
        int upperCase = (int)'A';
        int score = 0;

        String line = br.readLine();
        while (line != null) {
            String first = line.substring(0, line.length()/2);
            String second = line.substring(line.length()/2);
            int i=0;
            while(!first.contains(String.valueOf(second.charAt(i))))
            {
                i++;
            }

            int charIndex = (int) second.charAt(i);
            score += (charIndex<lowerCase)? (charIndex-upperCase+27):(charIndex-lowerCase+1);
            line = br.readLine();
        }
        System.out.println("the score is: "+score);
        br.close();

    }
}