package multibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTesting {
    static WebDriver driver;
    static String browser = "Chrome"; // change it to Firefox or Edge

    //Setup Chrome browser//
    static String baseUrl = " https://courses.ultimateqa.com/";

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser name ");
        }

        //Get baseURL
        driver.get(baseUrl);


        //Print the title of the page//
        System.out.println("Title of the page : " + driver.getTitle());

        //Print current url
        System.out.println("The current Url is : " + driver.getCurrentUrl());

        //print the page source code
        System.out.println(driver.getPageSource());

        //click on Sign in link
        WebElement signLink = driver.findElement(By.partialLinkText("Sign In"));
        signLink.click();

        //print the current url after clicking sing in page

        System.out.println("Current url after clicking sign in :" + driver.getCurrentUrl());

        //Enter email to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("prexastudy@gmail.com");

        //Enter password to password field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("Abcd1234");

        //click on the login button
        WebElement signInButton = driver.findElement(By.className("sign-in-page"));
        signInButton.click();

        //navigate back to baseurl

        driver.get(baseUrl);

        //refresh the page

        driver.navigate().refresh();

        //close the browser
        driver.quit();


    }
}