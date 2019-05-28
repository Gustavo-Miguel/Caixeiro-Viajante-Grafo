/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.List;
import java.util.Set;

/**
 *
 * @author gusta
 */
public interface Grafo {

    public void setMatriz(int[][] matriz);

    public int getCustoGrupo(int[] grupos);

    public void adicionarAresta(int origem, int destino) throws Exception;

    public void adicionarAresta(int origem, int destino, int peso) throws Exception;

    public boolean existeAresta(int origem, int destino);

    public int grauDoVertice(int vertice) throws Exception;

    public int numeroDeVertices();

    public int numeroDeArestas();

    public List<Integer> listDeAdjacentes(int vertice) throws Exception;

    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception;

    public void setarPeso(int origem, int destino, int peso) throws Exception;

    public Set<Integer> vertices();

    public List<Aresta> arestas();

    public int getPeso(int origem, int destino);

    public Grafo getTransposto() throws Exception;

    public boolean existePesoNegativo();
}
