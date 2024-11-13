import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://finproyuliahapz.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("yuli@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("password")).sendKeys("yuli123");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String at = driver.getTitle();
        String et = "Vite + React";
        driver.close();

        if (at.equalsIgnoreCase(et)) {
            System.out.println("Test Successful");
        } else {
            System.out.println("Test Failure");
        }
    }
}