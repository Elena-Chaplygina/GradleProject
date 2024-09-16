import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class UiTest {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        System.out.println("Ui test start and finish");
    }

    @Tag("smoke")
    @Test
    void smokeTest() {
        open("https://www.google.com/");
        System.out.println("Ui test smoke start and finish");
    }
}


