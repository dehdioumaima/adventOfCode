import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static boolean isVisibleInLine(List<String> trees, int item, int i, int j)
    {
        String line = trees.get(i);
        boolean isVisible = true;
        for(int l=0;l<j;l++)
        {
            if(Integer.parseInt(String.valueOf(line.charAt(l))) >= item)
            {
                isVisible=false;
                break;
            }
        }

        if(isVisible)
            return true;

        isVisible = true;

        for(int l=j+1;l<line.length();l++)
        {
            if(Integer.parseInt(String.valueOf(line.charAt(l))) >= item)
            {
                isVisible=false;
                break;
            }
        }
        return isVisible;
    }

    public static boolean isVisibleInColumn(List<String> trees, int item, int i, int j)
    {
        boolean isVisible = true;
        for(int k=0;k<i;k++)
        {
            if(Integer.parseInt(String.valueOf(trees.get(k).charAt(j))) >= item)
            {
                isVisible=false;
                break;
            }
        }

        if(isVisible)
            return true;

        isVisible = true;

        for(int k=i+1;k<trees.size();k++)
        {
            if(Integer.parseInt(String.valueOf(trees.get(k).charAt(j))) >= item)
            {
                isVisible=false;
                break;
            }
        }
        return isVisible;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent8/input/trees.txt"));

        List<String> trees = br.lines().toList();

        int number=0;
        for(int i=1;i<trees.size()-1;i++)
        {
            for(int j=1;j<trees.get(i).length()-1;j++)
            {
                int item = Integer.parseInt(String.valueOf(trees.get(i).charAt(j)));
                if(isVisibleInLine(trees, item, i, j) || isVisibleInColumn(trees, item, i, j))
                    number++;
            }
        }

        //add the trees at the edge
        number+= trees.size()*2 + trees.get(0).length()*2 - 4;
        System.out.println(number);

        br.close();
    }
}