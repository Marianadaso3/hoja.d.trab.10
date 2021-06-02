import java.util.ArrayList;
import java.util.HashMap;

public class Floyd {
    private int[][] P;
    private int[][] M;


    public void floyd(int[][] Matrix){
        P = new int[Matrix.length][Matrix.length];
        M = Matrix;
        for (int x = 0; x < P.length; x++) {
            for (int y = 0; y < P.length; y++) {
                P[x][y]= 0;
            }
        }
        for (int k = 0; k < M.length; k++) {
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    int cambio = M[i][j];
                    int a = M[i][k];
                    int b = M[k][j];

                    if(cambio>a+b){
                        M[i][j]=(a+b);
                        P[i][j] = k;
                    }
                }
            }
        }
    }

    public String calcen(int [][] copia,ArrayList ciudades)
    {
        HashMap<Integer,Integer> pos = new HashMap<>();
        int x=0;
        int y=0;
        int [] m= new int[copia.length];
        for (int i=1;i< copia.length;i++)
        {
            for (int j=1; j<copia.length;j++)
            {
                if((copia[i][j])>m[i]) {
                    m[i]=(copia[i][j]);
                    x=i;

                }
            }
            pos.put(m[i],x);

        }
        int m2=0;
        for (int i =0;i<m.length-1;i++)
        {
            m2 = Math.min(m[i], m[i + 1]);
        }


        System.out.println("\n El centro es: "+ ciudades.get(pos.get(m2)));

        return (String) ciudades.get(pos.get(m2));
    }


    public void ruta(int dedonde, int adonde, ArrayList ciudad){

        if(P[dedonde][adonde]!=0){
            ruta(dedonde,P[dedonde][adonde],ciudad);
            System.out.println("Para llegar hay que pasar por: " + ciudad.get(P[dedonde][adonde]));
            ruta(P[dedonde][adonde],adonde,ciudad);
        }
    }

}

