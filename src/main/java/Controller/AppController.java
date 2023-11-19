package Controller;

import Model.Person;
import Model.Register;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AppController {
    private static final Register register = new Register();

    public static void registrar(String nombre, String apellido, String dni, String fechaNacimiento){
        Person nuevaPersona = new Person(
                nombre, 
                apellido, 
                Integer.parseInt(dni), 
                parseFecha(fechaNacimiento));
        register.agregarPersona(nuevaPersona);
    }
    
    public static List<Person> mostrarDatos(){
        return register.mostrarRegistros();
    }
    
    public static void eliminarRegistro(int index){
        register.eliminarPersona(index);
    }
    
    public static boolean validarDatos(String nombre, String apellido, String dni, String fechaNacimiento){
        boolean nombreValido = !nombre.trim().isEmpty();
        boolean apellidoValido = !apellido.trim().isEmpty();
        boolean dniValido = dni.matches("\\d{8}") && Integer.parseInt(dni)>0; // Verificar que el DNI tenga 8 dígitos
        boolean fechaValida = validarFecha(fechaNacimiento);
        
        return nombreValido && apellidoValido && dniValido && fechaValida;
    }
    
    
    private static boolean validarFecha(String fecha) {
        try {
            // Intentar parsear la fecha con el formato dd/mm/yyyy
            parseFecha(fecha);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static LocalDate parseFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formatter);
    }
}
