package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Live {

    @Test
    public void getLive() {

        given()
                .baseUri("http://localhost:8080")
                .basePath("/api/live/")
                .accept("*/*")
                .contentType(ContentType.JSON)
        .when()
                .get()
        .then()
                .statusCode(200);
    }
}