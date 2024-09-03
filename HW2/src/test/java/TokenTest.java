import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TokenTest {

    @Test
    public void getToken() {
        RestAssured.baseURI = GlobalContrains.BASE_URI_CORECTT;
        RequestSpecification httpReq = given().log().all()
                .contentType("application/json")
                .header("lang", "vi")
                .header("clientIp", "127.0.0.1")
                .header("version", "1.0.0")
                .body("{}");

        Response response = httpReq.when().post(EndPointGlobal.EP_TOKEN_CORECTT);
        response.then().assertThat().statusCode(200);

        // In kết quả từ response dưới dạng JSON
        response.prettyPrint();

        // Kiểm tra mã trạng thái của phản hồi
        assertEquals(response.getStatusCode(), 200);
    }
}
