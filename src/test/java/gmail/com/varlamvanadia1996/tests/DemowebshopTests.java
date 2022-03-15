package gmail.com.varlamvanadia1996.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

public class DemowebshopTests {
    @Test
    void addToCompareProductTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .get("http://demowebshop.tricentis.com/compareproducts/add/31")
                .then()
                .statusCode(200);
    }

    @Test
    void addToCartMoreMaxItemsTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=94f1f653-1710-4e36-b3f9-90f3b85e9f79;")
                .body("giftcard_2.RecipientName=Lena&giftcard_2.RecipientEmail=varlamvanadia%40mail.com&giftcard_2.SenderName=Nadya&giftcard_2.SenderEmail=varlamvanadia%40mail.com&giftcard_2.Message=Hello&addtocart_2.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/2/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(false))
                .body("message", hasItem("The maximum quantity allowed for purchase is 5."));
    }
}
