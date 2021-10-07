import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Worker {

    private String fileName;
    private File file;
    private Set<String> words = new HashSet<>();

    public Worker(String fileName) {
        this.fileName = fileName;
    }

    public void initFile() {
        try {
            String filePath = Worker.class.getClassLoader().getResource(fileName).getFile();
            this.file = new File(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void collectWords() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> findAllConcatenatedWords() {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (isConcatenated(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isConcatenated(String word) {
        for (int i = 0; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);

            if (words.contains(left)) {
                if (words.contains(right) || isConcatenated(right)) {
                    return true;
                }
            }

        }
        return false;
    }
}