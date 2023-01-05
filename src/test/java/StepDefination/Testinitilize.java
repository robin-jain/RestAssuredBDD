package StepDefination;

import io.cucumber.java.Before;
import utility.RestAssuredExtention;

public class Testinitilize {

    @Before
    public void testSetup(){
        RestAssuredExtention restAssuredExtention=new RestAssuredExtention();
        System.out.println("This is Hook");
    }


}
