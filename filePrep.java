package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * Created by jeremiahlukus on 3/26/17.
 *
 * Removes empty lines from text file and writes to a new one.
 *
 * This code is from http://stackoverflow.com/questions/41436697/how-to-remove-blank-lines-from-a-text-file-in-java
 *
 */
public class filePrep {
    public void  removeEmptyLines (String inputFileName, String outputFileName) throws IOException{

        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));
             PrintWriter outputFile = new PrintWriter(new FileWriter(outputFileName))) {
            String lineOfText;
            while ((lineOfText = inputFile.readLine()) != null) {
                lineOfText = lineOfText.trim();
                if (!lineOfText.isEmpty()) {
                    outputFile.println(lineOfText);
                }
            }
        }
    }


}
