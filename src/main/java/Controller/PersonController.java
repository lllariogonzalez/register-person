package Controller;

import Model.Person;
import Model.Register;
import View.Window;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonController {
    private static final Register register = new Register();

    public static void iniciarApp(){

        Window.show(">>> ¡Bienvenido! <<<\nAplicación de Registro de Personas\nNeoris - Siglo21");

        while (true){
            // confirmamos si desea agregar un nuevo registro
            boolean confirm = Window.option("¿Desea agregar un nuevo registro?", "Si", "No");
            if(confirm) createPerson();
            boolean showRegister = Window.option("¿Desea ver los registros?", "Si", "No");
            if (showRegister) listPerson();
            boolean continuar = Window.option("¿Desea continuar?", "Si", "No");
            if(!continuar) break;
        }
    }

    private static void listPerson(){
        String registerList = register.listarPersonas();
        Window.show(registerList);
    }
    
    private static void createPerson() {

        String nombre = "";
        String apellido = "";
        int dni = 0;
        LocalDate fechaNacimiento = null;

        // Recibo nombre y compruebo, no puede estar vacío.
        do {
            nombre = Window.input("Nombre: ");
            if (nombre == null) return;
            if (nombre.trim().isEmpty()) Window.showError("El Nombre no puede estar vacío");
        } while (nombre.trim().isEmpty());

        // Recibo apellido y compruebo, no puede estar vacío.
        do {
            apellido = Window.input("Apellido: ");
            if (apellido == null) return;
            if (apellido.trim().isEmpty()) Window.showError("El Apellido no puede estar vacío");
        } while (apellido.trim().isEmpty());

        // Recibo DNI y compruebo, debe tener 8 dígitos.
        do {
            String dniStr = Window.input("DNI: ");
            if (dniStr == null) return;
            if (!dniStr.matches("\\d{8}")) Window.showError("DNI inválido, debe contener 8 dígitos");
            else {
                dni = Integer.parseInt(dniStr);
                if(dni < 10000000 || dni > 99999999) Window.showError("DNI inválido, debe contener 8 dígitos");
            }
        } while (dni < 10000000 || dni > 99999999);

        // La fecha de nacimiento debe tener el formato dd/mm/yyyy en formato LocalDate
        do {
            String fechaNacimientoStr = Window.input("Fecha de Nacimiento: ");
            if (fechaNacimientoStr == null) return;
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                Window.showError("Error: Ingrese una fecha válida en el formato dd/mm/yyyy.");
            }
        } while (fechaNacimiento == null);

        // Teniendo todos los datos necesarios comprobados, procedemos a crear y guardar
        try {
            Person nuevaPersona = new Person(nombre, apellido, dni, fechaNacimiento);
            register.agregarPersona(nuevaPersona);
            Window.show("Persona agregada al registro correctamente.");
        } catch (Exception e) {
            Window.show("Error al registrar, intente nuevamente");
        }
    }
}