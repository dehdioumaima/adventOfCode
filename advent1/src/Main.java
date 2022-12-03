import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent1/input/elf-calories.txt"));

        int elfwithmax=0;
        int maxcalories=0;
        int elf=0;

        String line = br.readLine();
        while (line != null) {
            elf++;
            int calories=0;
            while(line != null && !line.isBlank())
            {
                calories += Integer.parseInt(line);
                line = br.readLine();
            }
            if(line == null)
            {
                break;
            }
            if(calories>maxcalories)
            {
                maxcalories=calories;
                elfwithmax=elf;
            }
            line = br.readLine();
        }

        System.out.println("the max of calories is "+maxcalories+" carried by the Elf "+elfwithmax);
        br.close();
    }
}