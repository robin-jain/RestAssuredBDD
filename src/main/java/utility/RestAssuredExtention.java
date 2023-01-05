package utility;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtention {
    public static RequestSpecification Request;


    public RestAssuredExtention() {
        //Arrange
        try {


            RequestSpecBuilder builder = new RequestSpecBuilder();
            builder.setBaseUri("http://localhost:3000");
            builder.setContentType(ContentType.JSON);
            var requestSpac = builder.build();
            Request = RestAssured.given().spec(requestSpac);
        } catch (Exception e) {
            System.out.println("This is exception one" + e);
        }
    }

    public static void getOpsWithPathParameter(String url, Map<String, String> pathParameter) throws URISyntaxException {
        //Act
        Request.pathParams(pathParameter);
        Request.queryParams(pathParameter);
        Request.get(new URI(url));

    }

    public static ResponseOptions<Response> getOps(String url) throws URISyntaxException {
        //Act
        try {
            return Request.get(new URI(url));
        } catch (Exception e) {
            System.out.println("This is exception two ****" + e);
            Assert.fail();
            return null;

        }



    }
}