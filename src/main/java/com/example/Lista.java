package com.example;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        if (primero == null) {
            primero = new Nodo<T>(etiqueta, dato);
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<T>(etiqueta, dato));
        }
    }

    @Override
    public Nodo buscar(Comparable clave) {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            if (actual.getEtiqueta().compareTo(clave) == 0) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (this.primero == null) {
            System.out.println("Nada que eliminar. La lista está vacía.");
            return false;
        } else if (this.primero.getEtiqueta().compareTo(clave) == 0) {
            this.primero = this.primero.getSiguiente();
            return true;
        }

        Nodo<T> actual = this.primero;

        while (actual.getSiguiente() != null) {

            if (actual.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {

        if (esVacia()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = this.primero;

        while (actual != null) {
            sb.append(actual.getDato() + " ");
            if (actual.getSiguiente() == null)
                break;

            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        if (esVacia())
            return "";

        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = this.primero;

        while (actual != null) {

            if (actual.getSiguiente() == null)
                break;

            sb.append(actual.getDato() + separador);
            actual = actual.getSiguiente();
        }

        sb.append(actual.getDato());

        return sb.toString();
    }

    @Override
    public int cantElementos() {

        int result = 0;
        Nodo<T> actual = this.primero;

        while (actual != null) {
            result++;
            actual = actual.getSiguiente();
        }

        return result;
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public void setPrimero(Nodo unNodo) {
        this.primero = unNodo;
    }

}
