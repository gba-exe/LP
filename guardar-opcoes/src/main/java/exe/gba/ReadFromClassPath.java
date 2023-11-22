package exe.gba;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ReadFromClassPath {
    public static void main(String[] args) {

        try (InputStream input = ReadFromClassPath.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("user.name"));
            System.out.println(prop.getProperty("user.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
