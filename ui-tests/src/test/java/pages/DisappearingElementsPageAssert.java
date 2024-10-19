package pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.visible;

public class DisappearingElementsPageAssert extends AbstractAssert<DisappearingElementsPageAssert, DisappearingElementsPage> {

    public DisappearingElementsPageAssert(DisappearingElementsPage actual) {
        super(actual, DisappearingElementsPageAssert.class);
    }

    public static DisappearingElementsPageAssert assertThat(DisappearingElementsPage actual) {
        return new DisappearingElementsPageAssert(actual);
    }

    public DisappearingElementsPage page() {
        return actual;
    }


    @Step("Пользователь видит заголовок Disappearing Elements на странице https://the-internet.herokuapp.com/disappearing_elements")
    public DisappearingElementsPageAssert checkTitleDisappearingElements() {
        actual.disappearingElementsTitle.should(visible);
        return this;
    }

    @Step("На странице {value} элементов")
    public DisappearingElementsPageAssert checkElementsCount(int value) {
        actual.elements.should(CollectionCondition.size(value));
        return this;
    }

}
