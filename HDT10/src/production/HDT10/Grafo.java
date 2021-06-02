import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.UnsupportedOperationException;
import java.lang.RuntimeException;

public class Grafo {
    private final int MAXIMO_VERTICES;
    private final int MAXIMO_ARISTAS;
    private int aristas;
    private int matrix[][];

    /**
     * Crea un grafo por matrices de adyacencia
     * @param nroVertices numero de vertices
     * @param nroAristas numero de aristas
     */
    public Grafo(int nroVertices, int nroAristas) {
        MAXIMO_VERTICES = nroVertices;
        MAXIMO_ARISTAS = nroAristas;

        this.aristas = 0;

        matrix = new int[MAXIMO_VERTICES][MAXIMO_VERTICES];

        for (int i = 0; i < getMAX_VERTICES(); i++) {
            for (int j = 0; j < getMAX_VERTICES(); j++) {
                if(i==j){
                    matrix[i][j]=0;
                }else{
                    matrix[i][j] = 1000000000;
                }

            }
        }
    }

    /**
     * crea un grafo. Metodo general
     * @param nroVertices
     */
    public Grafo(int nroVertices) {
        this(nroVertices, nroVertices);
    }

    public int getMAX_VERTICES() {
        return MAXIMO_VERTICES;
    }

    public int getMAX_ARISTAS() {
        return MAXIMO_ARISTAS;
    }

    /**
     * Inserta una arista dada la relacion entre vertice1 y vertice2 y la distancia entre los vertices
     * dados
     * @param v1 vertice1
     * @param v2 vertice2
     * @param dist distancia entre los dos vertices
     * @throws ArrayIndexOutOfBoundsException
     * @throws UnsupportedOperationException
     */
    public void insertaArista(int v1, int v2, int dist)
            throws ArrayIndexOutOfBoundsException, UnsupportedOperationException {
        if (v1 >= MAXIMO_VERTICES || v2 >= MAXIMO_VERTICES) {
            throw new ArrayIndexOutOfBoundsException(
                    "Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (aristas == MAXIMO_ARISTAS) {
            throw new UnsupportedOperationException("No se puede añadir más aristas");
        } else {
            matrix[v1][v2] = dist;
        }
    }

    /**
     * Este metodo nos indica si existe una arista entre un par de vertice dados.
     * @param v1 vertice1
     * @param v2 vertice2
     * @return verdadero o falso.
     */
    public boolean existeArista(int v1, int v2) {
        if (v1 >= MAXIMO_VERTICES || v2 >= MAXIMO_VERTICES) {
            throw new ArrayIndexOutOfBoundsException(
                    "Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (matrix[v1][v2] != 0) {
            return true;
        }
        return false;
    }

    /**
     * Eliminar arista
     * @param v1 vertice1
     * @param v2 vertice2
     */
    public void eliminaArista(int v1, int v2) {
        if (v1 >= MAXIMO_VERTICES || v2 >= MAXIMO_VERTICES) {
            throw new ArrayIndexOutOfBoundsException(
                    "Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (matrix[v1][v2] == 0) {
            System.err.println("La arista NO existe");
        } else {
            matrix[v1][v2] = 0;
        }
    }

    public void borrarGrafo() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void impMatrix() {
        System.out.print(" ");
        for (int i = 0; i < MAXIMO_VERTICES; i++) {
            System.out.printf("  %3d", i);
        }
        System.out.println();
        for (int i = 0; i < MAXIMO_VERTICES; i++) {
            System.out.printf(" %3d", i);
            for (int j = 0; j < MAXIMO_VERTICES; j++) {
                System.out.printf(" %3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] getMAT(){
        return matrix;
    }


}
