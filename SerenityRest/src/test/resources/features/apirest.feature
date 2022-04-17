Feature: Como usuario del microservicio  reqresin
  quiero crear un nuevo registro
  para conocer la respuesta del servicio ante una solicitud de creacion

  Scenario: Creacion de un nuevo registro
    Given el usuario quiere registrar un nuevo registro con el nombre "morpheus" y el job "leader"
    When se haga una peticion POST con los datos
    Then se debería obtner un codigo de respuesta exitoso y el cuerpo de la respuesta del micorservicio