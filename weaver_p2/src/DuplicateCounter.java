import java.io.*;
import java.util.*;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter = new HashMap<>();
    public void count(String dataFile) throws IOException {
        FileReader fileRead = new FileReader(dataFile);
        Scanner fileScanner = new Scanner(fileRead);

        String uniqueWord;

        while (fileScanner.hasNext()) {     //another word to read from dataFile
            uniqueWord = fileScanner.next();

            if(wordCounter.containsKey(uniqueWord)){
                int wordOccurrence = wordCounter.get(uniqueWord);
                wordCounter.put(uniqueWord, wordOccurrence + 1);    //found word, increment
            }
            else{     //new word, add to wordCounter
                wordCounter.put(uniqueWord, 1);
            }
        }

        fileScanner.close();    //clear memory
    }
    public void write(String outputFile) throws IOException {
        File fileWrite = new File(outputFile);

        if (!fileWrite.exists()) {      //if file doesn't exist make new one
            fileWrite.createNewFile();
        }

        PrintWriter printWrite = new PrintWriter(new FileWriter(outputFile));

        for (Map.Entry < String, Integer > entry : wordCounter.entrySet()){     //writes to file word: count
            printWrite.printf("%s: %d times\n", entry.getKey(), entry.getValue());
        }
        printWrite.close();     //clear memory
    }
}