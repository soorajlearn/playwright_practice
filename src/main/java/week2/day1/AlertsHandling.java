package week2.day1;

import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertsHandling {

	@Test
	public void alertsHandling() {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.leafground.com/alert.xhtml");
		//Listener

		page.onceDialog(alert ->{
			String message = alert.message();
			System.out.println(message);
			alert.accept();
		});
		

		page.locator("(//span[text()='Show'])[1]").click();

		page.onceDialog(alert ->{
			String message = alert.message();
			System.out.println(message);
			alert.dismiss();
		});

		page.locator("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::button").click();


		page.close();


	}

}
