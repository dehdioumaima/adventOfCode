import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class part2 {
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
                    score += (first=='A'? 3: (first=='B'? 1:2));
                    break;
                case 'Y':
                    score += 3 + (first=='A'? 1: (first=='B'? 2:3));
                    break;
                case 'Z':
                    score += 6 + (first=='A'? 2: (first=='B'? 3:1));
                    break;
            }

            line = br.readLine();
        }
        System.out.println("score= "+score);
        br.close();
    }
}
