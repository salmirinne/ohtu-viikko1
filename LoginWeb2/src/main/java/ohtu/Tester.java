package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        /*
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        /*
        // oikea tunnus ja salasana
        System.out.println("==");
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        // oikea tunnus väärä salasana
        System.out.println("==");
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akke");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        // ei olemassaoleva tunnus
        System.out.println("==");
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkaaaa");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        */
        
        // uuden tunnuksen luominen
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkaaaaaa");
        element = driver.findElement(By.name("password"));
        element.sendKeys("moimoimoi0");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("moimoimoi0");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click(); 
        
        element = driver.findElement(By.linkText("logout"));       
        element.click(); 
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
    }
}
