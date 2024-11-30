package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.STATUS;

public class ApiSpec {
    public static RequestSpecification simpleRequestSpecification = with()
            .filter(withCustomTemplates())
            .log().uri()
            .baseUri("https://www.rshb.ru");

    public static ResponseSpecification simpleResponseSpecification = new ResponseSpecBuilder()
            .log(STATUS)
            .build();
}