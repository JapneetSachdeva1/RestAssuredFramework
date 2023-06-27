package testAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;

public class GetRequest {
    @Test
    public void getRqstStatusCode() {
        String user_id = "test_user";
      ValidatableResponse rs =  RestAssured.given().
                baseUri("https://todo.pixegami.io")
                .contentType(ContentType.JSON).
                when().
                get("/list-tasks/"+user_id).
                then().
                log()
                .all()
                .assertThat()
                .statusCode(200).body("tasks[0].task_id", is(equalTo("task_148131f0c2f64cee89d25d80dcfa92c7")))
                .body("tasks.user_id", hasItems("test_user"))
              .body("tasks.size()", is(equalTo(10)));


    }
}
