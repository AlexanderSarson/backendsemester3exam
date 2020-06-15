/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.glassfish.grizzly.http.util.HttpStatus;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author root
 */
public class CourseResourceTest extends BaseResourceTest{
    
    public CourseResourceTest() {
    }

    @Test
    public void testGetAllCourses() {
        given()
                .contentType(ContentType.JSON)
                .get("course/all")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("size()", is(3));
    }
    
}
