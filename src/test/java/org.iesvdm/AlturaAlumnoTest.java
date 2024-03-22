package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AlturaAlumnoTest {

    @Test
    void prueba() { assertTrue(1 == 1);}

    //Pruebas de caja negra o funcionales, las pruebas unitarias
    @Test
    void aniadeNombreArrayNoVacio(){

        //When(Cuando)
        //array lleno
        //nombre no nulo ni vacio
        String[] array = new String[0];
        String nombre = "Jose";

        String[] arrayActual = AlturaAlumno.aniadeNombre(array, nombre);

        //Then (Entonces)

        //array Actual es posicion es longitud mas 1 que array
        //arrayActual tiene en la ultima posicion nombre
        //arrayActual contiene a array inicial

        assertTrue(arrayActual.length == array.length+1);
        assertEquals(nombre, arrayActual[arrayActual.length-1]);

        //for(int = 0; i<array.length; i++) assertEquals(array[i], arrayActual[i]);
        //Arrays copyOf()
        String[] actual = Arrays.copyOfRange(arrayActual, 0, array.length);
        assertArrayEquals(array,
                actual);
    }

    @Test
    void modificaAltura(){
        double[] array = {1.3D, 1.4D, 2.4D};
        int posicion=1;
        double altura=2;

        //When (Cuando)
        //La posición no este fuera del rango
        AlturaAlumno.modificaAltura(array, posicion, altura);

        //Then (Entonces)
        //Modifico la altura de una posicion dada del array
        assertEquals(altura, array[posicion]);
    }

    @Test
    void aniadeAltura(){
        double[] array={1.3, 1.4, 2.4};
        double alturaDefecto = 1.5;
        
        double[] arrayActual = AlturaAlumno.aniadeAltura(array);

        //Then (Entonces)
        
        //arrayActual es posicion es longitud + 1 que array
        //arrayActual tiene en la ultima posicion nombre
        //arrayActual contiene a array inicial
        
        assertTrue(arrayActual.length == array.length+1);
        assertEquals(alturaDefecto, arrayActual[arrayActual.length-1]);
        
        double[] actual = Arrays.copyOfRange(arrayActual, 0, array.length);
        assertArrayEquals(array, 
                actual);
    }
    
    @Test
    void buscaNombreEncontrado(){
        int posicionEncontrada = -1;
        int index = 0;
        String nombre = "Hola";
        String[] array = new String[0];
        
        //When
        // Mientras no llegue al final de array y el valor de posicion no haya cambiado

        
        //do
        //busco nombre
        assertEquals(array[index], nombre);
        
        //Then
        //devuelvo posicion
        
    }

    @Test
    void buscaNombreNoEncontrado(){
        int posicionEncontrada = -1;
        int index = 0;

        //When
        // Mientras no llegue al final de array y el valor de posicion no haya cambiado

        //do
        //busco nombre
        
        //Then
        //devuelvo posicion

    }
}