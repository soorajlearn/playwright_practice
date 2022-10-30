package week2.day1_1;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class Amazon_AddToCard {
	
	@Test
	public void purchaseMobile() {
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		//Create a new playwright instance
		Playwright pw = Playwright.create();
		
		//Launch Chrome
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		//Launch Firefox
		//Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		
		page.setViewportSize(width, height);
		
		page.navigate("https://amazon.in");
		
		page.locator("#nav-search-dropdown-card").click();
		page.locator("#searchDropdownBox").selectOption("search-alias=electronics");
		
		page.locator("#twotabsearchtextbox").type("Mobile phone");
		
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("Enter");
		
		page.locator("//span[text()='Android']/..//label/input").click();
		
		page.locator("(//span[@data-component-type='s-search-results']//div[2]/div[@data-cel-widget='search_result_2']//a)[1]").click();
		
		Page second_page = context.waitForPage(() -> {page.locator("#imgTagWrapperId").isVisible();});
		
		String combo_price = second_page.locator("//td[text()='Combo Price:']/following-sibling::td//span[@class='a-offscreen']").innerText();
		String bundle_list_price = second_page.locator("//td[text()='Bundle List Price: ']/following-sibling::td//span[@class='a-offscreen']").innerText();
		
		System.out.println(combo_price);
		System.out.println(bundle_list_price);
		
		double cp = Double.parseDouble(combo_price);
		
		double blp = Double.parseDouble(bundle_list_price);
		
		double discount_per = ((blp-cp)*100)/blp;
		
		String dis_per = second_page.locator("(//td[text()='  You Save: ']/following-sibling::td//span)[1]").innerText();
		
		System.out.println(dis_per);
		
		
		
		
		
		page.close();
	}

}
