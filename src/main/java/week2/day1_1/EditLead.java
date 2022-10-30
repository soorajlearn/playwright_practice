package week2.day1_1;

import java.nio.file.Paths;

import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class EditLead {
	
	@Test
	public void editLead() {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		//Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("login_leaftaps.json")));
		
		
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		

//		// Find the user name and enter the value
//		page.locator("id=username").type("demosalesmanager");
//		
//		// Find the password and enter the value
//		page.locator("id=password").type("crmsfa");
//				
//		// Find the login and click
//		page.locator(".decorativeSubmit").click();
//				
		// Click on the CRM/SFA
		page.locator("text=CRM/SFA").click();
						
		// Click Leads Tab
		page.locator("a:has-text('Leads')").click();
		
				
		// Click Find Leads Menu (on the left)
		page.locator("a:has-text('Find Leads')").click();
				
		// Find and Type First Name ("Babu")
		page.locator("(//input[@name='firstName'])[3]").type("Babu");
				
		// Click Find Leads Button
		page.locator("//button[text()='Find Leads']").click();
				
		// Click on the first matching link (xpath --> )
		page.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		
		// Click Edit 
		page.locator("text=Edit").click();
		
		// Clear the existing value 
		page.locator("id=updateLeadForm_firstName").fill("");
				
		// Type your name 
		page.locator("id=updateLeadForm_firstName").type("Sooraj");
				
		// Click Update
		page.locator("//input[@value='Update']").click();
		
		// Confirm name got changed !!
		String updatedName = page.locator("id=viewLead_firstName_sp").innerText();
		System.out.println(updatedName);
		
		//Close the browser
		page.close();
		
		
	}

}
