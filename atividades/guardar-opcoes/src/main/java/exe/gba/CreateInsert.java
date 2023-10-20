package exe.gba;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CreateInsert {
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("src/main/resources/config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("user.name", "roberto");
            prop.setProperty("user.password", "roberta");

            // save properties to project root folder
            prop.store(output, "Muito legal");

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
