package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class ServicesPage {

    private final SelenideElement
    support_title = $$(".title").findBy(text("Поддержка")),
    company_footer = $$(".page-footer__links__title").findBy(text("Компания"));

    public void checkingPageLoadingServices() {
        support_title.shouldBe(visible);
        company_footer.shouldBe(visible);
    }

}
