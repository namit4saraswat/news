package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


//To fetch Properties reader attribute, make object of class and then use function to fetch values
public class PropertiesFileReader {
	Properties prop;
	
	public static void readPropertiesFile() throws IOException
	{
		Properties prop = new Properties();
		InputStream input = new FileInputStream("C:\\Users\\namit\\Documents\\Linked in learning\\Eclipse\\news\\src\\main\\resources\\config.Properties");
		
		prop.load(input);
		
	}
	
	public static void writePropertiesFile()  throws IOException
	{
		Properties prop = new Properties();
		OutputStream output = new FileOutputStream("C:\\\\Users\\\\namit\\\\Documents\\\\Linked in learning\\\\Eclipse\\\\news\\\\src\\\\main\\\\resources\\\\config.Properties");
		
		prop.setProperty("browser","Chrome");
		prop.store(output, null);
		
	}
	
	public String ChromeDriverPath()
	{
		String path = prop.getProperty("ChromeDriverPath");
		
		return path;
	}
	
	public String Browser()
	{
		String browser = prop.getProperty("Browser");
		return browser;
	} 

}
