import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileData fileData = new FileData("first", "src/files");
        FileData fileData1 = new FileData("second", "src/files");
        FileData fileData2 = new FileData("third", "src/files");
        FileData fileData3 = new FileData("first1", "src/files2");
        FileData fileData4 = new FileData("second2", "src/files2");
        FileData fileData5 = new FileData("third3", "src/files2");
        FileNavigator fileNavigator = new FileNavigator();
//        fileNavigator.add(fileData);
//        fileNavigator.add(fileData3);
//        fileNavigator.add(fileData1);
//        fileNavigator.add(fileData4);
//        fileNavigator.add(fileData2);

        fileNavigator.add(Path.of("src/files"), fileData);
        fileNavigator.add(Path.of("src/files"), fileData1);
        fileNavigator.add(Path.of("src/files"), fileData5);
        fileNavigator.add(Path.of("src/files"), fileData2);
        fileNavigator.add(Path.of("src/files"), fileData3);
        fileNavigator.add(Path.of("src/files"), fileData4);

        System.out.println(fileNavigator);

//        List<FileData> fileList = fileNavigator.find(Path.of("src/files"));
//        System.out.println(fileList);
//        List<FileData> listBySizeByte = fileNavigator.filterBySize((byte) 5);
//        System.out.println(listBySizeByte);
//        List<FileData> sortBySize = fileNavigator.sortBySize();
//        System.out.println(sortBySize);
//        fileNavigator.remove(Path.of("src/files"));
    }
}