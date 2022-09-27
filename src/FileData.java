import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileData {
    private String fileName;
    private byte fileSize;
    private Path filePath;
    private File file;

    public FileData(String fileName, String filePath) {
        this.fileName = fileName;
        this.file = new File(filePath + "\\" + fileName + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileSize = (byte) file.length();
        this.filePath = Paths.get(filePath);
    }
    public byte getFileSize() {
        return fileSize;
    }
    public Path getFilePath() {
        return filePath;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", filePath=" + filePath +
                ", file=" + file +
                '}'+
                "\n";
    }
}
