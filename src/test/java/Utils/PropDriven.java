package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropDriven {
    //Atributo
    public static Properties props;

    public static String getProperty(String key){
        props = new Properties();
        String rutaFile = "C:\\Users\\exrmirp\\Downloads\\TrabajoPOM_MIRANDA\\src\\main\\resources\\properties.properties";

        try {
            InputStream input = new FileInputStream(rutaFile);

            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return props.getProperty(key);
    }
}
