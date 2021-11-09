package com.techproed.day05;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest03 {

     /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"

ve firstname'in "Sally"
ve lastname'in "Ericsson"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */

    @Test
    public void test(){
        String url = "https://restful-booker.herokuapp.com/booking/7";
        Response response = given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();

        /*
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Susan")).
                body("lastname", Matchers.equalTo("Wilson")).
                body("totalprice",Matchers.equalTo(903)).
                body("depositpaid",Matchers.equalTo(true)).
                body("bookingdates.checkin",Matchers.equalTo("2021-01-30")).
                body("bookingdates.checkout",Matchers.equalTo("2021-07-30"));
         */

        // KISA YOL:

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname",equalTo("Susan"),
                        "lastname",equalTo("Wilson"),
                        "totalprice",equalTo(903),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2021-01-30"),
                        "bookingdates.checkout",equalTo("2021-07-30"));






    }
}
