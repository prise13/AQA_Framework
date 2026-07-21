package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    private static Properties properties;

    private static void initProperties() {
        properties = new Properties();
        String fileName = "config.properties";
        try (FileInputStream stream = new FileInputStream("src/main/resources/" + fileName)) {
            properties.load(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String property) {
        if (properties == null) {
            try {
                initProperties();
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize properties", e);
            }
        }

        String value = properties.getProperty(property);

        if (value == null) {
            throw new IllegalArgumentException(
                    "Property '" + property + "' not found");
        }

        return value;
    }
}
