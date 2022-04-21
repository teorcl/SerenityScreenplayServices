package co.com.sofka.stepdefinitions;

import co.com.sofka.models.BodyResponse;
import co.com.sofka.models.BodyResquest;
import co.com.sofka.questions.BodyResponseQuestion;
import co.com.sofka.questions.ResponseCode;
import co.com.sofka.setup.SetUp;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserSteps extends SetUp {

    public static Logger LOGGER = Logger.getLogger(RegisterUserSteps.class);
    private BodyResquest bodyResquest;
    private Gson gson;
    private BodyResponse bodyResponse;

    @Given("el usuario quiere registrar un nuevo registro con el nombre {string} y el job {string}")
    public void elUsuarioQuiereRegistrarUnNuevoRegistroConElNombreYElJob(String nombre, String job) {
        try {
            super.setupReqres();
            gson = new Gson();
            bodyResquest = new BodyResquest();
            bodyResquest.setName(nombre);
            bodyResquest.setJob(job);
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

    @When("se haga una peticion POST con los datos")
    public void seHagaUnaPeticionPOSTConLosDatos() {
        try {
            actor.attemptsTo(
                    doPost().toRecourse(RESOURCE_POST_CREATE_USER).whitBodyRequest(gson.toJson(bodyResquest))

            );
            LOGGER.warn("Hola"+gson.toJson(bodyResquest));
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
        //LOGGER.info(gson.toJson(bodyResquest));
       // System.out.println("========="+gson.toJson(bodyResquest));
    }

    @Then("se debería obtner un codigo de respuesta exitoso y el cuerpo de la respuesta del micorservicio")
    public void seDeberíaObtnerUnCodigoDeRespuestaExitosoYElCuerpoDeLaRespuestaDelMicorservicio() {
        actor.should(
                seeThat("El código de respuesta ", ResponseCode.was(),equalTo(201))
        );

        /*Buscar otra posibilidad de hacer esto*/
        bodyResponse = new BodyResponseQuestion().answeredBy(actor);
        System.out.println("===================================="+bodyResponse);
        System.out.println("0000000"+bodyResponse.getName());

        /*Como hacer una assertion de todo el body response?*/
        actor.should(
                seeThat("El nombre de respuesta",actor1 -> bodyResponse.getName(),equalTo("morpheus"))
        );

        //Alternativa para no usar un objeto de tipo bodyResponse, crear un objeto de la question dentro del seeThat
        actor.should(
                seeThat("El job de respuesta",actor1 -> new BodyResponseQuestion().answeredBy(actor).getJob(),equalTo("leader"))
        );

    }


}
