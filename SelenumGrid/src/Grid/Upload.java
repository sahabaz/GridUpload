package Grid;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Upload 
{
	public static void main(String[] args) throws InterruptedException, IOException, AWTException 
	{
		URL url = new URL("http://10.10.14.244:4444/wd/hub/");
//		URL url = new URL("http://10.10.14.61:4444/wd/hub/");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		RemoteWebDriver d = new RemoteWebDriver(url , dc);
		d.get("https://www.naukri.com/");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@value='Upload CV']/..")).click();
		
		File f = new File("\\\\10.10.14.244\\d$\\New Microsoft Word Document (2).docx");
		f.createNewFile();
		StringSelection s = new StringSelection("D:\\New Microsoft Word Document (2).docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
