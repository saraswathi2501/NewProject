package org.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
  public static WebDriver driver;
  
  public static WebDriver chromeBrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
   	return driver;	
}
  public static void urlLaunch(String url) {
	driver.get(url);
}
  public static void maximize() {
	driver.manage().window().maximize();
} 
  public static void implicitWait(long secs) {
    driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
}
  public static void sendkeys(WebElement e, String Value) {
  e.sendKeys(Value);
}
  public static void click(WebElement e) {
	e.click();
}
  public static String currentUrl( ) {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
  public static String title( ) {
		String title = driver.getTitle();
		return title;
	}
  public static void quit() {
		driver.quit();
	}
  public static void close() {
		driver.close();
	}
               //Xpath
  public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
  public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
  public static String getAttribute1(WebElement e) {
		String attribute1 = e.getAttribute("innertext");
		return attribute1;
	}
  				//Action Class
  
  public static void moveToElement(WebElement target) {
	Actions a =new Actions(driver);
	a.moveToElement(target).click().perform();
}
  public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a =new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
  public static void clickAndHold(WebElement source, WebElement target) {
		Actions a =new Actions(driver);
		a.clickAndHold(source).moveToElement(target).release().build().perform();
	}
  public static void clickAndHold1(WebElement source, WebElement target) {
		Actions a =new Actions(driver);
		a.clickAndHold(source).release(target).build().perform();
	}
  public static void doubleClick( WebElement target) {
		Actions a =new Actions(driver);
		a.doubleClick(target).perform();
	}
  public static void contextClick( WebElement target) {
		Actions a =new Actions(driver);
		a.contextClick(target).perform();
	}
  
  				//Robot Class
  
  public static void robotClassDown() throws AWTException {
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
}
  public static void tab() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
  
  public static void controlA() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		
	}
  public static void controlv() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
	}
  public static void robotClassEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
  public static void robotSendKeys(WebElement e, String value, WebElement e1) {
		Actions a=new Actions(driver);
		a.keyDown(e,Keys.SHIFT).sendKeys(value).keyUp(e1, Keys.SHIFT).build().perform();
	}
  
  				// Alert
  public static void alertAccept() {
	  Alert a = driver.switchTo().alert();
	  String t1 = a.getText();
	  System.out.println(t1);
	  a.accept();
}
  public static void alertDismiss() {
	  Alert a = driver.switchTo().alert();
	  String t1 = a.getText();
	  System.out.println(t1);
	  a.dismiss();
}

                //DropDown
  public static void selectByIndex(WebElement e,int i) {
		Select s =new Select(e);
		s.selectByIndex(i);
	}
  public static void selectByValue(WebElement e) {
		Select s =new Select(e);
		s.selectByValue("value");
	}
  public static void selectByVisibleText(WebElement e) {
		Select s =new Select(e);
		s.selectByValue("value");
	}
  public static void isMultiple(WebElement e) {
	  Select s =new Select(e);
	  boolean mul = s.isMultiple();
	  System.out.println(mul);
}
  
  public static void getOptions(WebElement e) {
	  Select s =new Select(e);
	  List<WebElement> options = s.getOptions();
	  for(int i=0;i<options.size();i++) {
	  WebElement ele = options.get(i);
	  String text = ele.getText();
      System.out.println(text);
	  }
}
  public static void getOptions1(WebElement e) {
	  Select s =new Select(e);
	  List<WebElement> options = s.getOptions(); //forEach
	  for(WebElement x:options) {
		  System.out.println(x);
	  }
  }
  public static void getFirstSelectedOptions(WebElement e) {
	  Select s =new Select(e);
	  WebElement firstSel = s.getFirstSelectedOption();
	  String t = firstSel.getText();
	  System.out.println(t);
}
  public static void getAllSelectedOptions(WebElement e) {
	  Select s =new Select(e);
	  List<WebElement> allSel = s.getAllSelectedOptions();
	  for(WebElement x:allSel) {
		  System.out.println(x);
	  }
}
  public static void deSelectByIndex(WebElement e, int i) {
	  Select s =new Select(e);
	  s.deselectByIndex(i);
}
  public static void deSelectByValue(WebElement e) {
		Select s =new Select(e);
		s.deselectByValue("value");;
	}
  public static void deSelectByVisibleText(WebElement e) {
		Select s =new Select(e);
		s.deselectByVisibleText("value");
	}
  public static void deSelectAll(WebElement e) {
	Select s =new Select(e);
	s.deselectAll();
}
                     //ScreenShot
  public static void getScreenShot() throws IOException {
  TakesScreenshot tk=(TakesScreenshot)driver;
  File scr = tk.getScreenshotAs(OutputType.FILE);
  System.out.println(scr);
  long sec=System.currentTimeMillis();
  File des=new File("E:\\Selenium\\screenshot\\image"+sec+".png");
  FileUtils.copyFile(scr, des);
}
  					//JavaScript
  public static void jssetAttribute(String value, WebElement e) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].setAttribute('value', '"+value+"' )",e);
}
  public static void jsgetAttribute(String value, WebElement e) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  String string = js.executeScript("return arguments[0].getAttribute('value')",e).toString();
	  System.out.println(string);
}
  public static void clicks (WebElement e) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript(" arguments[0].click()",e); 
}
  public static void scrolldown (WebElement e) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript(" arguments[0].scrollIntoView(true)",e); 
}
  public static void scrollup (WebElement e) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript(" arguments[0].scrollIntoView(false)",e); 
}
  
  					//Frames
  public static void frameByIndex(int i) {
	driver.switchTo().frame(i);
}
  public static void frameByName(String name) {
		driver.switchTo().frame("value");
	} 
  public static void defaultContent() {
		driver.switchTo().defaultContent();
	} 
        //WindowsHandling
  public static void WindowsHandling(int i) {
	//Parent id
	  String parentId = driver.getWindowHandle();
	  System.out.println(parentId);
	//All id  
	  Set<String> allId = driver.getWindowHandles();
	  System.out.println(allId);
	  
	  //Set to List
	  List<String> li=new ArrayList();
	  li.addAll(allId);
	  driver.switchTo().window(li.get(i));
}
                  //Navigation Commands
  public static void toUrl(String url) {
	driver.navigate().to(url);
}
  public static void back() {
	driver.navigate().back();
}
  public static void forward() {
	driver.navigate().forward();
}
  public static void refresh() {
	driver.navigate().refresh();
}
  public static void isDisplayed(WebElement e) {
	boolean dis = e.isDisplayed();
	System.out.println(dis);
}
  public static void isEnabled(WebElement e) {
		boolean enable = e.isEnabled();
		System.out.println(enable);
	}
  public static void isSelected(WebElement e) {
		boolean sele = e.isSelected();
		System.out.println(sele);
	}
  
                 //WebTable
  
  public static void getAllValuesinTable(WebElement e) {
	String text = e.getText();
	System.out.println(text);
}
  public static void allHeadins(WebElement e) {
	List<WebElement> heads = e.findElements(By.tagName("th"));
	for(int i=0;i<heads.size();i++) {
		WebElement head = heads.get(i);
		String t1 = head.getText();
		System.out.println(t1);
	}
}
  public static void allDatas(WebElement e) {
		List<WebElement> data = e.findElements(By.tagName("td"));
		for(int i=0;i<data.size();i++) {
			WebElement data1 = data.get(i);
			String t1 = data1.getText();
			System.out.println(t1);
		}
	}
  public static void allRows(WebElement e) {
		List<WebElement> rows = e.findElements(By.tagName("tr"));
		for(int i=0;i<rows.size();i++) {
			WebElement row = rows.get(i);
			String t1 = row.getText();
			System.out.println(t1);
		}
	}
//  public static String getExcel(String filename, String sheet, int cell, int row) throws IOException {
//	  File f=new File("C:\\Users\\Balaji\\eclipse-workspace\\MavenProjects\\src\\test\\resources\\"+filename+".xlsx");
//
//		FileInputStream fi=new FileInputStream(f);
//		Workbook w=new XSSFWorkbook(fi);
//		Sheet r = w.getSheet(sheet);
//		Row c = r.getRow(row);
//		Cell c1 = c.getCell(cell);
//		int type=c1.getCellType();
//		String value;
//		if(type==1) {
//			 value = c1.getStringCellValue();
//			System.out.println(value);
//		}else {
//			if(DateUtil.isCellDateFormatted(c1)) {
//				Date d = c1.getDateCellValue();
//				SimpleDateFormat s=new SimpleDateFormat("dd-MM-yy");
//				 value = s.format(d);
//				System.out.println(value);
//			}
//			else {
//				double d = c1.getNumericCellValue();
//				long l=(long)d;
//				 value = String.valueOf(l);
//				System.out.println(value);
//			}
//		}
//		return value;
//}
  
}
