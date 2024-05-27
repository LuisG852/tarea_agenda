package org.example.Vista;

import org.example.Modelo.Contacto;
import org.example.Servicio.Agenda;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Agregar contactos
        agenda.agregarContacto("Samuel", "78451269");
        agenda.agregarContacto("Gilma", "89562312");
        agenda.agregarContacto("Josue", "89784556");
        agenda.agregarContacto("Daniel", "23124556");
        agenda.agregarContacto("Lazaro", "78895645");
        agenda.agregarContacto("Cesar", "12235645");
        agenda.agregarContacto("Wiliam", "41748552");
        agenda.agregarContacto("Rodrigo", "74415285");
        agenda.agregarContacto("Henry", "63968552");
        agenda.agregarContacto("Robyn", "96635285");
        agenda.agregarContacto("Jesica", "97643108");
        agenda.agregarContacto("Yuliana", "79461305");
        agenda.agregarContacto("Maria", "17283905");
        agenda.agregarContacto("Fernando", "17392802");
        agenda.agregarContacto("Darwin", "15935782");

        // Mostrar contactos
        System.out.println("Contactos en la agenda:");
        agenda.mostrarContactos();

        // Buscar un contacto
        System.out.println("\nBuscando el contacto de Link:");
        Contacto contacto = agenda.buscarContacto("Link");
        if (contacto != null) {
            System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono());
        } else {
            System.out.println("Contacto no encontrado.");
        }

        // Eliminar un contacto
        System.out.println("\nEliminando el contacto de Daniela y Hector.");
        agenda.eliminarContacto("Lazaro");
        agenda.eliminarContacto("Maria");

        // Mostrar contactos después de la eliminación
        System.out.println("Contactos en la agenda después de eliminar a Lazaro y Maria:");
        agenda.mostrarContactos();
        //TAREA
    }
}
