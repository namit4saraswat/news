package utils;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.google.common.io.Files;

public class Screenshot extends utils.DriverManager {

	public static String take_snip() {
		
		long timeMilli = utils.CurrentDateInMili.getCurrentTime();
		String ScreenshotPath = System.getProperty("user.dir") + "./Screenshots/" + timeMilli + ".png";
		File dstn = new File(ScreenshotPath);
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(source, dstn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ScreenshotPath;
	}

}
