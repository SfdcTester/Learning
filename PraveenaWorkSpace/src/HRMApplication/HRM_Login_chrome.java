package HRMApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HRM_Login_chrome 
{
	public static void main(String[] args) 
	{
		System.setProperty("firefox.gecko.driver", "C:\\Users\\Lab\\Downloads\\geckodriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//implicit wait command
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		//Verify Home page displayed
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("Title is displayed");
		}
		else
		{
			System.out.println("Unable to open HRM Application");
		}
		
		//----------------------------------------------------------------------
		WebElement objUserName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='Table_01']/descendant::input[@class='loginText']")));
		WebElement objPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='Table_01']/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/input")));
		WebElement objLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@valign='bottom']/input")));
		WebElement objClear = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/form/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/input")));
		//-----------------------------------------------------------------------
		
		//Verify UserName 
		if(objUserName.isDisplayed())
		{
			System.out.println("UserName is diplayed");
		}
		
		//Verify Password displayed
		if(objPassword.isDisplayed())
		{
			System.out.println("Password Displayed");
		}
		
		//Verify Login
		if(objLogin.isDisplayed())
		{
			System.out.println("Login button is displayed");
		}
		
		//Verify Clear
		if(objClear.isDisplayed())
		{
			System.out.println("Clear button is displayed");
		}
		
		//----------------------------------------------------------
		String strUserName="qaplanet1";
		String strPassword="user1";
		//----------------------------------------------------------
		
		//Enter valid UN,PWD
		objUserName.clear();
		objUserName.sendKeys(strUserName);
		objPassword.clear();
		objPassword.sendKeys(strPassword);
		//Click on Login
		objLogin.click();
		
		//Verify OrangeHRM page displayed
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{
			System.out.println("Logged in Successfully.");
		}
		else
		{
			System.out.println("Unable to Login");
		}
		
		//Verify welcome msg"
		//wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//ul[@id='option-menu']/li"), "Welcome qaplanet1"));
		
		String WelText= driver.findElement(By.xpath("//ul[@id='option-menu']/li")).getText();
		if(WelText.equals("Welcome " + strUserName))
		{
			System.out.println(WelText+ "Displayed");
		}
		
		//Verify Change Password
		WebElement lnkchangePwd= driver.findElement(By.xpath("//ul[@id='option-menu']/li[2]/a"));
		String strchangePwd = lnkchangePwd.getText();
		if(lnkchangePwd.isDisplayed())
		{
			System.out.println(strchangePwd);
		}
		
		//Verify Logout
		WebElement Logout = driver.findElement(By.linkText("Logout"));
		if(Logout.isDisplayed())
		{
			System.out.println("Logout is displayed");
		}

		
	}
}
