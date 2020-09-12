package baseClass;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.OldNews;
import pages.TodayNews;
import utils.DriverManager;

public class TestRunner extends utils.DriverManager {

	ExtentTest logger;
	ExtentReports report;
	ExtentSparkReporter spark;

	@BeforeTest
	@Parameters({ "browser" })
	// System.out.println ("Browser & URL Is " + browser + url);
	public void setup(String browser) {

		Reporter.log("Setting up Driver, extent etc.", true);
		report = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark/Spark.html");
		report.attachReporter(spark);
		spark.config().setDocumentTitle("Automation Report");
		report.setSystemInfo("Browser", browser);
		DriverManager.getDriver(browser);
		Reporter.log("Set up has been done", true);

	}
	// String url = "";

	@Parameters({ "url" })
	@Test(priority = 1)
	public void test_today(String url) {

		// System.out.println("Inside Test before wait");
		utils.Wait.pageWait(4);// System.out.println("Inside Test after wait");
		TodayNews news = new TodayNews();
		news.news_today(url);

	}

	@Parameters({ "url" })
	@Test(priority = 2)
	public void test_old(String url) {

		utils.Wait.pageWait(4);
		OldNews old = new OldNews();
		old.news_old(url);

	}

	// when Listener class will work, remove @AfterMethod and use Listener instead
	
	@AfterMethod
	@Parameters({ "browser" })
	public void repoInputs(String browser,ITestResult result) {
		String testName = result.getMethod().getMethodName();
		logger = report.createTest(testName);
		ExtentTest chromeNode = logger.createNode("Chrome Browser");
		ExtentTest ffNode = logger.createNode("Firefox Browser");
		if (browser == "Chrome")
		{
			chromeNode.pass(testName, MediaEntityBuilder.createScreenCaptureFromPath(utils.Screenshot.take_snip()).build());
			chromeNode.info("Googling for " + testName);
		}
		else
		{	
			ffNode.pass(testName, MediaEntityBuilder.createScreenCaptureFromPath(utils.Screenshot.take_snip()).build());
			ffNode.info("Foxing for " + testName);
			
		}

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, result.getThrowable());
		}

	}

	@AfterSuite
	public void tearDown() {
		System.out.println("Inside Teardown");
		report.flush();
		driver.quit();
	}

}
