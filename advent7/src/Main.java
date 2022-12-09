import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Main {

    public static int extraSpaceToFreeUp=0;
    public static int calculateSizeForEachDirectory(Directory directory)
    {
        int size = directory.getSize();
        for(int i=0;i<directory.getSubdirectories().size();i++)
        {
            size += calculateSizeForEachDirectory(directory.getSubdirectories().get(i));
        }
        directory.setSize(size);
        return size;
    }

    public static int getSumOfTotalSizes(Directory directory)
    {
        int total=directory.getSize()<=100000? directory.getSize():0;
        for(int i=0;i<directory.getSubdirectories().size();i++)
        {
            total += getSumOfTotalSizes(directory.getSubdirectories().get(i));
        }

        return directory.isFile()? 0:total;
    }

    public static int getSmallestDirectoryWithEnoughSpace(Directory directory)
    {
        int smallestSize = directory.getSize()>=extraSpaceToFreeUp? directory.getSize() : 0;
        for(int i=0;i<directory.getSubdirectories().size();i++)
        {
            int size = getSmallestDirectoryWithEnoughSpace(directory.getSubdirectories().get(i));
            smallestSize = (size>=extraSpaceToFreeUp && size< smallestSize)? size:smallestSize;
        }

        return smallestSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/oumaimaDehdi/dev/repos/adventOfCode/advent7/input/files.txt"));

        String line = br.readLine();
        Directory root = new Directory("root", 0);

        Directory dir = root;
        line = br.readLine();
        while (line != null) {
            if(line.contains("$ ls"))
            {
                line = br.readLine();
                while(line != null && !line.contains("$"))
                {
                    String[] value = line.split(" ");
                    int size = value[0].equals("dir")? 0: Integer.parseInt(value[0]);
                    dir.addNode(value[1], size);
                    line = br.readLine();
                }
            }
            else if(line.contains("$ cd .."))
            {
                dir = dir.getParentdirectory();
                line = br.readLine();
            }
            //case of sub directory
            else
            {
                String[] value = line.split(" ");
                dir = dir.getSubDirectory(value[2]);
                line = br.readLine();
            }
        }
        int size = calculateSizeForEachDirectory(root);
        extraSpaceToFreeUp = 30000000 - (70000000 - root.getSize());

        System.out.println("part1="+getSumOfTotalSizes(root));
        System.out.println("part2="+getSmallestDirectoryWithEnoughSpace(root));

        br.close();
    }
}