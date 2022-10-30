package week2.day1_1;

import java.nio.file.Paths;

import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UseLoginInfo_FC {
	
	@Test
	public void useLoginInfo() {
		
		Playwright pw = Playwright.create();
		
		Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("login_fc.json")));
		Page page = context.newPage();
		page.navigate("https://branch6-auto116.freshfonehello.com");
		page.pause();

	}

}
