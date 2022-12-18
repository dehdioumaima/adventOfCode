import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class part2 {

    public static int[][] rope;
    public static Set<String> positions;

    public static void moveHead(char direction)
    {
        switch (direction)
        {
            case 'R': rope[0][1]++; break;
            case 'L': rope[0][1]--; break;
            case 'U': rope[0][0]++; break;
            case 'D': rope[0][0]--; break;
            default:break;
        }
    }

    public static void moveKnot(int index)
    {
        if(rope[index-1][0] == rope[index][0])
            rope[index][1] = (rope[index-1][1]>rope[index][1])? rope[index][1]+1 : rope[index][1]-1;
        else if(rope[index-1][1] == rope[index][1])
            rope[index][0] = (rope[index-1][0]>rope[index][0])? rope[index][0]+1 : rope[index][0]-1;
        else
        {
            rope[index][1] = (rope[index-1][1]>rope[index][1])? rope[index][1]+1 : rope[index][1]-1;
            rope[index][0] = (rope[index-1][0]>rope[index][0])? rope[index][0]+1 : rope[index][0]-1;
        }
        positions.add(rope[9][0]+"&"+rope[9][1]);
    }

    public static boolean isAdjacent(int index)
    {
        if(Math.abs(rope[index-1][0]-rope[index][0])>1 || Math.abs(rope[index-1][1]-rope[index][1])>1)
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent9/input/bridge.txt"));

        String line = br.readLine();
        positions = new HashSet<String>();
        positions.add("0&0");
        rope = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};

        while (line != null) {

            String[] step = line.split(" ");
            char direction = line.charAt(0);
            int number = Integer.parseInt(step[1]);

            for(int n=0;n<number;n++)
            {
                moveHead(direction);
                for(int index=1;index<10;index++)
                {
                    if(isAdjacent(index))
                        break;
                    moveKnot(index);
                }
            }

            line = br.readLine();
        }

        System.out.println(positions.size());
        br.close();
    }
}
