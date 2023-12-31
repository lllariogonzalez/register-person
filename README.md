# Actividad Integradora

### Objetivo de la actividad:

Aplicar los conceptos y habilidades adquiridos en los módulos anteriores del curso para desarrollar una aplicación de registro de personas en Java.

### Descripción de la actividad:

Los estudiantes deben crear una aplicación de registro de personas en Java que cumpla con los siguientes requisitos:

### Requisitos funcionales:

1. La aplicación debe permitir al usuario ingresar los siguientes datos de una persona:

   - Nombre
   - Apellido
   - DNI (Documento Nacional de Identidad)
   - Fecha de nacimiento

2. Los datos ingresados deben ser validados de acuerdo a las siguientes reglas:

   - El nombre y el apellido no pueden estar en blanco.
   - El DNI debe ser un número válido de 8 dígitos.
   - La fecha de nacimiento debe ser una fecha válida en el formato dd/mm/yyyy.

3. La aplicación debe permitir al usuario guardar los datos de una persona.
4. La aplicación debe permitir al usuario listar todas las personas registradas hasta el momento, mostrando todos sus datos.

## Requisitos técnicos:

- Utilizar un IDE o editor de código para desarrollar la aplicación.
- Aplicar las estructuras de control y tipos de datos aprendidos en el curso para la validación de datos y la gestión de la información.
- Utilizar arrays o colecciones para almacenar los datos de las personas registradas.
- Implementar una interfaz de usuario simple que permita al usuario ingresar los datos y realizar las operaciones mencionadas.

## Entregables:

Los estudiantes deben entregar los siguientes elementos:

- El código fuente de la aplicación Java.
- Un documento de texto explicando la lógica utilizada para validar los datos y cómo se implementaron las diferentes funcionalidades.
- Un informe detallado de cualquier problema que hayan enfrentado durante el desarrollo de la aplicación y cómo los resolvieron.

## Criterios de evaluación:

Los proyectos de los estudiantes serán evaluados de acuerdo a los siguientes criterios:

- **Funcionalidad:** ¿La aplicación cumple con todos los requisitos funcionales especificados?
- **Validación de datos:** ¿La aplicación valida correctamente los datos ingresados por el usuario?
- **Estructura del código:** ¿El código está organizado de manera clara y utiliza las estructuras de control adecuadas?
- **Interfaz de usuario:** ¿La interfaz de usuario es intuitiva y permite al usuario realizar todas las operaciones de manera sencilla?
- **Documentación:** ¿Los estudiantes proporcionan documentación clara sobre su código y cualquier problema resuelto?
- **Creatividad:** ¿Los estudiantes implementan funcionalidades adicionales o mejoras en la aplicación más allá de los requisitos mínimos?

> Esta actividad les permitirá a los estudiantes aplicar los conocimientos adquiridos en los módulos del curso relacionados con el entorno de desarrollo, variables, estructuras de control y almacenamiento de datos en Java. Además, les proporcionará experiencia práctica en la creación de aplicaciones Java funcionales.

---

# Resolución

## <img src="./src/images/logo.png" width=50 alt="Versión" > 

Se entrega el código con 2 versiones, la `v1.0.0` usando `JOptionPane` para controlar el flujo del programa con mensajes informativos, y la `v2.0.0` haciendo uso de `Swing` y `Java.form` para tener una interfaz gráfica mas amigable con el usuario al estilo app desktop.

