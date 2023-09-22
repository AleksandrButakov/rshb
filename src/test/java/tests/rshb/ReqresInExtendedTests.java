package tests.rshb;

import helpers.CustomAllureListener;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import models.lombok.LoginBodyLombokModel;
import models.pojo.LoginBodyPojoModel;
import models.pojo.LoginResponsePojoModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.LoginSpec.loginRequestSpec;
import static specs.LoginSpec.loginResponseSpec;


public class ReqresInExtendedTests {

    @Test
    @Tag("api")
    void successfulLoginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        given()
                .log().uri()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    ////////////////////////////////////////////////

    @Test
    @Tag("api")
    void successfulLoginWithPojoTest() {
//        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        LoginBodyPojoModel loginBody = new LoginBodyPojoModel();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");

        LoginResponsePojoModel response = given()
                .log().uri()
                .body(loginBody)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponsePojoModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    @Tag("api")
    void successfulLoginWithLombokTest() {
//        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        LoginBodyLombokModel loginBodyLombok = new LoginBodyLombokModel();

        loginBodyLombok.setEmail("eve.holt@reqres.in");
        loginBodyLombok.setPassword("cityslicka");

        LoginResponsePojoModel response = given()
                .log().uri()
                .body(loginBodyLombok)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponsePojoModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    @Tag("api")
    void successfulLoginWithAllureLombokTest() {
//        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        LoginBodyLombokModel loginBodyLombok = new LoginBodyLombokModel();

        loginBodyLombok.setEmail("eve.holt@reqres.in");
        loginBodyLombok.setPassword("cityslicka");

        LoginResponsePojoModel response = given()
                .filter(new AllureRestAssured())
                .log().uri()
                .body(loginBodyLombok)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponsePojoModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    @Tag("api")
    void successfulLoginWithCustomAllureTest() {
        LoginBodyLombokModel loginBodyLombok = new LoginBodyLombokModel();
        loginBodyLombok.setEmail("eve.holt@reqres.in");
        loginBodyLombok.setPassword("cityslicka");

        LoginResponsePojoModel response = given()
                .filter(CustomAllureListener.withCustomTemplates())
                .log().uri()
                .body(loginBodyLombok)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponsePojoModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    @Tag("api")
    void successfulLoginWithAllureStepsTest() {
        step("Any steps here");
        LoginBodyLombokModel loginBodyLombok = new LoginBodyLombokModel();
        loginBodyLombok.setEmail("eve.holt@reqres.in");
        loginBodyLombok.setPassword("cityslicka");

        LoginResponsePojoModel response = step("Make request", () ->
                given()
                        .filter(CustomAllureListener.withCustomTemplates())
                        .log().uri()
                        .body(loginBodyLombok)
                        .contentType(ContentType.JSON)
                        .when()
                        .post("https://reqres.in/api/login")
                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(LoginResponsePojoModel.class));

//        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

        step("Verify response", () ->
                assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Tag("api")
    void successfulLoginWithAllureSpecsTest() {
        LoginBodyLombokModel loginBodyLombok = new LoginBodyLombokModel();
        loginBodyLombok.setEmail("eve.holt@reqres.in");
        loginBodyLombok.setPassword("cityslicka");

        LoginResponsePojoModel response = step("Make request", () ->
                given(loginRequestSpec)
                        .body(loginBodyLombok)
                        .when()
                        .post()
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginResponsePojoModel.class));

//        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

        step("Verify response", () ->
                assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4"));
    }



}