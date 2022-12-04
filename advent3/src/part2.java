import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class part2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent3/input/rucksacks.txt"));

        int lowerCase = (int) 'a';
        int upperCase = (int) 'A';
        int score = 0;

        String line = br.readLine();
        while (line != null) {
            String second = br.readLine();
            String third = br.readLine();
            int i = 0;
            while (!second.contains(String.valueOf(line.charAt(i))) || !third.contains(String.valueOf(line.charAt(i)))) {
                i++;
            }
            int charIndex = (int) line.charAt(i);
            score += (charIndex < lowerCase) ? (charIndex - upperCase + 27) : (charIndex - lowerCase + 1);
            line = br.readLine();
        }
        System.out.println("the score is: " + score);
        br.close();
    }
}
