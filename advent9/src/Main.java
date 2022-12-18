import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int iHead = 0;
    public static int jHead = 0;
    public static int iTail = 0;
    public static int jTail = 0;
    public static Set<String> positions;

    public static void moveHead(char direction)
    {
        switch (direction)
        {
            case 'R': jHead++; break;
            case 'L': jHead--; break;
            case 'U': iHead++; break;
            case 'D': iHead--; break;
            default:break;
        }
    }

    public static void moveTail()
    {
        if(iHead == iTail)
            jTail = (jHead>jTail)? jTail+1 : jTail-1;
        else if(jHead == jTail)
            iTail = (iHead>iTail)? iTail+1 : iTail-1;
        else
        {
            jTail = (jHead>jTail)? jTail+1 : jTail-1;
            iTail = (iHead>iTail)? iTail+1 : iTail-1;
        }
        positions.add(iTail+"&"+jTail);
    }

    public static boolean isAdjacent()
    {
        if(Math.abs(iHead-iTail)>1 || Math.abs(jHead-jTail)>1)
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent9/input/bridge.txt"));

        String line = br.readLine();
        positions = new HashSet<String>();
        positions.add("0&0");

        while (line != null) {

            String[] step = line.split(" ");
            char direction = line.charAt(0);
            int number = Integer.parseInt(step[1]);

            for(int i=0;i<number;i++)
            {
                moveHead(direction);
                if(!isAdjacent())
                    moveTail();
            }

            line = br.readLine();
        }

        System.out.println(positions.size());
        br.close();
    }
}