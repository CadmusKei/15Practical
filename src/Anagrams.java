
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

    // Read the file into an ArrayList
    private static ArrayList<String> readBook(String filename)  throws IOException {
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

    // Helper Method for Hashing
    private static String signature(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

    private static HashMap<String, ArrayList<String>> generateAnagram (ArrayList<String> words) {

        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

        for (String word : words) {
            String sig = signature(word);

            ArrayList<String> anagramWords = anagrams.get(sig);
            if (anagramWords == null) {
                ArrayList<String> anagramWords = new ArrayList<>();
                anagrams.put(sig, anagramWords);
            }

            if (!anagramWords.contains(word)) {
                anagramWords.add(word);
            }

            return anagrams;

        }


    }






}
