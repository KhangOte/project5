package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketplacePage {
    WebDriver driver;

    public MarketplacePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDocHistoryForecastBulk() {
        driver.findElement(By.xpath("//div//a[@href = 'https://openweathermap.org/api/history-forecast-bulk']")).click();
    }

    public void clickDocHistoryBulk() {
        driver.findElement(By.xpath("//div//a[@href = 'https://openweathermap.org/history-bulk']")).click();
    }

    public void clickPlaceOrderHistoryBulk() {
        driver.findElement(By.xpath("//div//a[@href = '/history_bulks/new' and @class = 'button-round dark']")).click();
    }

    public void clickPlaceOrderHistoryForecastBulk() {
        driver.findElement(By.xpath("//div//a[@href = '/history_forecast_bulks/new' and @class = 'button-round dark']")).click();
    }

}
