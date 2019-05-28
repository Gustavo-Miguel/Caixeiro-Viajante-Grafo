/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Grafo.Grafo;
import java.util.Random;

/**
 *
 * @author gusta
 */
public class HillClimber {

    private Grafo g;
    private Random random;
    private int[] s;

    public int[] getSolucao() {
        return s;
    }

    public HillClimber(Grafo g) {
        this.g = g;
        random = new Random();
    }

    public HillClimber(Grafo g, int seed) {
        this.g = g;
        random = new Random(seed);
    }

    private int[] SolucaoInicial(int length, int[] pessoasGrupo) {
        int[] solucao = new int[length];
        for (int i = 0; i < length; i++) {
            solucao[i] = i;
        }
        return solucao;
    }

    public int[] inversao(int[] solucao, int p1, int p2) {
        int aux;
        if (p1 > p2) {
            aux = p1;
            p1 = p2;
            p2 = aux;
        }
        for (int i = 0; i < ((p2 - p1) / 2); i++) {
            aux = solucao[p1 + i];
            solucao[p1 + i] = solucao[p2 - i];
            solucao[p2 - i] = aux;
        }
        return solucao;
    }
    
    public int[] insertion(int[] solucao, int p1, int p2){
        int aux = solucao[p1];
        if (p1 > p2){
            for (int i = p1; i > p2 ; i--) {
                solucao[i] = solucao[i-1];
            }
        } else {
            for (int i = p1; i < p2; i++) {
                solucao[i] = solucao[i+1];
            } 
        }
        solucao[p2] = aux;
        return solucao;
    }

    private int[] swap(int[] solucao, int p1, int p2) {
        int aux = solucao[p1];
        solucao[p1] = solucao[p2];
        solucao[p2] = aux;

        return solucao;        
    }
    
    public int verificaSolucao(int[] solucao){
        int somatorio = 0;
        for (int i = 0; i < solucao.length - 1; i++) {
            somatorio += g.getPeso(solucao[i], solucao[i + 1]);
        }
        somatorio += g.getPeso(solucao[57], solucao[0]);
        return somatorio;
    }

    public double executar(int iteracoes, int[] pessoasGrupo) {
        s = SolucaoInicial(g.numeroDeVertices(), pessoasGrupo);
        double q0 = 0;
        double q1 = 0;
        for (int i = 0; i < iteracoes; i++) {
            q0 = verificaSolucao(s);
            //q0 = g.getCustoGrupo(s);
            int p1 = random.nextInt(s.length);
            int p2 = random.nextInt(s.length);            
            int p3 = random.nextInt(3)+1;
            if(p3 == 1){
            s = swap(s, p1, p2);    
            } else if(p3 ==2){
                s= inversao(s, p1, p2);
            } else {
                s = insertion(s, p1, p2);
            }                        
            
            q1 = verificaSolucao(s);
            //q1 = g.getCustoGrupo(s);

            if (q0 < q1) {
                q0 = q1;
            }
        }
        System.out.println("qo: " + q0);
        return q0;
    }
}
