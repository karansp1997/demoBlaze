package util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;
import java.util.Map;


public class BaseHelper {

    public static WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Karan\\IdeaProjects\\demoBlaze\\src\\test\\java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoblaze.com");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void endOfTest() {
        driver.quit();
    }

    public WebElement findElement(By xPath) {
        return driver.findElement((xPath));
    }

    public void waitUntilPageLoaded() {
        JavascriptExecutor j = (JavascriptExecutor)driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Page has loaded");
        }
    }

    public void waitUntilElementDisplayed(By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    public JSONArray readTestData(String fileName, String key) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();


        try {
            Object fileObject = jsonParser.parse(new FileReader(fileName));
            jsonObject = (JSONObject) fileObject;
            jsonArray = (JSONArray) jsonObject.get(key);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }

}
