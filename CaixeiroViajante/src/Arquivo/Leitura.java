package Arquivo;

import Grafo.Grafo;
import Grafo.MatrizAdjacencia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gusta
 */
public class Leitura {

    public Grafo read(String path) throws IOException, Exception {
        File arquivo = new File(path);
        FileReader filereader = new FileReader(arquivo);
        BufferedReader bufferedreader = new BufferedReader(filereader);
        int dimensao = 58;

        int matriz[][] = new int[dimensao][dimensao];
        Grafo g = new MatrizAdjacencia(dimensao);

                
        for (int i = 0; i < 7; i++) {
            System.out.println(bufferedreader.readLine());
        }
        
        int k, l;
        for (int i = 0; i < dimensao - 1; i++) {            
            String[] s = bufferedreader.readLine().split(" ");
            k = 0;            
            for (int j = 0; j < s.length; j++) {
                if (j == i) {
                    g.adicionarAresta(i, j, 0);
                } else {
//                    System.out.print(s[k]+" ");
                    g.adicionarAresta(i, j, Integer.parseInt(s[k]));
                    g.adicionarAresta(j, i, Integer.parseInt(s[k]));
                    k++;
                }
            }
//            System.out.print("\n");

        }
        g.adicionarAresta(dimensao - 1, dimensao - 1, 0);

        bufferedreader.close();
        filereader.close();
        return g;
    }
}
