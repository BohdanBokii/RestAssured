package specRest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationsRest {
    public static RequestSpecification setReqSpec(String url){
        return  new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
    public static ResponseSpecification setResponceSpec200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification setResponceSpec201(){
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
    public  static void setSpecForRestAssured(RequestSpecification requestSpecification,ResponseSpecification responseSpecification){
        RestAssured.requestSpecification=requestSpecification;
        RestAssured.responseSpecification=responseSpecification;
    }

}
