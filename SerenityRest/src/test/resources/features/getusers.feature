Feature: Obtener los usuarios de la api reqres.in
  Como usuario de los servicios de la api reqres.in
  Quiero acceder a los usuarios en la base de datos
  Para saber el correo de cada uno

  Scenario: Obteniendo los usuarios
    Given quiero conocer información de los usuarios en la DB
    When se consume el servicio mediante una petición get
    Then se visualizarán todos los usuarios