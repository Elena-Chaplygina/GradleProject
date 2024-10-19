package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class InternetMainPage {
    SelenideElement checkboxesButton = $x("//a[@href=\"/checkboxes\"]"),
            dropdownButton = $x("//a[@href=\"/dropdown\"]"),
            disappearingElementsButton = $x("//a[@href=\"/disappearing_elements\"]"),
            inputButton = $x("//a[@href=\"/inputs\"]");


    @Step("Пользователь нажал на кнопку 'DropDown' на главной странице")
    public InternetMainPage clickDropdownButton() {
        dropdownButton.should(visible).click();
        return this;
    }

    @Step("Пользователь нажал на кнопку 'Checkboxes' на главной странице")
    public InternetMainPage clickCheckboxesButton() {
        checkboxesButton.should(visible).click();
        return this;
    }

    @Step("Пользователь нажал кнопку 'Disappearing Elements' на главной странице")
    public InternetMainPage clickDisappearingElementsButton() {
        disappearingElementsButton.should(visible).click();
        return this;
    }

    @Step("Пользователь нажал кнопку 'Inputs' на главной странице")
    public InternetMainPage clickInputsButton() {
        inputButton.should(visible).click();
        return this;
    }
}