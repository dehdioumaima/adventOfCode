import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent2/input/strategy.txt"));

        int score=0;

        String line = br.readLine();
        while (line != null) {
            char first = line.charAt(0);
            char second = line.charAt(2);
            switch (second)
            {
                case 'X':
                    score += 1 + (first=='A'? 3: (first=='C'? 6:0));
                    break;
                case 'Y':
                    score += 2 + (first=='B'? 3: (first=='A'? 6:0));
                    break;
                case 'Z':
                    score += 3 + (first=='C'? 3: (first=='B'? 6:0));
                    break;
            }

            line = br.readLine();
        }
        System.out.println("score= "+score);
        br.close();
    }
}