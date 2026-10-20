# Taller5

ETAPA 2
error
prediccion: Algunos apuntan al mismo dato y otros a diferente lado

ETAPA 3 
error
mensaje de error: Exception in thread "main" java.lang.NullPointerException: Cannot invoke "biblioteca.modelo.Libro.mostrarInformacion()" because "l4" is null
at biblioteca.app.Biblioteca.main(Biblioteca.java:25)

ETAPA 4
error
mensaje de error: Biblioteca.java:30: error: titulo has private access in Libro
        System.out.println(l1.titulo);^

RETO 1
Libro a = new Libro("Ficciones", "Borges");  // objeto A
Libro b = new Libro("Ficciones", "Borges");  // objeto B
Libro c = a;                                 // c apunta a A
c.prestar();                                 // A queda no disponible
a = b;                                       // a ahora apunta a B


RETO 2
public void devolverLibro(Libro libro) {
    if (libro == null) {
        System.out.println("No hay libro para devolver");
    } else if (librosPrestados > 0) {
        libro.devolver();
        librosPrestados--;
    }
}


RETO 3
public boolean mismoTitulo(Libro otro) {
    return otro != null && titulo.equals(otro.titulo);
}


1. ¿Qué guarda una variable int y qué guarda una variable Libro?
Un int guarda el valor mismo, por ejemplo 5. Una variable Libro guarda solo una flecha hacia el objeto (o null si no apunta a nada). El libro vive aparte, en el heap.

2. ¿Por qué prestar con l2 cambió l1 pero no l3?
Porque l2 = l1 no crea un libro nuevo, solo le pone un segundo nombre al mismo. l3 se creó con new, así que es otro libro distinto, aunque tenga el mismo título y autor.

3. ¿Por qué el compilador no detectó la NullPointerException?
Porque el compilador solo revisa que el código esté bien escrito y que los tipos cuadren. l4 es un Libro y Libro tiene mostrarInformacion(), así que para él todo está bien. Que l4 sea null solo se sabe cuando el programa corre.

4. ¿Qué diferencia hay entre modificar el objeto que recibe un método y asignarle uno nuevo a su parámetro?
El parámetro es una copia de la flecha, no el objeto. Si usas esa flecha para llamar un método (libro.prestar()), cambias el objeto real y se nota afuera. Si le asignas otro objeto (libro = new Libro(...)), solo cambias tu copia local; la variable de quien llamó sigue apuntando al libro de antes.

5. ¿Qué invariantes protege Libro y cómo las protege?

El título nunca es null ni vacío: el atributo es privado y solo se cambia con setTitulo, que rechaza esos valores. El constructor también pasa por ahí y, si el título es malo, pone “Sin título”.
La disponibilidad siempre es coherente: no existe setDisponible, así que solo cambia con prestar() y devolver().
El autor no cambia: solo tiene getter, no setter.
