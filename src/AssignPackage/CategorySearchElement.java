package AssignPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import AssignPackage.AmazonCategorySearch;

public class CategorySearchElement {
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver","/home/nagashrees11gma/Downloads/chromedriver");
    WebDriver driver = new ChromeDriver();
    
    driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();
    
    AmazonCategorySearch page = PageFactory.initElements(driver, AmazonCategorySearch.class);

    String AppleModel = "";
   page.insertRecord1(AppleModel);
}
}