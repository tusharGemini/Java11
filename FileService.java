package com.tushar.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class FileService {
    private static final Logger logger =  Logger.getLogger(FileService.class.getName());

    public static String readFile(String path){
        try{
            logger.info("Reading file");
            return Files.readString(Path.of(path));
        }catch (IOException e){
            logger.severe("Exception occurred while reading the file "+ e.getMessage());
        }
        return null;
    }

    private static Integer getIntValueFromString(String s){
        try{
            return Integer.parseInt(s);
        }catch (Exception ex){
            logger.severe("Exception occurred while parsing string value to integer : " + ex.getMessage());
        }
        return null;
    }

    public static String read(String path){
        Predicate<String> includeZeroValue = s -> getIntValueFromString(s.strip()) == null || getIntValueFromString(s.strip()) == 0;

        StringBuilder contentBuilder = new StringBuilder();
        readFile(path).lines().filter(Predicate.not(includeZeroValue))
                .map(s -> getIntValueFromString(s.strip()))
                .forEach(value -> contentBuilder.append(value+5).append("\n"));

        return contentBuilder.toString();
    }

    public static void writeIntoFile(String path, String data)throws IOException{
        logger.info("Writing data into the file");
        Files.writeString(Path.of(path),data, StandardOpenOption.WRITE);
    }
}
