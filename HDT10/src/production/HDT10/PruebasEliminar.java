import static org.junit.Assert.*;

public class PruebasEliminar {

    @org.junit.Test
    public void delete() {
        Grafo grafito = new Grafo(50,50);
        grafito.insertaArista(22,29,12);
        grafito.insertaArista(25,26,12);
        grafito.eliminaArista(22,29);

        assertEquals(false,grafito.existeArista(22,29));

    }

}