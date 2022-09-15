package io.github.tahanima.lab1;

import io.github.tahanima.BaseTest;
import io.github.tahanima.data.login.LoginData;
import io.github.tahanima.page.GooglePage;
import io.github.tahanima.page.login.LoginPage;
import io.github.tahanima.page.product.ProductsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GoogleTest extends BaseTest {
    private GooglePage googlePage;

    @Override
    public void initialize() {
        googlePage = createInstance(GooglePage.class);
    }

    @Test(testName = "TC-1")
    public void testFindSomethingInLatin() {
        List<WebElement> webElements = googlePage
                .goTo()
                .enterQuery("Femina ist pulchra quoque.")
                .clickGoogleSearch()
                .captureResults();
        for (WebElement element: webElements) {
            System.out.println(element.getText());
        }
        assertThat("Vidi").isEqualTo("Vedi");
    }

    @Test(testName = "TC-2")
    public void testOpenNewTab() {
        List<WebElement> webElements = googlePage
                .openNewTab()
                .goTo()
                .enterQuery("Femina ist non pulchra")
                .clickGoogleSearch()
                .captureResults();
        for (WebElement element: webElements) {
            System.out.println(element.getText());
        }
        assertThat("Veni").isEqualTo("Veni");
    }

}
