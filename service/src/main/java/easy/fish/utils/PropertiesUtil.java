package easy.fish.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Java猿
 */
public class PropertiesUtil {
    private static final Properties properties=new Properties();

    static {
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("easyid.properties"));
        } catch (IOException e) {

        }

    }

    public static String readString(String key) {
        return properties.getProperty(key, "-1");
    }

    public static void main(String[] args) {
        System.out.println(readString("easyid.machineid"));
    }
}
