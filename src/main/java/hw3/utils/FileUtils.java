package hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/* TODO
        As I could see from the class content there are no reasons create so much code duplication
        There is could be one static method which take file path as parameter and read it — Done.
 */

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
