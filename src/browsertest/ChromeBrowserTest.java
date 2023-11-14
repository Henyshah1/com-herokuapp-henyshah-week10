package browsertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Open the URL into Browser
        driver.get(baseUrl);

        //Maximize the Browser
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);

        //Get the tittle of the page
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);

        String  loginUrl = "https://id.heroku.com/login";

        driver.navigate().to(loginUrl);
        System.out.println("Get current Url " + driver.getCurrentUrl());

        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        cookies.click();

        //Get page Source
        System.out.println(driver.getPageSource());

        //find email feild element and type the email
        WebElement emailFeild = driver.findElement(By.id("email"));
        emailFeild.sendKeys("abc123@gmail.com");
        Thread.sleep(5000);

        WebElement passwordFeild = driver.findElement(By.name("password"));
        passwordFeild.sendKeys("abc123");
        Thread.sleep(5000);


        WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/form/button"));
        login.click();

        //refresh
        Thread.sleep(5000);
        driver.navigate().refresh();

        //close
        driver.quit();


    }
}
