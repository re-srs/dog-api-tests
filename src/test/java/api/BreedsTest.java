package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BreedsTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://dog.ceo/api";
        RestAssured.filters(new AllureRestAssured());

    }

    @Test
    public void deveListarTodasAsRacas() {

        given()
                .when()
                .get("/breeds/list/all")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", notNullValue());
    }

    @Test
    public void deveRetornarImagemAleatoria() {

        given()
                .when()
                .get("/breeds/image/random")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", containsString("http"));
    }

    @Test
    public void deveRetornarImagensDaRaca() {

        String breed = "hound";

        given()
                .when()
                .get("/breed/{breed}/images", breed)
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message.size()", greaterThan(0));
    }

    @Test
    public void deveRetornarErroParaRacaInvalida() {
        String breed = "abcxyz";

        given()
                .when()
                .get("/breed/{breed}/images", breed)
                .then()
                .statusCode(404)
                .body("status", equalTo("error"))
                .body("message", containsString("Breed not found"));
    }
}
