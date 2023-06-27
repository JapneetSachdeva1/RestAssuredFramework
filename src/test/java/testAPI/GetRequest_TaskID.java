package testAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.hasItem;

public class GetRequest_TaskID
{
    @Test
    public void getRqstStatusCode() {
        String task_id = "task_148131f0c2f64cee89d25d80dcfa92c7";
        ValidatableResponse rs =  RestAssured.given().
                baseUri("https://todo.pixegami.io")
                .contentType(ContentType.JSON).
                when().
                get("/get-task/"+task_id).
                then().
                log()
                .all()
                .assertThat()
                .statusCode(200).body("task_id", hasItem("task_148131f0c2f64cee89d25d80dcfa92c7"));

        //.body("task_id", hasItem("task_148131f0c2f64cee89d25d80dcfa92c7"))


    }
}
