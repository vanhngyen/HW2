package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     */
    public void getToken() {
        RestAssured.baseURI = "https://smvab-test.epayjsc.com/vab/v2.0/account/get-token";
        RequestSpecification httpReq = given().log().all()
                .contentType(ContentType.JSON)
                .header("merchantCode", "MBG")
                .header("lang", "vi")
                .header("clientIp", "127.0.0.1")
                .header("version", "1.0.0")
                .body("{}");

        Response response = httpReq.when().post("paymentgateway/merchant/token");
        response.then().assertThat().statusCode(200);
    }


    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
