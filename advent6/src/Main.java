import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static boolean isStringUnique(String sub)
    {
        int i=0;
        while(i<sub.length()-1)
        {
            if(sub.substring(i+1,sub.length()).contains(String.valueOf(sub.charAt(i))))
            {
                return false;
            }
            i++;
        }
        return true;
       /* if(sub.substring(1,4).contains(String.valueOf(sub.charAt(0))))
        {
            return false;
        }
        if(sub.substring(2,4).contains(String.valueOf(sub.charAt(1))))
        {
            return false;
        }
        if(sub.charAt(2) == sub.charAt(3))
        {
            return false;
        }

        return true;*/
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent6/input/signals.txt"));

        String line = br.readLine();

        int result1=0;
        int i=0;
        while(i+3<line.strip().length())
        {
            if(isStringUnique(line.substring(i,i+4)))
                break;
            i++;
        }
        result1 += i+4;
        int result2=0;
        int j=0;
        while(j+13<line.strip().length())
        {
            if(isStringUnique(line.substring(j,j+14)))
                break;
            j++;
        }
        result2 += j+14;
        System.out.println(result1);
        System.out.println(result2);

        br.close();
    }
}