package tests;

import com.dps.vo.FieldVO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Filed {

    @Test
    public void createFiled() {
        var filed = new FieldVO();
        filed.setFieldId(1);
        filed.setLatitude(14d);
        filed.setLongitude(17d);

        var response =
                given()
                    .baseUri("http://localhost:8080")
                    .basePath("/api/field/")
                    .accept("*/*")
                    .contentType(ContentType.JSON)
                .when()
                    .body(filed)
                    .post();

        response.then()
                .statusCode(201);
    }
}