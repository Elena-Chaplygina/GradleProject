package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.visible;

public class DropdownPageAssert extends AbstractAssert<DropdownPageAssert, DropdownPage> {
    public DropdownPageAssert(DropdownPage actual) {
        super(actual, DropdownPageAssert.class);
    }

    public static DropdownPageAssert assertThat(DropdownPage actual) {
        return new DropdownPageAssert(actual);
    }

    public DropdownPage page() {
        return actual;
    }

    @Step("Пользователь видит заголовок Dropdown List на странице https://the-internet.herokuapp.com/dropdown")
    public DropdownPageAssert checkTitleDropdown() {
        actual.dropdownTitle.should(visible);
        return this;
    }

    @Step("Пользователь видит в dropdown {value}")
    public DropdownPageAssert checkTextInDropdown(String value) {
        actual.select.should(Condition.text(value));
        return this;
    }

}
