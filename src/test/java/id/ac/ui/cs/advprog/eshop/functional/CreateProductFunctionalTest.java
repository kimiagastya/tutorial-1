package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By; // Note: Corrected import statement
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // Note: Corrected import statement
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals; // Note: Corrected import statement
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int port;

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private  String baseUrl;

    @BeforeEach
    void setupTest() {
        // Set up Selenium WebDriver
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void createProduct_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement lihatProdukButton = driver.findElement(By.className("btn"));
        lihatProdukButton.click();

        WebElement createProductButton = driver.findElement(By.className("btn"));
        createProductButton.click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/create", currentUrl);

        WebElement nameInput=driver.findElement(By.id("nameInput"));
        nameInput.clear();
        String productNameInput="Porsche 911 GT3 RS";
        nameInput.sendKeys(productNameInput);

        WebElement quantityInput=driver.findElement(By.className("quantityInput"));
        quantityInput.clear();
        String quantity="1";
        quantityInput.sendKeys(quantity);

        WebElement submitProductButton = driver.findElement(By.className("btn"));
        submitProductButton.click();

        currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/list", currentUrl);

        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));

        String productName = columns.get(0).getText();
        assertEquals("Porsche 911 GT3 RS", productName);

        String productQuantity = columns.get(1).getText();
        assertEquals("1", productQuantity);
    }
}