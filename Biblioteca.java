package biblioteca.app;

import biblioteca.modelo.Libro;

public class Biblioteca {
    public static void main(String[] args) {
        Libro l1 = new Libro("Cien años de soledad", "García Márquez");

        l1.setTitulo("");
        System.out.println(l1.getTitulo());

        Libro l5 = new Libro("", "Anónimo");
        System.out.println(l5.getTitulo());
    }
}