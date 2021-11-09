package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    /*
    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
    HTTP status kodunun 200
    Content Type’in Json
    Ve Status Line’in HTTP/1.1 200 OK
    Oldugunu test edin
     */

    @Test
    public void test01() {
        // 1- Api testi yaparken ilk olarak url(endpoint) belirlenmeli
        String url = "https://restful-booker.herokuapp.com/booking/3";

        // 2- beklenen sonuc (expected result) olusturulur.
        // ancak bu case de benden body dogrulamasi istenmedigi icin simdilik beklenen sonuc olusturmuyoruz.

        // 3- request gonder
        Response response = given().accept("application/json").
                            when().get(url);
    //  response.prettyPrint();

        // 4- actual result olustur
        //response boyd ile ilgili islem yapmayacagimiz icin simdilik ousturmayacagiz.

        // dogrulama yap(asseertion)
        System.out.println("Status code: " + response.getStatusCode());     // response dan gelen status code verir
        System.out.println("Content type: " + response.getContentType());   // response dan gelen content type verir
        System.out.println("Status line: " + response.getStatusLine());     // response dan gelen status line verir
        System.out.println("Headers= " + response.getHeaders());

        /*
        Assert.assertEquals(200, response.getStatusCode());
        // expected kismi bize task olarak verilen degerdir, actual kismi ise response dan donen degerdir.
        // status code int deger dondurur

        Assert.assertEquals("application/json; charset=utf-8", response.getContentType());
        Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        */

        response.
                then().
                assertThat().
                statusCode(200).contentType(ContentType.JSON).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
    }
}
