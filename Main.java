package com.tushar.java;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger =  Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String inputFile = "Files/Input.txt";
        String outputFile = "Files/Output.txt";

        // Reading values from the input file
        String data = FileService.read(inputFile);
        logger.info("Printing data after processing each line.");

        // Writing data into file
        try{
            FileService.writeIntoFile(outputFile,data);
        }catch (IOException ex){
            logger.severe("Exception occurred while writing data into result file " + ex.getMessage());
        }

        // Reading output file
        data = FileService.readFile(outputFile);
        if(data != null){
            logger.info("Output file - \n" +  data);
        }
    }
}
