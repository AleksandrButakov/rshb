package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class PartnersPage {

    private final SelenideElement
            partnerships_heading = $$(".title").findBy(text("Партнерские отношения с NAUMEN")),
            partners_block_title = $$(".block__title").findBy(text("Партнерам"));

    public void checkingPageLoadingPartners() {
        partnerships_heading.shouldBe(visible);
        partners_block_title.shouldBe(visible);
    }

}
