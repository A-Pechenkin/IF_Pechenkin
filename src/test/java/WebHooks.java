import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebHooks {

    public static WebDriver driver;

    @BeforeAll
    public static void initBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://edujira.ifellow.ru");
    }

    @AfterAll
    public static void afterTest(){
        driver.quit();
    }
}
