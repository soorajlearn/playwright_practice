package week2.day1;

import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandling {

	@Test
	public void alertsHandling() {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		//Listener
		
		//String parentFrame = "//div[@id='iframecontainer']/div[@id='iframe']";
		String childFrame = "//div[@id='iframecontainer']/div[@id='iframe']/div/iframe";
		
		page.frameLocator(childFrame)
			.locator("//button[text()='Try it']").click();

		page.onceDialog(alert ->{
			String message = alert.message();
			System.out.println(message);
			alert.accept("Sooraj");
		});
		
		String output = page.frameLocator(childFrame)
		.locator("//p[@id='demo']").innerText();
		
		System.out.println(output);

		page.close();


	}

}
