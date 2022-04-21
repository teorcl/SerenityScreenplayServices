package co.com.sofka.setup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class SetUp {

    protected static final String URL_BASE_REQRES = "https://reqres.in/api";
    protected static final String RESOURCE_POST_CREATE_USER = "/users";
    protected static final String RESOURCE_LIST_USERS = "/users?page=2";
    protected static final String URL_BASE_JSON="https://jsonplaceholder.typicode.com";
    protected static final String RESOURCE_POST_JSON="/posts";
    protected static final String RESOURCE_PUT_JSON="/posts/1";

    protected final Actor actor = new Actor("Teo");

    protected void setupReqres () {
        actorCanReqres();
    }

    protected void setupJson () {
        actorCanJson();
    }

    private void actorCanReqres () {
        actor.can(CallAnApi.at(URL_BASE_REQRES));
    }

    private void actorCanJson () {
        actor.can(CallAnApi.at(URL_BASE_JSON));
    }

}
