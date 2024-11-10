import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    WebDriver driver;

    public void launchBrowser() {
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("WebDriver.chrome.driver", "/path/to/chromedriver");

            // Initialize a new ChromeDriver instance
            driver = new ChromeDriver();

            // Navigate to the login page
            driver.get("https://finproyuliahapz.vercel.app/");
            driver.manage().window().maximize();

            // Enter the email address
            driver.findElement(By.id("email")).sendKeys("yuli@gmail.com");

            // Enter the password
            driver.findElement(By.id("password")).sendKeys("yuli123");

            // Click the submit button
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Verification Method 1: Check the page title
            String actualTitle = driver.getTitle();
            String expectedTitle = "PhotoShare";

            if (actualTitle.equalsIgnoreCase(expectedTitle)) {
                System.out.println("Test Login Successful based on Title Check");
            } else {
                System.out.println("Title Check Failed");
            }

            // Verification Method 2: Check the URL
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://finproyuliahapz.vercel.app/explore"; // Replace with actual post-login URL
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Test Login Successful based on URL Check");
            } else {
                System.out.println("URL Check Failed");
            }

            // Verification Method 3: Check for a unique element after login
            // Replace 'uniqueDashboardElementId' with an actual ID or class present only on the dashboard page
            try {
                WebElement dashboardElement = driver.findElement(By.id("uniqueDashboardElementId"));
                if (dashboardElement.isDisplayed()) {
                    System.out.println("Test Login Successful based on Dashboard Element Check");
                } else {
                    System.out.println("Dashboard Element Check Failed");
                }
            } catch (Exception e) {
                System.out.println("Dashboard Element Check Failed - Element not found");
            }

            // Close the browser
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.launchBrowser();
    }
}
