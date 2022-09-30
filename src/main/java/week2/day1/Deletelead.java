package week2.day1;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Deletelead {
	
	
	@Test
	public void deleteLead() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		
		page.setViewportSize(width, height);
		
		
		// Find the user name and enter the value
		page.locator("id=username").type("demosalesmanager");
				
		// Find the password and enter the value
		page.locator("id=password").type("crmsfa");
						
		// Find the login and click
		page.locator(".decorativeSubmit").click();
						
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
		
		//Click phone
		page.locator("//span[text()='Phone']").click(); 
	
		
		//Search by 9
		page.locator("//input[@name='phoneNumber']").type("9");
		page.locator("//button[text()='Find Leads']").click();

		//take first one - store lead id
		String leadId = page.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").innerText();

		//click delete lead
		page.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		page.locator("text=Delete").click();

		//Click Find leads on left tab
		page.locator("a:has-text('Find Leads')").click();
		
		//Search by Lead id : stored id
		page.locator("//input[@name='id']").type(leadId);
		page.locator("//button[text()='Find Leads']").click();

		//Confirm text - No Records found
		page.locator("//div[text()='No records to display']").innerText();
		
		
	}
	

}
