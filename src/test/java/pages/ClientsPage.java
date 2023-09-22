package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class ClientsPage {

    private final SelenideElement
    client_heading = $$(".clients__top-block__title").findBy(text("Наши клиенты")),
    career_footer = $$(".page-footer__links__title").findBy(text("Карьера"));

    public void checkingPageLoadingClients() {
        client_heading.shouldBe(visible);
        career_footer.shouldBe(visible);
    }

}
