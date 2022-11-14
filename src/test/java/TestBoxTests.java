import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Egor";
        String userEmail = "123@123.123";
        String currentAddress = "Adress 1";
        String permanentAddress = "Adress 2";

        open("/text-box");
        //<input autocomplete="off" placeholder="Full Name" type="text" id="userName" class=" mr-sm-2 form-control">
        $(by("id", "userName")).setValue(userName);
        //<input autocomplete="off" placeholder="name@example.com" type="email" id="userEmail" class="mr-sm-2 form-control">
        $(by("id", "userEmail")).setValue(userEmail);
        //<textarea placeholder="Current Address" rows="5" cols="20" id="currentAddress" class="form-control"></textarea>
        $x("//*[@id=\"currentAddress\"]").setValue(currentAddress);
        //<textarea rows="5" cols="20" id="permanentAddress" class="form-control"></textarea>
        $(by("id", "permanentAddress")).setValue(permanentAddress);
        //<button id="submit" type="button" class="btn btn-primary">Submit</button>
        $(by("id", "submit")).click();

        //<div id="output" class="mt-4 row">
        $(by("id", "output")).shouldBe(Condition.visible);
        //<p id="name" class="mb-1">
        $("#output #name").shouldHave(text(userName));
        //<p id="email" class="mb-1">
        $("#output #email").shouldHave(text(userEmail));
        //<p id="currentAddress"
        $("#output #currentAddress").shouldHave(text(currentAddress));
        //<p id="permanentAddress" class="mb-1">
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
