package com.HMS.Generic.WebDriverUtilityTest;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void fullscreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	public void previousPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void nextPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void url(WebDriver driver, String Url) {
		driver.get(Url);
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}
	public WebDriver toLaunchBrowser(WebDriver driver,String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (Browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		} else{
			driver=new ChromeDriver();
		}
		return driver;
	}

	public void waitForPageLoad(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForAlert(WebDriver driver, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToBrowserByUrl(WebDriver driver, String PartialUrl) {

		Set<String> Window = driver.getWindowHandles();

		for (String ele : Window) {
			driver.switchTo().window(ele);
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.contains(PartialUrl)) {
				break;
			}
		}
	}

	public void switchToBrowserByTitle(WebDriver driver, String PartialTitle) {

		Set<String> Window = driver.getWindowHandles();

		for (String ele : Window) {
			driver.switchTo().window(ele);
			String currentUrl = driver.getTitle();
			if (currentUrl.contains(PartialTitle)) {
				break;
			}
		}
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();

	}

	public void clickAndHold(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold().perform();

	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	public void doubleClick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();

	}

	public void click(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();

	}

	public void click(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();

	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public void rightClick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();

	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();

	}

	public void sendValues(WebDriver driver, String Value) {
		Actions action = new Actions(driver);
		action.sendKeys(Value).perform();
	}

	public void sendValues(WebDriver driver, WebElement element, String Value) {
		Actions action = new Actions(driver);
		action.sendKeys(element, Value).perform();
	}
	
	public void scrollByValue(WebDriver driver,int x,int y) {
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).perform();
	}
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1500).perform();
		action.scrollToElement(element).perform();
	}

	public void selectByvalue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String Text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}

	public void deselectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	public void deselectByvalue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}

	public void deselectByVisibleText(WebElement element, String Text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(Text);
	}

	public void deselect(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}

	public void getAllOptions(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		for (WebElement option : options) {
			String text = option.getText();
			System.out.println(text);
		}
	}

	public void checkDropdown(WebElement element) {
		Select sel = new Select(element);
		boolean multiple = sel.isMultiple();
		if (multiple == true) {
			System.out.println("Dropdown is Multiple");
		} else {
			System.out.println("Dropdown is not Multiple");
		}

	}

	public void frameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void frameByName(WebDriver driver, String Name) {
		driver.switchTo().frame(Name);
	}

	public void frameByIndex(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void defaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void acceptPopup(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelPopup(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void takesScreenshotOfWebPage(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/" + name + ".jpeg");
		FileHandler.copy(source, dest);
	}

	public void takesScreenshotOfWebElement(WebDriver driver, WebElement element, String name) throws IOException {

		File source = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/" + name + ".jpeg");
		FileHandler.copy(source, dest);
	}
	public void clicktoElement(WebDriver driver,WebElement Element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Element);
		
	}
	public void passDatatoElement(WebDriver driver,WebElement Element,String value) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].value="+value,Element);
		
	}
	

}
