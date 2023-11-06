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

    public static String getProperty(String property) throws Exception {
        if (properties == null) {
            initProperties();
        }
        String prop = properties.get(property).toString();
        if (prop == null) {
            throw new Exception("Property not found");
        }
        return prop;
    }
}
