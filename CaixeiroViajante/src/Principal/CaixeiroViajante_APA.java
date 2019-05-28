/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Arquivo.Leitura;
import Grafo.Grafo;

/**
 *
 * @author gusta
 */
public class CaixeiroViajante_APA {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int cidades[] = new int[1];
        cidades[0] = 58;
//        cidades[1] = 29;
        double melhorsolucao = Double.MAX_VALUE, aux;

        Leitura instancia = new Leitura();
        Grafo g = instancia.read("instancia/brazil58.tsp");
        HillClimber hillclimber = new HillClimber(g);
        for (int i = 0; i < 100; i++) {
            aux = hillclimber.executar(1000, cidades);
            if (aux < melhorsolucao && aux > 0) {
                melhorsolucao = aux;
            }
        }
        System.out.println("Custo total: " + melhorsolucao);
    }

}
