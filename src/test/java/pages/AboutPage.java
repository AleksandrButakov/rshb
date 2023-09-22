package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class AboutPage {

    private final SelenideElement
            figures_about_us_title = $$(".title").findBy(text("Цифры о нас")),
            products_footer = $$(".page-footer__links__title").findBy(text("Продукты"));

    public void checkingPageLoadingAbout() {
        figures_about_us_title.shouldBe(visible);
        products_footer.shouldBe(visible);
    }

}
