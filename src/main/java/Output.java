import java.io.FileWriter;
import java.io.IOException;

public class Output {
    private final Integer numberPerEntry;
    private final String path;

    public Output(Integer numberPerEntry, String path) {
        this.numberPerEntry = numberPerEntry;
        this.path = path;
    }

    public void writeToFile() {
        if (numberPerEntry != null && path != null) {
            try (FileWriter writer = new FileWriter(this.path, false)) {
                writer.write(this.numberPerEntry.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            throw new NullPointerException("path = null or numberPerEntry");
        }
    }
}
