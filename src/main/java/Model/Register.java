package Model;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private final ArrayList<Person> listaPersonas;

    public Register() {
        this.listaPersonas = new ArrayList<>();
    }

    public void agregarPersona(Person persona) {
        listaPersonas.add(persona);
    }
    
    public void eliminarPersona(int index){
        listaPersonas.remove(index);
    }

    public String listarPersonas() {
        if(listaPersonas.isEmpty()) return "No existen registros";
        String list = "Personas Registradas 📕 \n";
        for (Person persona : listaPersonas) {
            list += "------------------------------------\n";
            list += persona;
        }
        return list;
    }

    public List<Person> mostrarRegistros(){
        return listaPersonas;
    }
}