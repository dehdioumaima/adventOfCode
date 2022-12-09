import java.util.ArrayList;
import java.util.List;

public class Directory {
    String name;
    int size;
    Directory parentdirectory;
    List<Directory> subdirectories;

    public Directory(String name, int size) {
        this.name = name;
        this.size = size;
        this.subdirectories = new ArrayList<>();
    }

    Directory addNode(String name, int size)
    {
        Directory childNode = new Directory(name, size);
        childNode.setParentdirectory(this);
        this.getSubdirectories().add(childNode);

        return childNode;
    }

    Directory getSubDirectory(String name)
    {
        return this.getSubdirectories().stream().filter(item -> item.getName().equals(name)).findFirst().get();
    }

    Boolean isFile()
    {
        return this.subdirectories.isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Directory getParentdirectory() {
        return parentdirectory;
    }

    public void setParentdirectory(Directory parentdirectory) {
        this.parentdirectory = parentdirectory;
    }

    public List<Directory> getSubdirectories() {
        return subdirectories;
    }

    public void setSubdirectories(List<Directory> subdirectories) {
        this.subdirectories = subdirectories;
    }
}
