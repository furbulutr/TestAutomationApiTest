package Test;

import Base.BasePage;
import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestRun extends BaseTest {



    @Test
    public void ApiScenario(){

        System.out.println("***********By Search************");
        List<String> List = BySearch();

        System.out.println("***********By Id Or Title************");
        ByIdOrTitle(List.get(1), List.get(0));


    }
}
