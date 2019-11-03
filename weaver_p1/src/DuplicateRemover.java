import java.util.*;
import java.io.*;

public class DuplicateRemover {        //contain a public class called DuplicateRemover
    private Set<String> uniqueWords = new HashSet<>();     //HashSet won't take in duplicate data

    public void remove(String dataFile) throws IOException {     //creates HashSet from dataFile

        FileReader fileReader = new FileReader(dataFile);
        Scanner fileScanner = new Scanner(fileReader);

        fileScanner.next();
        String nextWord;

        while (fileScanner.hasNext()) {
            nextWord = fileScanner.next();      //adds each word from input
            uniqueWords.add(nextWord);        //uniqueWords HashSet only stores uniques
        }

        fileScanner.close();    //clean up any and all resources allocated during method execution
        fileReader.close();
    }                             //HashSet created from unique words in dataFile

    public void write(String outputFile) throws IOException {     //writes the words contained in uniqueWords to the file pointed to by outputFile
        //create output file if doesn't exist and overwrite if it does exist
        Iterator itrtr = uniqueWords.iterator();
        File uniqueWordsFile = new File(outputFile);

        if (!uniqueWordsFile.exists()) {     //if file doesn't exist make new file to write to
            uniqueWordsFile.createNewFile();
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile));

        while (itrtr.hasNext()) {
            String uniqueWord = (String) itrtr.next();
            fileWriter.write(uniqueWord + "\n");
        }

        fileWriter.close();         //clean up any and all resources allocated during method execution
    }
}
