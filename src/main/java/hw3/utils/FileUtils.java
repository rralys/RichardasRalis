package hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtils {

    public static Properties readPropertiesFile(String fileName) {

        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(fileName)) {
            if (input == null) {
                System.out.println("Sorry, unable to find properties file.");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }


}
