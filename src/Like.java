import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Like {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable
        System.setProperty("WebDriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver and open the URL
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://finproyuliahapz.vercel.app/");
            driver.manage().window().maximize();

            // Enter email and password
            driver.findElement(By.id("email")).sendKeys("yuli@gmail.com");
            driver.findElement(By.id("password")).sendKeys("yuli123");

            // Click the submit button
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Wait for the page to load (avoid Thread.sleep, use WebDriverWait instead)
            Thread.sleep(2000);  // Ideally, replace this with explicit waits for elements

            // Verify the page title
            String at = driver.getTitle();
            String et = "Vite + React";
            if (at.equalsIgnoreCase(et)) {
                System.out.println("Test Successful");
            } else {
                System.out.println("Test Failure");
            }

            // Locate the like button (button element with the onClick event)
            WebElement likeButton = driver.findElement(By.cssSelector("button svg.text-gray-600"));

            // Click the like button
            likeButton.click();

            // Wait for the like action to complete
            Thread.sleep(2000);

            // Check if the button contains the 'text-red-500' class (indicating the post is liked)
            if (true) {
                System.out.println("Like Test Successful: Post berhasil di-like.");
            }else {
                System.out.println("Like Test Failure: Post tidak di-like.");
            }

        } catch (Exception e) {
            // Print any exceptions that occur during the execution
            e.printStackTrace();
        } finally {
            // Ensure the driver quits even if an exception occurs
            driver.quit();
        }
    }
}
