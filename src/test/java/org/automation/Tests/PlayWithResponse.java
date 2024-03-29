package org.automation.Tests;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class PlayWithResponse {
    @Test
    public void ExtractResponse() {
        Response response = RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body("{\r\n" +
                        "    \"firstname\" : \"Amod\",\r\n" +
                        "    \"lastname\" : \"Mahajan\",\r\n" +
                        "    \"totalprice\" : 15,\r\n" +
                        "    \"depositpaid\" : false,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2021-01-01\",\r\n" +
                        "        \"checkout\" : \"2021-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Lunch\"\r\n" +
                        "}")
                .contentType(ContentType.JSON)
                // Hit the request and get the response
                .post();

        long responseTimeInMS = response.time();
        System.out.println("Response Time in MS : " + responseTimeInMS);

        long responseTimeInSeconds = response.timeIn(TimeUnit.SECONDS);
        System.out.println("Response time in seconds :" + responseTimeInSeconds);

        long responseTimeInMS1 = response.getTime();
        System.out.println("Response Time in MS 1 : " + responseTimeInMS1);

        long responseTimeInSeconds1 = response.getTimeIn(TimeUnit.SECONDS);
    }
}
