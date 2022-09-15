package io.github.tahanima.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class VolarisPage extends BasePage {
    @FindBy(id = "em__b-UID__booking-origin")
    private WebElement txtBookingOrigin;

    @FindBy(id = "em__b-UID__booking-destination")
    private WebElement txtBookingDestination;

    @FindBy(id = "em__b-UID__booking-departure")
    private WebElement txtBookingDeparture;

    @FindBy(id="em__b-UID__booking-return")
    private WebElement txtBookingReturn;

    @FindBy(className="Booking_submitButton")
    private WebElement btnSubmit;

    public VolarisPage goTo() {
        getDriver().get("https://flights.volaris.com/es-mx/");
        return this;
    }

    public VolarisPage enterOrigin(final String origin) {
        txtBookingOrigin.sendKeys(origin);
        txtBookingOrigin.sendKeys(Keys.ENTER);
        return this;
    }

    public VolarisPage enterDestination(final String destination) {
        txtBookingDestination.sendKeys(destination);
        txtBookingDestination.sendKeys(Keys.ENTER);
        return this;
    }

    public VolarisPage enterDeparture(final LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtBookingDeparture.sendKeys(dateTimeFormatter.format(date));
        txtBookingDestination.sendKeys(Keys.ENTER);
        return this;
    }

    public VolarisPage enterReturn(final LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtBookingReturn.sendKeys(dateTimeFormatter.format(date));
        txtBookingReturn.sendKeys(Keys.ENTER);
        return this;
    }

    public VolarisPage submit() {
        btnSubmit.click();
        return this;
    }

}