package tests.rshb;

import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.ApiSpec.*;

public class MainPageApiTests {

    @Test
    @Tag("api")
    void checkMainPage() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkProducts() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/products/")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkSupport() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/support/")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkClients() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/clients/")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkPartners() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/partners/")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkCompany() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/company/")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkNews() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/events/news/")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkCareer() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/events/news/")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

}
