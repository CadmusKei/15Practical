
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) throws IOException {

        ArrayList<String> words = readBook("joyce1922_ulysses-1.text");
        HashMap<String, ArrayList<String>> anagrams = generateAnagram(words);
        readAnagrams(anagrams);
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
        if (word.isEmpty()) return "";
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

    private static HashMap<String, ArrayList<String>> generateAnagram(ArrayList<String> words) {
        if (words.isEmpty()) return new HashMap<>();
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();
        for (String word : words) {
            String sig = signature(word);

            ArrayList<String> anagramWords = anagrams.get(sig);
            // AnagramWords is the Words related to this specific signature (because of for loop. )
            if (anagramWords == null) {
                anagramWords = new ArrayList<>();
                anagrams.put(sig, anagramWords);
            }

            if (!anagramWords.contains(word)) {
                anagramWords.add(word);
            }
        }
        return anagrams;
    }

    private static void readAnagrams(HashMap<String, ArrayList<String>> anagrams) {
        if (anagrams.isEmpty()) return;
        for (Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
            System.out.println("Signature: " + entry.getKey() + ", Anagrams: " + entry.getValue());
        }
    }


}
