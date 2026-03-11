
import java.util.HashMap;
import java.util.ArrayList;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) throws IOException {


        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

    }

    public static ArrayList<String> readBook(String filename)  throws IOException {
        Path path = Path.of(filename);
        ArrayList<String> wordArray = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                String[] words = line.split("\\s");
                wordArray.add(word);
            });
        }

    }








}
