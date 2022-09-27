import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private Map<Path, List<FileData>> fileMapList = new HashMap();

    public void add(FileData file) {
        if (!fileMapList.containsKey(file.getFilePath())) {
            fileMapList.put(file.getFilePath(), new LinkedList<>());
            fileMapList.get(file.getFilePath()).add(file);
        } else {
            fileMapList.get(file.getFilePath()).add(file);
        }
    }

    public void add(Path filePath, FileData file) {
        if (!file.getFilePath().equals(filePath)) {
            System.out.println("FileData can not ot add");
        } else if (!fileMapList.containsKey(filePath)) {
            fileMapList.put(filePath, new LinkedList<>());
            fileMapList.get(filePath).add(file);
        } else {
            fileMapList.get(filePath).add(file);
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

    @Override
    public String toString() {
        return "FileNavigator{" +
                "fileMapList=" + fileMapList +
                '}';
    }
}