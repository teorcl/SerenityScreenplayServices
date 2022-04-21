package co.com.sofka.stepdefinitions;

import co.com.sofka.models.modelswithjsonschematopojo.Datum;
import co.com.sofka.models.modelswithjsonschematopojo.ResponseGetUsersList;
import co.com.sofka.questions.ResponseListUsersQuestion;
import co.com.sofka.setup.SetUp;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import java.util.List;

import static co.com.sofka.questions.ResponseListUsersQuestion.resultGetListUsers;
import static co.com.sofka.tasks.DoGet.doGet;

public class GetUserSteps extends SetUp {

    private ResponseGetUsersList responseGetUsersList;
    public static Logger LOGGER = Logger.getLogger(RegisterUserSteps.class);
    private Gson gson;

    @Given("quiero conocer información de los usuarios en la DB")
    public void quieroConocerInformaciónDeLosUsuariosEnLaDB() {
        try {
            super.setupReqres();
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }
    @When("se consume el servicio mediante una petición get")
    public void seConsumeElServicioMedianteUnaPeticiónGet() {
        try {
            actor.attemptsTo(
                    doGet().toResource(RESOURCE_LIST_USERS)
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }

    }
    @Then("se visualizarán todos los usuarios")
    public void seVisualizaránTodosLosUsuarios() {
        //gson = new Gson();
        //System.out.println(gson.toJson(new ResponseListUsersQuestion().answeredBy(actor)));
        //responseGetUsersList = new ResponseListUsersQuestion().answeredBy(actor);
        //responseGetUsersList = resultGetListUsers().answeredBy(actor);
        //System.out.println("=====**********========+++++++++"+users);
        LOGGER.warn("======================");
        List<Datum> listUsers = resultGetListUsers().answeredBy(actor).getData();
        System.out.println("Lista================================="+listUsers.toArray().length);

    }


}
