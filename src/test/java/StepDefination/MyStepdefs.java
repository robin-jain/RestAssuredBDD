package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utility.RestAssuredExtention;

import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


public class MyStepdefs {
    private static ResponseOptions<Response> response;
    @Given("Perform get operation for {string}")
    public void performGetOperationFor(String url) throws URISyntaxException {
       //given().contentType(ContentType.JSON);
        response=RestAssuredExtention.getOps(url);
        System.out.println("This is first step");
    }

    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String postnum) {
        //then().body("author",is ("Karthi kk ");
      try {
          assertThat(response.getBody().jsonPath().get("author"), hasItem(postnum));
          System.out.println("This is third step");
      }
      catch (Exception e){
          System.out.println(e);
      }

      }

    @And("I perform the operation on post number {string}")
    public void iPerformTheOperationOnPostNumber(String postnum) {
        //when().get(String.format("http://localhost:3000/%s",postnum));
        System.out.println("This is second step");

    }
}
