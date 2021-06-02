import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PruebasFloyd {

    @org.junit.Test
    public void floyd() {
        ArrayList ciudades = new ArrayList();
        ciudades.add("españa");
        ciudades.add("guate");
        ciudades.add("francia");
        ciudades.add("alemania");

        Grafo grafito = new Grafo(4,4);
        grafito.insertaArista(0,1,29);
        grafito.insertaArista(1,2,22);
        grafito.insertaArista(2,3,12);
        grafito.insertaArista(2,0,6);


        int[][] origen = grafito.getMAT();
        int[][] copia = new int[origen.length][origen.length];

        for(int i=0; i<origen.length; i++){
            for(int x=0; x<origen.length; x++){
                copia[i][x] = origen[i][x];
            }
        }

        Floyd floicito = new Floyd();
        floicito.floyd(copia);



        assertEquals("francia",floicito.calcen(copia,ciudades));

    }

}