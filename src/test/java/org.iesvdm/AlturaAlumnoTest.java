package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        //Modifico la altura de una posicion dada del array
        AlturaAlumno.modificaAltura(array, posicion, altura);

        //Then (Entonces)
        //Compruebo que se ha cambiado correctamente
        assertEquals(altura, array[posicion]);
    }

    @Test
    void modificaAlturaFueraRango(){
        //When
        double[] array = {1.7};
        double[] arrayNuevo = Arrays.copyOf(array, array.length);
        int pos = 1;
        double alturaNueva = 1.85;
        //Then
        AlturaAlumno.modificaAltura(array, pos, alturaNueva);
        //do
        for(int i = 0; i < array.length; i++){
            assertEquals(arrayNuevo[i], array[i]);
        }

        assertArrayEquals(array, arrayNuevo);
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
        //When
        //index es igual a 1 (hello)
        int index = 1;
        String nombre = "hello";
        String[] array = {"Hola", "hello", "Adios"};


        //Then
        //si llamamos a nuestra funcion vemos que encuentra en 1 el nombre(hello)
        assertEquals(index, AlturaAlumno.buscaNombre(array, nombre));
    }

    @Test
    void buscaNombreNoEncontrado(){
        //When
        //index = 0 si nombre es igual a "hello" y no esta en el array
        int index = 0;
        String nombre = "Hello";
        String[] array = {"Hola", "Adios"};
        AlturaAlumno.buscaNombre(array, nombre);

        //Then
        //si llamamos a nuestra funcion vemos que no encuentra nombre en el array
        assertNotEquals(index, AlturaAlumno.buscaNombre(array, nombre));

    }

    @Test
    void Mostrar(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));
        //When
        //declaramos e inicializamos las dos variables cuyo valor vamos a imprimir
        String[] pruebasNombre = {"Lucia"};
        double[] pruebasAltura = {1.71};

        //Llamamos a nuestra funcion
        AlturaAlumno.mostrar(pruebasNombre, pruebasAltura);
        //Then
        //Comprobamos que el mensaje se muestra con el tabulador tambien
        assertEquals("Lucia\t|   1.71\n", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void calculaMaximo(){

        double[] valores = {4, 8};
        double[] resultadoEsperado =  {1, 8};
        double[] resultadoObtenido = AlturaAlumno.calculaMaximo(valores);

        //When
        // Comprobamos que la posición del máximo es la misma.
        assertTrue(resultadoObtenido[0] == resultadoEsperado[0]);

        //Then
        //Comprobamos que los máximos son los mismos.
        assertTrue(resultadoObtenido[1] == resultadoEsperado[1]);
    }

    @Test
    void calculaMaximoLongitudCero(){
        //When
        double[] array = new double[0];

        //do
        double[] result= AlturaAlumno.calculaMaximo(array);
        //then
        assertTrue(result[0] == 0.0);
        assertTrue(result[1] == 0.0);
    }

    @Test
    void calculaMedia(){
        double[] valores = {2, 2, 2};
        double resultadoEsperado = 2;
        double resultadoObtenido = AlturaAlumno.calculaMedia(valores);

        //When
        //Primero comprobamos que el array no esta vacio para no dividir entre 0
        assertTrue(valores.length > 0);

        //Then
        //Luego comprobamos que nuestra funcion de la media es igual que el resultado esperado
        assertEquals(AlturaAlumno.calculaMedia(valores), resultadoEsperado);

    }

    @Test
    void calculaMediaLongitudCero(){
        //When
        double[] valores = new double[0];

        //do
        double result = AlturaAlumno.calculaMedia(valores);

        //Then
        assertEquals(0.0, result);

    }

}