package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElementsPage {
    SelenideElement disappearingElementsTitle = $x("//h3[text()='Disappearing Elements']");
    ElementsCollection elements = $$x("//ul/li");

    public DisappearingElementsPageAssert check() {
        return DisappearingElementsPageAssert.assertThat(this);
    }


}
