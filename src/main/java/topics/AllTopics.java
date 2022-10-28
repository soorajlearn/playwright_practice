package topics;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AllTopics {
	
	@Test
	public void learnPlaywright() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		//Create a new playwright instance
		Playwright pw = Playwright.create();
		
		//Launch Chrome
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		//Launch Firefox
		//Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setHttpCredentials("freshcaller1@gmail.com", "test@123"));
		//open a new page
		Page page = context.newPage();
		
		//set screen size
		page.setViewportSize(width, height);
		
		page.navigate("https://branch6-auto116.freshfonehello.com");
		
		page.close();
		
		
		
		
		
		
		
	}

}
