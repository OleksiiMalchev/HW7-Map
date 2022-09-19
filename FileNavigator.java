import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private Map<Path, List<FileData>> fileMapList = new HashMap();
    private List<FileData> fileList;
    public void add(FileData file) {
        if (!fileMapList.containsKey(file.getFilePath())) {
            fileList = new LinkedList<>();
            fileList.add(file);
            fileMapList.put(file.getFilePath(), fileList);
        } else {
            fileList.add(file);
        }
    }
    public void add(Path filePath, FileData file) {
        if (!file.getFilePath().equals(filePath)) {
            System.out.println("FileData can not ot add");
        } else {
            fileList.add(file);
            fileMapList.put(file.getFilePath(), fileList);
        }
    }



    public List<FileData> find(Path filePath) {
        return fileMapList.values()
                .stream()
                .flatMap(List::stream)
                .filter(f -> f.getFilePath().equals(filePath))
                .collect(Collectors.toList());
    }
    public List<FileData> filterBySize(byte maxSize) {
        return fileMapList.values()
                .stream()
                .flatMap(List::stream)
                .filter(f -> f.getFileSize() < maxSize)
                .collect(Collectors.toList());
    }

    public void remove(Path filePath) {
        fileMapList.remove(filePath);
    }
    public List<FileData> sortBySize() {
        return fileMapList.values()
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(FileData::getFileSize))
                .collect(Collectors.toList());
    }
}