package com.example.demo.service;

import com.example.demo.exception.FileProcessingException;
import com.example.demo.exception.ReadFileErrorException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileService {

    public static final int ONE = 1;
    public static final String TXT_FILE_EXTENSION = ".txt";
    public static final String REGEX = "\\s+";

    /**
     * checking text file
     * @param file
     * @return
     */
    @NonNull
    public static boolean isTxtFile(File file) {
        return file.getName().endsWith(TXT_FILE_EXTENSION);
    }

    /**
     *reading line by line and storing in a hashmap
     * @param file
     * @return
     */
    public static Map<String, Integer> findDuplicates(File file) {
        if (FileService.isTxtFile(file)) {
            Map<String, Integer> wordCounts = new HashMap<>();
            try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            //Reading each line from file
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split(REGEX);
                    for (String word : words) {
                        if (wordCounts.containsKey(word)) {
                            wordCounts.put(word, wordCounts.get(word) + ONE);
                        } else {
                            wordCounts.put(word, ONE);
                        }
                    }
                }
                reader.close();
            }
            catch (Exception e){
                throw new ReadFileErrorException("Error while reading file");
            }
            return getFreqDuplicates(wordCounts);
        } else {
            throw new FileProcessingException("Please enter text file only");
        }
    }

    /**
     * return frequency of all duplicates
     * @param wordCounts
     * @return
     */
    private static Map<String, Integer> getFreqDuplicates(Map<String, Integer> wordCounts) {
        Map<String, Integer> freqDuplicates = new HashMap<>();
        for (String val : wordCounts.keySet()) {
            if (wordCounts.get(val) > ONE) {
                freqDuplicates.put(val, wordCounts.get(val));
            }
        }
        return freqDuplicates;
    }

}
