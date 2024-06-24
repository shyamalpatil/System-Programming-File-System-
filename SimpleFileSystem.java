import java.util.ArrayList;
import java.util.List;

class File {
    private String name;
    private String content;

    public File(String name) {
        this.name = name;
        this.content = "";
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Directory {
    private String name;
    private List<File> files;
    private List<Directory> subDirectories;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subDirectories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void createSubDirectory(String name) {
        Directory newDir = new Directory(name);
        subDirectories.add(newDir);
    }

    public Directory getSubDirectory(String name) {
        for (Directory dir : subDirectories) {
            if (dir.getName().equals(name)) {
                return dir;
            }
        }
        return null;
    }

    public File getFile(String name) {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }
}

public class SimpleFileSystem {
    private Directory root;

    public SimpleFileSystem() {
        root = new Directory("/");
    }

    public Directory getRoot() {
        return root;
    }

    public static void main(String[] args) {
        SimpleFileSystem fileSystem = new SimpleFileSystem();
        Directory root = fileSystem.getRoot();

        // Create a file and add content
        File file1 = new File("file1.txt");
        file1.setContent("Hello, World!");
        root.addFile(file1);

        // Create a subdirectory and add a file inside it
        root.createSubDirectory("subdir1");
        Directory subdir1 = root.getSubDirectory("subdir1");
        File file2 = new File("file2.txt");
        file2.setContent("This is a subdirectory.");
        subdir1.addFile(file2);

        // Retrieve and print the content of files
        System.out.println(root.getFile("file1.txt").getContent());
        System.out.println(subdir1.getFile("file2.txt").getContent());
    }
}
