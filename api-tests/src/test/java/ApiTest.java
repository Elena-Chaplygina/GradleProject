import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class ApiTest {
    @Test
    void successfulTest() {
        System.out.println("Api test start and finish");
    }

    @Tag("smoke")
    @Test
    void smokeTest() {
        System.out.println("Api test smoke start and finish");
    }
}


