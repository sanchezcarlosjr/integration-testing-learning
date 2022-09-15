package io.github.tahanima.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public final class GooglePage extends BasePage {
    @FindBy(name = "q")
    private WebElement txtSearch;

    public GooglePage goTo() {
        getDriver().get("https://www.google.com/");
        return this;
    }

    public GooglePage enterQuery(final String query) {
        txtSearch.clear();
        txtSearch.sendKeys(query);
        return this;
    }

    public GooglePage clickGoogleSearch() {
        txtSearch.submit();
        return this;
    }

    public GooglePage openNewTab() {
        getDriver().switchTo().newWindow(WindowType.TAB);
        return this;
    }

    public List<WebElement> captureResults() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
        return getDriver().findElements(By.tagName("h3"));
    }

}
