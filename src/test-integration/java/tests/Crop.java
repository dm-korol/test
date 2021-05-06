package tests;

import com.dps.vo.CropVO;
import com.dps.vo.FieldVO;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static io.restassured.RestAssured.given;

public class Crop {

    @BeforeMethod
    public void createFiled() {
        var filed = new FieldVO();
        filed.setFieldId(15);
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

    @Test
    public void postCrop() {
        var date = LocalDateTime.now();
        var crop = new CropVO();
        crop.setFieldId(15);
        crop.setStartDate(date.toEpochSecond(ZoneOffset.MAX));
        crop.setCulture("Some sort of grass");
        crop.setType("Best grass in the world");
        crop.setCurrentStage(1);
        crop.setDepth(15);
        crop.setFngcd(true);
        crop.setRate(15);
        crop.setStrt(15);
        crop.setPod(15);

        given()
                .baseUri("http://localhost:8080")
                .basePath("/api/crop/")
                .accept("*/*")
                .contentType(ContentType.JSON)
        .when()
                .body(crop)
                .post()
        .then()
                .statusCode(201);
    }

}
