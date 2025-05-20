package ru.iFellow.API.Specifications;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.RequestSpecification;

public class Specifications {
    public static RequestSpecification baseRequestSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification baseResponseSpecSuccess(){
        return new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .build();
    }
}
