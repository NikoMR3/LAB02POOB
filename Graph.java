import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private String[] vertices;
    private String[][] matriz;
    
    public Graph(String[] vertices, String[][] edges){
        this.vertices = vertices;
        this.matriz = new String[vertices.length][vertices.length];
        
        for(int i = 0; i<vertices.length;i++){
            Arrays.fill(matriz[i],"0");
        };
        
        for(int i = 0;i<edges.length;i++){
            String componentX = edges[i][0];
            String componentY = edges[i][1];
            System.out.print(componentX+"y"+componentY+"\n");
            path(componentX,componentY);
        }
        
        
    }
    

    public boolean contains(String vertex){
        
        return false;
    }
    
    private int getIndex(String[] array, String elemento){
        int indice = 0;
        indice = Arrays.asList(array).indexOf(elemento);
        
        return indice;
    }
    
    
    /**
     * Conectar vertices
     */
    public Graph path(String start, String end){
        
        int componenteXIndex = getIndex(this.vertices,start);
        int componenteYIndex = getIndex(this.vertices,end);
        
        if (this.matriz[componenteXIndex][componenteYIndex] == "0"){
            this.matriz[componenteXIndex][componenteYIndex] = "1";
        }
        return null;
    }
    

    public Graph union (Graph g){
        return null;
    }
    
    
    public int vertices(){
        return this.vertices.length;
    }
    
   
    public int edges(){
        return 0;
    }    
    
    
    public boolean equals(Graph g){
        return false;
    }
    
    public boolean equals(Object g){
        return equals((Graph)g);
    }
    
    //Only arcs in space-separated tuples. The vertices are capitalized. The edges must always be in alphabetical order.
    //For example, (A, B) (C, D) 
    public String toString(String[] tupla) {
        String primerComponente = "";
        String segundoComponente = "";
        primerComponente = tupla[0];
        segundoComponente = tupla[1];
        System.out.print(primerComponente);
        System.out.print(segundoComponente);
        
        
        
      return "";
    }
    
    
    /**
         * Clase MAIN (OPCIONAL)
         * 
    */

    public void mostrarMatriz() {
        System.out.print("  " + Arrays.toString(vertices) + "\n");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(vertices[i] + " " + Arrays.toString(matriz[i]) + "\n");
        }
    }

    public static void main() {
        // Definir nodos
        String[] nombresNodos = {"A", "B", "C", "D"};
        String[][] arcos = {{"A","B"},{"B","C"},{"C","D"},{"D","A"}};

        // Crear el grafo
        Graph grafo = new Graph(nombresNodos,arcos);
        grafo.mostrarMatriz();
        

        

        // Mostrar matriz de adyacencia
        
    }
    
}
