package hw3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {

    public Properties readUserPropertiesFromFile() {
        Properties userProperties = new Properties();

        try (InputStream input = this.getClass().getClassLoader()
                .getResourceAsStream("properties/user.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            userProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userProperties;
    }

    public Properties readPageTitleFromFile() {
        Properties pageTitles = new Properties();

        try (InputStream input = this.getClass().getClassLoader()
                .getResourceAsStream("properties/pageTitles.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            pageTitles.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pageTitles;
    }

    public Properties readElementsCountsFromFile() {
        Properties pageCounts = new Properties();

        try (InputStream input = this.getClass().getClassLoader()
                .getResourceAsStream("properties/elements.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            pageCounts.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pageCounts;

    }

    public Properties readSubHeaderLinkFromFile() {
        Properties linkFile = new Properties();

        try (InputStream input = this.getClass().getClassLoader()
                .getResourceAsStream("properties/subheaderlink.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find properties file.");
            }
            linkFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linkFile;
    }

    public Properties readRadioButtonToSelectFromFile() {
        Properties radioFile = new Properties();

        try (InputStream input = this.getClass().getClassLoader()
                .getResourceAsStream("properties/radiobutton.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find properties file.");
            }
            radioFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return radioFile;

    }

    public Properties readDropdownItemToSelectFromFile() {
        Properties drdFile = new Properties();

        try (InputStream input = this.getClass().getClassLoader()
                .getResourceAsStream("properties/dropdown.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find properties file.");
            }
            drdFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return drdFile;
    }
}