![v2.0.0](https://img.shields.io/badge/v2.0.0-8A2BE2)

<img src="./src/images/AppRegister_v2.0.0.gif" width=400 alt="Aplicación v2.0.0 funcionando">

![v1.0.0](https://img.shields.io/badge/v1.0.0-8A2BE2)

<img src="./src/images/AppRegister_v1.0.0.gif" width=300 alt="Aplicación v1.0.0 funcionando">


> Se crean los 2 modelos - clases **Person** y **Register**, con los atributos y métodos solicitados y necesarios para las funcionalidades requeridas.

![diagrama de clases](./src/images/diagrama%20de%20clases.png)

> Sobre la estructura y modularizado del proyecto se crea un MVC, separando models|modelos, controllers|controladores y views|vistas en distintos paquetes para un código mas limpio y desacoplado.

```bash
src
└───main
    └───java
        ├───Controller
        ├───Model
        ├───View
        └───Main.java
```

## Inicio

Para probar la app debe ejecutar el proyecto desde Main.java, actualmente se encuentra configurado para abrir la versión v2.0.0, el código debería ser este:

```java
public class Main {
    public static void main(String[] args) {
        // v2.0.0
        new App().setVisible(true);
        // v1.0.0
        //PersonController.iniciarApp();
    }
}
```

Ambas versiones estan funcionales, puede probar la v1.0.0 descomentando el código `PersonController.iniciarApp();` y comentando `new App().setVisible(true);` para evitar lanzar ambas aplicaciónes al mismo tiempo.


## Validación de datos

- ![v1.0.0](https://img.shields.io/badge/v1.0.0-8A2BE2)

La aplicación inicia en **Main.java** que llama al controlador **PersonController**, específicamente a su método estático `iniciarApp()`, el cual se encarga de administrar la lógica y llamar las vistas necesarias para interactuar con el usuario. El controlador administra y crea el registro. Las vistas en este caso son ventanas emergentes "popup" administradas por la clase **Window** ubicada en el paquete *View*.

El usuario si opta por crear un nuevo registro, el controlador llama a un método privado para cargar los datos, validarlos durante la carga y posteriormente crear una nueva persona **Person** y agregarla al registro **Register**.

Para validar los datos durante la carga se hace uso de la estructura de control `do{}while()` para inicar primero solicitando los datos y luego pasar a validarlos, en caso de que el dato solicitado sea `null` significa que el usuario cancelo la carga o se produjo un error, para evitar errores, se controla y si es `null` se retorna y termina la carga de datos, volviendo al flujo de `iniciarApp()`.

Ahora si el dato no es `null` se procede a validar según requisitos funcionales, el nombre y el apellido no pueden estar vacíos por lo cual mientras este dato no sea validado se continúa solicitando el dato correcto informando en el proceso al usuario del requisito. En este caso se hace uso del método **trim()** para quitar espacios en blanco y luego del método `isEmpty()` para determinar si está vacío, si es *true* el while() continuará el bucle hasta que los datos sean validados o se cancele el registro.

En el caso del dato DNI se requiere que sea de 8 dígitos, por lo cual se valida haciendo uso de una [regex](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html) (documentación en el link) `matches("\\d{8}")` y del método matches aplicado a un String que retorna un boolean si cumple o no con la regex. Posteriormente en caso de cumplir la regex se parsea el String a integer y se valida con la siguiente condición `dni < 10000000 || dni > 99999999` para evitar el ingreso de errores o casos de un 00000000.

Por ultimo se valida la fecha de nacimiento, segun los requisitos debe ser una fecha válida en el formato `dd/mm/yyyy` para ello se usa la clase [DataTimeFormatter](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html) "Patterns for Formatting and Parsing" (documentación en el link); con su método ofPattern puedo crear un formateador de fechas para luego usar el método parse de `LocalDate` con dicho formato. Esto se envuelve en un `try{}catch{}` para controlar el fallo del parseo y así validar la fecha.


- ![v2.0.0](https://img.shields.io/badge/v2.0.0-8A2BE2)

Se crean 3 Vistas `Java.form` en el paquete View, `App` que es la principal, crea y controla las demás vistas. `CargarDatos` que contiene el formulario para la carga y validación por medio de `AppController`, esta vista tiene 2 botones, uno para limpiar los datos del form y otro para guardar, este último solo se activa si el formulario está validado, es decir se cumplen los requisitos funcionales. Y la última vista a mencionar es `MostrarDatos` la cual contiene una tabla que permite listar y mostrar las personas registradas, además se agregó una funcionalidad extra que es `eliminar`, que permite seleccionar de la tabla una fila la cual contiene el registro de una Persona y eliminarla del registro, para ello se hace uso del `index` como si fuera un `id` que ubica la Persona y permite removerla del `Register`.

La lógica la aplica la clase `AppController` que se encuentra en el paquete Controller, tiene la función de registrar, validar (se reutiliza la lógica de la `v1.0.0`), eliminar y mostrar los datos del `Register` el cual se instancia desde la misma clase.

## Informe de problemas solucionados

No tuve problemas para resolver el proyecto y cumplir los requisitos, inicié con un código funcional directamente acoplado en Main.java y a partir de ahi fui refactorizando y modularizando, corrigiendo errores y validaciones, para hacer un código mas limpio y mantenible. Mejorando la lógica y las interacciones con el usuario. Haciendo pruebas finales y añadiendo funcionalidades.

Para la `v2.0.0` si tuve que investigar sobre **Swing** "biblioteca de clases que permite crear interfaces gráficas de usuario en Java", para poder mejorar o crear realmente una interfaz de usuario, para hacerlo me apoye de la documentación, de AI y de videos; de esta manera y necesariamente usando las herramientas de Netbeans para poder visualisar mis vistas, fui aprendiendo a crear `labels, buttons, icons, titles, tables`, programar acciones y eventos para controlar el flujo del programa.

Concluyendo estoy satisfecho con ambas versiones por lo cual las dejo incluidas en mi entrega final, una realizada con lo aprendido en clases y otra con un poco mas de información e investigación. Estoy seguro de que tiene lugar para mejoras, y que resta mucho mas por aprender, pero estoy contento con el resultado logrado.
