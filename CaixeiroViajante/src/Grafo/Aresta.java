package Grafo;

/**
 *
 * @author gusta
 */
public class Aresta {
    private int origem;
    private int destino;
    private int peso;
    
    public Aresta(int origem, int destino, int peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    
    public int getOrigem(){
        return this.origem;
    }
    
    public int getDestino(){
        return this.destino;
    }
    
    public int getPeso(){
        return this.peso;
    }
}