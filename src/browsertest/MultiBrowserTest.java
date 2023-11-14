package browsertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Firefox";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser name");
        }
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //launch the Chrome Browser


        //open the URL into b
        driver.get(baseUrl);
        // Maximise the browser
        driver.manage().window().maximize();

        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
