package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                "src/test/resources/config.properties");

            prop = new Properties();
            prop.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static String getUrl() {

        String env = prop.getProperty("env");

        if (env.equalsIgnoreCase("QA"))
            return prop.getProperty("qa.url");

        else if (env.equalsIgnoreCase("UAT"))
            return prop.getProperty("uat.url");

        else
            return prop.getProperty("prod.url");
    }
}