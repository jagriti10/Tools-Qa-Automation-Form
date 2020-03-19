package toolsQa;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class toolsQa {
	 static WebDriver driver;
	public static void main(String[] args) {
	       System.setProperty("webdriver.chrome.driver","C:/Users/jagriti.sharma/selenium/chromedriver/chromedriver.exe");
	       driver = new ChromeDriver();
	       driver.manage().window().maximize();

	       driver.get("https://www.toolsqa.com/automation-practice-form/");
	       String parent = driver.getWindowHandle();
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	     
	       //WebDriverWait wait=new WebDriverWait(driver,40);
	       driver.findElement(By.xpath("//*[@id=\"cookie_action_close_header\"]")).click();

	  
	      WebElement nextlink= driver.findElement(By.linkText("Link Test"));
	      nextlink.click();
	  
	       driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
	       
	       WebElement fn = driver.findElement(By.name("firstname")); //first name
	       fn.sendKeys("ABCDEFGH");
           WebElement ln = driver.findElement(By.id("lastname"));//ln
           ln.sendKeys("IJKLMNOP");	    
           
           //genders male and female
           WebElement male_radio1 = driver.findElement(By.id("sex-0"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sex-0")));
           male_radio1.click();
           
           //experience
           WebElement exp0= driver.findElement(By.id("exp-0"));
           exp0.click();
           
	       // date 
	       WebElement datepicker= driver.findElement(By.id("datepicker")); 
	       datepicker.sendKeys("13 feb 2020");
           
	       //profession check-box
	       WebElement profession1= driver.findElement(By.id("profession-1"));
	       profession1.click();
           
	       //file upload
	       WebElement upload= driver.findElement(By.id("photo"));
	       upload.sendKeys("C:/Users/mansi.sharma1/Desktop/Capture.png");
	          
	       //link downloads file
	       WebElement linktext = driver.findElement(By.linkText("Selenium Automation Hybrid Framework"));
           linktext.click();
	       
	       // tool selection check-box
	        driver.findElement(By.id("tool-1")).click();  
	        
	        //list selection continents
	        Select dropdown = new Select(driver.findElement(By.id("continents")));
	        dropdown.selectByVisibleText("Europe");
	        WebElement sel= dropdown.getFirstSelectedOption();
	        String selected= sel.getText();
	        System.out.println("continent(1) -->  "+selected);
	        
	        //multiple choice selection 
	        Select dropdownMultiple = new Select(driver.findElement(By.id("continentsmultiple")));
	        dropdownMultiple.selectByVisibleText("Asia");
	        dropdownMultiple.selectByIndex(2);
	        List <WebElement> elementCount = dropdownMultiple.getOptions();
	        int n = elementCount.size();
	        for(int i =0; i<n ; i++){
	        String value = elementCount.get(i).getText();
	        System.out.println("value "+i+ "= " +value);
	        }
	   	        
	        List <WebElement> sel1= dropdownMultiple.getAllSelectedOptions();
             for(WebElement t : sel1)
             {
            	 String txt = t.getText();
 		        System.out.println("continent(many) value -->  "+txt);

             }

	        //commands selection
	        Select seleniumcmds = new Select(driver.findElement(By.id("selenium_commands")));
	        seleniumcmds.selectByVisibleText("Navigation Commands");
	
	        }
	 }

