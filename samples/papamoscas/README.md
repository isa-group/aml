# Puesta en marcha del ejemplo 
## Introducción
Este ejemplo pretende mostrar la aplicación de una biblioteca de gestión de acuerdos a nivel de servicio a una API existente.
En concreto, partiendo de una simple API REST, se incorpora por encima un filtro que realiza la lógica necesaria para la autorización de peticiones en función de unos planes definidos previamente.

## Contenido
En el ejemplo encontramos:
+ [src](src): 
  + [Bird](src/es/us/isa/classes/Bird.java): Objeto básico del que guardamos información que gestiona la API.
  + [BirdsServlet](src/es/us/isa/servlets/BirdsServlet.java): HttpServlet que implementa los métodos de la API.
  + [AgreementsServlet](src/es/us/isa/servlets/AgreementsServlet.java): HttpServlet sencillo para visualizar acuerdos (todos o los de un usuario).
  + [AgreementFilter](src/es/us/isa/filters/AgreementFilter.java): filtro que realiza la lógica de acuerdo al modelo de acuerdo suministrado.
  + [Helper](src/es/us/isa/util/Helper.java): singleton que instancia la librería e inicializa usuarios por defecto.
+ [war](war): página web estática con links para facilitar el acceso a la API.
  + El directorio [templates](war/templates) contiene las plantillas de acuerdo formalizadas en iAgree.
+ [Documentation.pdf](Documentation.pdf): documentación extendida para el ejemplo.
+ [aml-0.0.1.jar](war/WEB-INF/lib/aml-0.0.1.jar): versión preliminar de la librería para la gestión de acuerdos.

## Prerrequisitos
Este ejemplo se debe montar en un IDE que tenga soporte para AppEngine de Google. Por ejemplo:
+ [Eclipse](https://cloud.google.com/appengine/docs/java/tools/eclipse).
+ [IntelliJ IDEA](https://www.jetbrains.com/idea/features/google_app_engine.html).

No obstante, se puede desplegar en cualquier contenedor de servlets como Tomcat.

## Arranque
Los pasos mínimos para poner en marcha este ejemplo en Eclipse (Luna) son:
+ Abrir Eclipse: File->Import->General->Existing projects into workspace->Select archive file->Seleccionar el [zip suministrado](/samples/papamposcas-EclipseBundle.zip).
+ Run As->Web Application.
+ Si se usa otra versión de Eclipse hay que descargar el plugin de AppEngine específico para tal versión.

Si se prefiere usar otro IDE o usar el código directamente:
+ [Clonar este repositorio](https://github.com/isa-group/aml.git).
+ Añadir el [jar suministrado](war/WEB-INF/lib/aml-0.0.1.jar) como dependencia.
+ Añadir las dependencias del SDK de AppEngine (o bien las de JavaEE si se desea correr en un contenedor propio de servlets).
+ Hacer el build y arrancar el servidor.

## Más información
A modo de ejemplo, se encuentra desplegado este ejemplo: [demo](http://papamoscas-isa.appspot.com).
En la [documentación](Documentation.pdf) se ofrece una información más completa.

## Contacto
Para cualquier incidencia, subir un ticket o contactar directamente con algún miembro del Grupo ISA involucrado en el proyecto.
