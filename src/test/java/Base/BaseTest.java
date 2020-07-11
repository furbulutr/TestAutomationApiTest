package Base;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseTest extends BasePage {

    public static List<String> BySearch(){

        Response response = given()
                .param("apikey","c1bc82d9")
                .param("s","Harry Potter")
                .when()
                .log().all().get().prettyPeek()
                .then().statusCode(200).extract().response();

        Assert.assertFalse("Title yok!!", response.jsonPath().getString("Search.Title").equals(null));

        Assert.assertFalse("Year yok!!", response.jsonPath().getString("Search.Year").equals(null));


        int titleSize = Integer.parseInt(response.jsonPath().getString("Search.Title.size()"));
        int size = 0;
        String imdbId = null;
        String title = null;
        List<String> SorcererSizeList = new ArrayList<String>();


        while (size<titleSize){
            title = response.jsonPath().getString("Search.Title["+size+"]");

            if(title.contains("Harry Potter and the Sorcerer's Stone")){

                imdbId = response.jsonPath().getString("Search.imdbID["+size+"]");
                break;
            }

            size++;
        }

        SorcererSizeList.add(title);
        SorcererSizeList.add(imdbId);

        return SorcererSizeList;
    }

    public static void ByIdOrTitle(String imdbId,String title){

        Response response = given()
                .param("apikey","c1bc82d9")
                .param("i",imdbId)
                .param("t",title)
                .log().all().get().prettyPeek()
                .then()
                .statusCode(200).extract().response();

        Assert.assertFalse("Released yok!!", response.jsonPath().getString("Released").equals(null));

    }







}
