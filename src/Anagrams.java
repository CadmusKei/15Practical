
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) throws IOException {

        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();
        ArrayList<String> words = readBook("joyce1922_ulysses-1.text");
        System.out.println(words);

    }

    public static ArrayList<String> readBook(String filename)  throws IOException {
        if (filename.isEmpty()) return new ArrayList<>();
        Path path = Path.of(filename);
        ArrayList<String> wordArray = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                String[] words = line.split("\\s");
                for (String word : words) {
                    wordArray.add(word);
                }
            });
        }
        return (wordArray);
    }








}
