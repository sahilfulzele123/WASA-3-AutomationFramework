package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods to read the data from property file
 * @author SAHIL
 *
 */
public class PropertyFileUtility {
	/**
	 * This method read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
public String readDataFromPropertyFile(String key) throws IOException {
    	
    	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
    	Properties p = new Properties();
    	p.load(fis);
    	String value = p.getProperty(key);
    	return value;
    	
    }

}
