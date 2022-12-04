import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class part2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent1/input/elf-calories.txt"));

        List<Integer> listOfCalories = new ArrayList<>();

        String line = br.readLine();
        while (line != null) {
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
            listOfCalories.add(calories);
            line = br.readLine();
        }
        Collections.sort(listOfCalories);
        int size = listOfCalories.size();
        int sum = listOfCalories.get(size-1) + listOfCalories.get(size-2) + listOfCalories.get(size-3);
        System.out.println("the sum of 3 max calories is "+sum);
        br.close();
    }
}
