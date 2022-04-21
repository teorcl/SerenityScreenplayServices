package co.com.sofka.questions;

import co.com.sofka.models.modelswithjsonschematopojo.ResponseGetUsersList;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseListUsersQuestion implements Question {
    @Override
    public ResponseGetUsersList answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ResponseGetUsersList.class);
        //return SerenityRest.lastResponse().jsonPath().getObject("data",ResponseGetUsersList.class);
    }

    public static Question<ResponseGetUsersList> resultGetListUsers(){
        return new ResponseListUsersQuestion();
    }

}
