package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private final SelenideElement
            flagship_products = $$(".row-s-title").findBy(text("Флагманские продукты")),
            products_footer = $$(".page-footer__links__title").findBy(text("Продукты"));

    public void checkingPageLoadingProducts() {
        flagship_products.shouldBe(visible);
        products_footer.shouldBe(visible);
    }


}
