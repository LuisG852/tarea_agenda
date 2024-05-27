package org.example.Servicio;
import org.example.Modelo.Contacto;
import org.example.Modelo.NodoContacto;

public class Agenda {
    // Nodo raíz del árbol binario de contactos
    private NodoContacto raiz;

    // Constructor de la clase Agenda, inicializa la raíz en null
    public Agenda() {
        this.raiz = null;
    }

    // Método para agregar un nuevo contacto a la agenda
    public void agregarContacto(String nombre, String telefono) {
        // Crea un nuevo contacto
        Contacto nuevoContacto = new Contacto(nombre, telefono);
        // Si la raíz es null, coloca el nuevo contacto como raíz
        if (this.raiz == null) {
            this.raiz = new NodoContacto(nuevoContacto);
        } else {
            // Si no, inserta el contacto en la posición adecuada en el árbol
            this.insertar(this.raiz, nuevoContacto);
        }
    }

    // Método privado recursivo para insertar un contacto en el árbol
    private void insertar(NodoContacto padre, Contacto contacto) {
        // Compara el nombre del nuevo contacto con el del nodo padre
        if (contacto.getNombre().compareTo(padre.getContacto().getNombre()) < 0) {
            // Si es menor, se inserta en el subárbol izquierdo
            if (padre.getIzdo() == null) {
                padre.setIzdo(new NodoContacto(contacto));
            } else {
                insertar(padre.getIzdo(), contacto);
            }
        } else if (contacto.getNombre().compareTo(padre.getContacto().getNombre()) > 0) {
            // Si es mayor, se inserta en el subárbol derecho
            if (padre.getDcho() == null) {
                padre.setDcho(new NodoContacto(contacto));
            } else {
                insertar(padre.getDcho(), contacto);
            }
        }
    }

    // Método para buscar un contacto por su nombre
    public Contacto buscarContacto(String nombre) {
        return buscar(this.raiz, nombre);
    }

    // Método privado recursivo para buscar un contacto en el árbol
    private Contacto buscar(NodoContacto nodo, String nombre) {
        if (nodo == null) {
            return null; // Si el nodo es null, el contacto no se encontró
        }
        if (nombre.equals(nodo.getContacto().getNombre())) {
            return nodo.getContacto(); // Si el nombre coincide, devuelve el contacto
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            return buscar(nodo.getIzdo(), nombre); // Si es menor, busca en el subárbol izquierdo
        } else {
            return buscar(nodo.getDcho(), nombre); // Si es mayor, busca en el subárbol derecho
        }
    }

    // Método para eliminar un contacto por su nombre
    public void eliminarContacto(String nombre) {
        this.raiz = eliminar(this.raiz, nombre);
    }

    // Método privado recursivo para eliminar un contacto del árbol
    private NodoContacto eliminar(NodoContacto nodo, String nombre) {
        if (nodo == null) {
            return null; // Si el nodo es null, el contacto no se encontró
        }
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            nodo.setIzdo(eliminar(nodo.getIzdo(), nombre)); // Si es menor, busca en el subárbol izquierdo
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            nodo.setDcho(eliminar(nodo.getDcho(), nombre)); // Si es mayor, busca en el subárbol derecho
        } else {
            // Si se encuentra el contacto
            if (nodo.getIzdo() == null) {
                return nodo.getDcho(); // Si no tiene hijo izquierdo, reemplaza con el derecho
            } else if (nodo.getDcho() == null) {
                return nodo.getIzdo(); // Si no tiene hijo derecho, reemplaza con el izquierdo
            }

            // Si tiene dos hijos, busca el menor en el subárbol derecho
            NodoContacto temp = minValorNodo(nodo.getDcho());
            // Copia los datos del nodo sucesor al nodo actual
            nodo.getContacto().setTelefono(temp.getContacto().getTelefono());
            nodo.getContacto().setNombre(temp.getContacto().getNombre());
            // Elimina el nodo sucesor
            nodo.setDcho(eliminar(nodo.getDcho(), temp.getContacto().getNombre()));
        }
        return nodo;
    }

    // Método para encontrar el nodo con el valor mínimo en un subárbol
    private NodoContacto minValorNodo(NodoContacto nodo) {
        NodoContacto actual = nodo;
        // Se mueve al nodo más a la izquierda
        while (actual.getIzdo() != null) {
            actual = actual.getIzdo();
        }
        return actual;
    }

    // Método para mostrar todos los contactos en orden
    public void mostrarContactos() {
        inOrden(this.raiz);
    }

    // Método privado recursivo para mostrar los contactos en orden
    private void inOrden(NodoContacto nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzdo()); // Recorre el subárbol izquierdo
            System.out.println("Nombre: " + nodo.getContacto().getNombre() + ", Teléfono: " + nodo.getContacto().getTelefono());
            inOrden(nodo.getDcho()); // Recorre el subárbol derecho
        }
    }
}
//HACER UN VIIDEO TUTORIAL DE ESTA CLASE MAS DE ELIMINAR BUSCAR Y AGREGAR CONTACTO COM ES QUE FUNCIONA

