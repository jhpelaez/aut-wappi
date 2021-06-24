# aut-wappi

En este proyecto de automatizacion se da cobertura de los flujos criticos sin profundizar en demas pruebas.
Para esta automatizacion se usa el patron de diseño "screenplay" mediante serenity BDD, con java como lenguaje de programacion.
Para la definicion de los casos prueba se hace uso de la definicion de archivos .feature con cucumber.

La declaracion de los escenarios se puede encontrar en la carpeta features. Se genera un archivo feature por cada flujo

Este es un proyecto maven por lo cual para su ejecucion podria usar el comando desde consola:
	mvn clean verify -Dcucumber.options="--tags @wappiTest"
	
Otra alternativa de ejecucion es mediante Junit ubicandose en el archivo runner que desee ejecutar