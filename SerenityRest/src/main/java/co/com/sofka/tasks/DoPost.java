package co.com.sofka.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class DoPost implements Task {

    private String resource;
    private String bodyResquest;

    public DoPost toRecourse(String resource){
        this.resource = resource;
        return this;
    }

    public DoPost whitBodyRequest(String bodyResquest){
        this.bodyResquest = bodyResquest;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .body(bodyResquest))
        );
    }

    public static DoPost doPost(){
        return new DoPost();
    }

}
