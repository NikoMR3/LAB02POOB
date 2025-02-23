import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Graph {
    
        private ArrayList<String> list_vertices;
        private ArrayList<String[]> list_edges;
    
    public Graph(String[] vertices, String[][] edges){
        
        list_vertices = new ArrayList<String>();  
        list_edges = new ArrayList<String[]>();
        
        for(String v : vertices){
            addVertex(v);
        };
        
        for(String[] e : edges){
            addEdge(e);
        }; 
    }
    
    public void addVertex(String vertex){
        if (!contains(vertex)){
            list_vertices.add(vertex.toUpperCase());
        }
    }
    
    public boolean contains(String vertex){
        return list_vertices.contains(vertex.toUpperCase());
    }
    
    public String[] upperEdge(String[] edge){
        String vertex1 = edge[0].toUpperCase();
        String vertex2 = edge[1].toUpperCase();
        String[] upper = {vertex1,vertex2};
        return upper;
    }
    
    public void addEdge(String[] edge){
        String[] edgeToAdd = upperEdge(edge);
        if (!contains(edgeToAdd)){
            list_edges.add(edgeToAdd);
        }
    }
    
    public boolean contains(String[] edge){
        String [] revisionEdge = upperEdge(edge); 
        for(String[] edgeElement : list_edges){
            if (Arrays.equals(revisionEdge,edgeElement)){
                return true;
            }
        }
        return false;
    }
    
    public Graph path(String start, String end){
        
        return null;
    }

    public Graph union (Graph g){
        for(String v : g.list_vertices){
            addVertex(v);
        } 
        for(String[] e : g.list_edges){
            addEdge(e);
        } 
        return this;
    }

    
    public int vertices(){
        return list_vertices.size();
    }
    
    public int edges(){
        return list_edges.size();
    }    
    
    
    public boolean equals(Graph g){
        return true;
    }
    
    public boolean equals(Object g){
        return equals((Graph)g);
    }
    
    public void alphabetize(){
        Collections.sort(list_edges, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return Character.compare(a[0].charAt(0), b[0].charAt(0));
            }
        });
    }
    
    //Only arcs in space-separated tuples. The vertices are capitalized. The edges must always be in alphabetical order.
    //For example, (A, B) (C, D) 
    public String toString() {
        alphabetize();
        String tuple;
        tuple = "";
        for (String[] e: list_edges) {
            tuple += "("+e[0]+","+e[1]+")";
            }
         return tuple;
    }
       
}
