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
    void checkMainPageLinkNatural() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/natural")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkBusiness() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/business")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkFarmers() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/farmers")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkSvoe() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/svoe")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

    @Test
    @Tag("api")
    void checkMainPageLinkAbout() {
        Response response = step("Make get request", () ->
                given(simpleRequestSpecification)
                        .basePath("/about")
                        .get()
                        .then()
                        .spec(simpleResponseSpecification)
                        .extract().response());

        step("Verification statusCode", () ->
                assertThat(response.statusCode()).isEqualTo(200));
    }

}