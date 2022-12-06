import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static Stack[] moveCrates(Stack[] stacks, int numberOfCrates, int fromStack, int toStack)
    {
        for(int i=0;i<numberOfCrates;i++)
        {
            stacks[toStack].add(0, stacks[fromStack].get(0));
            stacks[fromStack].remove(0);
        }
        return stacks;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent5/input/stacks.txt"));

        //get the crate stacks
        String line = br.readLine();
        List<String> stacksLine=new ArrayList<>();
        while (!line.isBlank()) {
            stacksLine.add(line);
            line = br.readLine();
        }

        //get number of stacks
        String[] numbers = stacksLine.get(stacksLine.size() - 1).split(" ");
        int numberOfStacks = Integer.parseInt(numbers[numbers.length - 1]);
        stacksLine.remove(stacksLine.size()-1);

        //store the stacks
        Stack[] stacks = new Stack[numberOfStacks];
        int index = 1;
        for(int i=0;i<numberOfStacks;i++)
        {
            stacks[i] = new Stack();
            for(int j=0;j<stacksLine.size();j++)
            {
                if(stacksLine.get(j).charAt(index) != ' ')
                {
                    stacks[i].push(stacksLine.get(j).charAt(index));
                }
            }
            index += 4;
        }

        //move the crates
        line = br.readLine();
        while(line != null)
        {
            String[] moves = line.split(" ");
            int numberOfCrates = Integer.parseInt(moves[1]);
            int fromStack = Integer.parseInt(moves[3]) -1;
            int toStack = Integer.parseInt(moves[5]) -1;
            stacks = moveCrates(stacks, numberOfCrates, fromStack, toStack);

            line = br.readLine();
        }

        //display results
        for(int i=0;i<numberOfStacks;i++)
        {
            if(!stacks[i].empty())
            {
                System.out.print(stacks[i].get(0));
            }
        }

        br.close();
    }
}