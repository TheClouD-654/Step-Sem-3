import java.util.ArrayList;
import java.util.HashMap;

public class StopWordFilteredWordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        String cleanedFeedback = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "");
        String[] words = cleanedFeedback.split("\\s+");
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.equals("")) {
                if (frequency.containsKey(word)) {
                    frequency.put(word, frequency.get(word) + 1);
                } else {
                    frequency.put(word, 1);
                }
            }
        }

        ArrayList<String> uniqueWords = new ArrayList<>(frequency.keySet());
        for (int i = 0; i < uniqueWords.size(); i++) {
            for (int j = i + 1; j < uniqueWords.size(); j++) {
                if (frequency.get(uniqueWords.get(j)) > frequency.get(uniqueWords.get(i))) {
                    String temporaryWord = uniqueWords.get(i);
                    uniqueWords.set(i, uniqueWords.get(j));
                    uniqueWords.set(j, temporaryWord);
                }
            }
        }

        for (String word : uniqueWords) {
            System.out.println(word + ": " + frequency.get(word));
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
