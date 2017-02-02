package pl.edu.pwr.carrierrental;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by lukasz on 2/1/17.
 */
public class SeleniumFirstTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        driver.get("http://localhost:3000");
        WebElement start = driver.findElement(By.tagName("pre"));
        assertThat(start.getText()).isEqualTo("npm run start:hmr");
    }

    @Test
    public void shouldSendKeysToInputBox(){
        driver.get("http://localhost:3000");
        WebElement element = driver.findElement(By.tagName("input"));
        element.sendKeys("Test");
        List<WebElement> pre = driver.findElements(By.tagName("pre"));
        System.out.printf("NOW TEST");
        pre.stream().forEach(i -> System.out.println(i.getText()));
    assertThat(pre.get(1).getText()).isEqualTo(String.format("this.localState = {\n" +
            "  \"value\":" +
            " \"Test\"\n" +
            "}"));
    }

    @Test
    public void shouldSendKeysToInputBoxAndClickButtonAndCheckValue() {
        driver.get("http://localhost:3000");
        WebElement element = driver.findElement(By.tagName("input"));
        element.sendKeys("Test1");
        driver.findElement(By.tagName("button")).click();
        List<WebElement> pre = driver.findElements(By.tagName("pre"));
        assertThat(pre.get(2).getText()).isEqualTo(String.format("this.appState.state = {\n" +
                "  \"value\":" +
                " \"Test1\"\n" +
                "}"));
    }
    @Test
    public void shouldSendKeysToInputBoxAndChangeLinkAndCheckString() {
        driver.get("http://localhost:3000");
        WebElement element = driver.findElement(By.tagName("input"));
        element.sendKeys("Kaczka");
        driver.findElement(By.tagName("button")).click();
        driver.findElements(By.tagName("a")).get(2).click();
        assertThat(driver.findElement(By.tagName("pre")).getText()).isEqualTo(String.format("this.appState.state = {\n" +
                "  \"value\":" +
                " \"Kaczka\"\n" +
                "}"));
    }

}
