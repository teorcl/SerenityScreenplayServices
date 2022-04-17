package co.com.sofka.questions;

import co.com.sofka.models.BodyResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BodyResponseQuestion implements Question {
    @Override
    public BodyResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(BodyResponse.class);//Almacenar la respuesta en el modelo creado a partir del JSON tipo respuesta
    }

    public static Question<BodyResponse> bodyResponseWas(){
        return new BodyResponseQuestion();
    }
}
