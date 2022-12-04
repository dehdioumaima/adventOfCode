import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent4/input/section-pairs.txt"));

        int score =0;
        String line = br.readLine();
        while (line != null) {
            String[] items = line.split(",");
            String[] first = items[0].split("-");
            String[] second = items[1].split("-");

            int firstMin=Integer.parseInt(first[0]);
            int firstMax=Integer.parseInt(first[1]);
            int secondMin=Integer.parseInt(second[0]);
            int secondMax=Integer.parseInt(second[1]);

            if((firstMin <= secondMin && firstMax >= secondMax) || (secondMin <= firstMin && secondMax >= firstMax))
            {
                score++;
            }
            line = br.readLine();
        }

        System.out.println("the score is: "+score);
        br.close();
    }
}