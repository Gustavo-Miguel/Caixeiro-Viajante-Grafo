/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author gusta
 */
public class MatrizAdjacencia implements Grafo {

    int[][] matriz;
    int[] custoporgrupo;
    int maiorcusto = 0;

    public MatrizAdjacencia(int vertices) {
        this.matriz = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                this.matriz[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    @Override
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public void adicionarAresta(int origem, int destino) throws Exception {
        this.matriz[origem][destino] = 1;
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) throws Exception {
        this.matriz[origem][destino] = peso;
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        return this.matriz[origem][destino] != Integer.MAX_VALUE;
    }

    @Override
    public int grauDoVertice(int vertice) throws Exception {
        int count = 0;

        for (int i = 0; i < this.matriz.length; i++) {
            if (this.matriz[vertice][i] != Integer.MAX_VALUE) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int numeroDeVertices() {
        return matriz.length;
    }

    @Override
    public int numeroDeArestas() {
        int count = 0;

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (this.matriz[i][j] != Integer.MAX_VALUE) {
                    count++;
                }
            }
        }
        return count;
    }
    int tes;

    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < this.matriz.length; i++) {
            if (this.matriz[vertice][i] != Integer.MAX_VALUE) {
                list.add(i);
            }
        }
        //Para garantir que todos os resultados de classficação de arestas sejam iguais:
        Collections.sort(list);
        return list;
    }

    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < this.matriz.length; i++) {
            if (this.matriz[vertice][i] != Integer.MAX_VALUE) {
                set.add(i);
            }
        }
        return set;
    }

    @Override
    public void setarPeso(int origem, int destino, int peso) throws Exception {
        this.matriz[origem][destino] = peso;
    }

    @Override
    public Set<Integer> vertices() {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < this.matriz.length; i++) {
            set.add(i);
        }

        return set;
    }

    @Override
    public int getPeso(int origem, int destino) {
        return this.matriz[origem][destino];
    }

    @Override
    public Grafo getTransposto() throws Exception {
        Grafo g = new MatrizAdjacencia(numeroDeVertices());
        for (int i = 0; i < numeroDeVertices(); i++) {
            for (int j : listDeAdjacentes(i)) {
                g.adicionarAresta(j, i, matriz[i][j]);
            }
        }
        return g;
    }

    private boolean verificarNaoDuplicata(List<Aresta> list, int origem, int destino) {
        for (Aresta a : list) {
            if (a.getDestino() == origem && a.getOrigem() == destino) {
                return false;
            }
        }
        return true;
    }

    private void adicionarArestaSemDuplicata(List list, int origem, int destino) {
        if (verificarNaoDuplicata(list, origem, destino)) {
            list.add(new Aresta(origem, destino, matriz[origem][destino]));
        }
    }

    @Override
    public List<Aresta> arestas() {
        List<Aresta> list = new LinkedList();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != Integer.MAX_VALUE) {
                    list.add(new Aresta(i, j, matriz[i][j]));
                }
            }
        }
        return list;
    }

    @Override
    public boolean existePesoNegativo() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getCustoGrupo(int[] grupos) {
        int custo = 0;
        for (int p1 : grupos) {
            for (int p2 : grupos) {
                custo += matriz[p1][p2];
            }
        }
        return custo;
    }
}
