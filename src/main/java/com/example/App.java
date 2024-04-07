package com.example;

import java.util.List;

public final class App {
    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();

        lista.insertar("A", "Elemento A");
        lista.insertar("B", "Elemento B");
        lista.insertar("C", "Elemento C");

        // Imprimir la lista utilizando diferentes métodos de impresión
        System.out.println("Elementos de la lista (imprimir sin separador):");
        System.out.println(lista.imprimir());

        System.out.println("\nElementos de la lista (imprimir con separador ', '):");
        System.out.println(lista.imprimir(", "));

        // Buscar un elemento en la lista
        Nodo<String> nodoB = lista.buscar("B");
        if (nodoB != null) {
            System.out.println("\nElemento encontrado: " + nodoB.getDato());
        } else {
            System.out.println("\nElemento no encontrado");
        }

        // Eliminar un elemento de la lista
        System.out.println("\nEliminando el elemento 'B' de la lista...");
        lista.eliminar("B");

        // Imprimir la lista después de eliminar un elemento
        System.out.println("\nElementos de la lista después de eliminar 'B':");
        System.out.println(lista.imprimir());

        // Verificar si la lista está vacía
        System.out.println("\n¿La lista está vacía? " + (lista.esVacia() ? "Sí" : "No"));

        // Obtener la cantidad de elementos en la lista
        System.out.println("\nCantidad de elementos en la lista: " + lista.cantElementos());
    }
}
