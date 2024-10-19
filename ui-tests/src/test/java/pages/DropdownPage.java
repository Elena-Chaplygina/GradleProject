package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage {

    SelenideElement dropdownTitle = $x("//h3[text()='Dropdown List']"),
            select = $x("//select[@id=\"dropdown\"]");

    public DropdownPageAssert check() {
        return DropdownPageAssert.assertThat(this);
    }


    @Step("Пользователь выбрал в dropdown значение {i}")
    public DropdownPage selectItemInDropdown(int i) {
        select.selectOption(i);
        return this;
    }
}
