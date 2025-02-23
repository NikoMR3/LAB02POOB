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
        alphabetize();
        g.alphabetize();
        boolean condicion2;
        
        if (list_edges.size() != g.list_edges.size()) {
            return false; 
        }
        for (int i = 0; i < edges(); i++) {
            if (!Arrays.equals(list_edges.get(i), g.list_edges.get(i))){
                return false;
            }  
        }
        
        Collections.sort(list_vertices);
        Collections.sort(g.list_vertices); 
        condicion2 = list_vertices.equals(g.list_vertices);
        
        return condicion2;
    }
    
    public boolean equals(Object g){
        return equals((Graph)g);
    }

    public void alphabetize(){ 
        ArrayList<String[]> sortedEdges = new ArrayList<>();
        for (String[] edge : list_edges) {
            String[] edgeCopy = {edge[0], edge[1]};
            sortedEdges.add(edgeCopy);
        }
        Collections.sort(sortedEdges, new Comparator<String[]>(){
            @Override
            public int compare(String[] a, String[] b) {
                // Comparar primer vértice
                int cmp = a[0].compareTo(b[0]);
                if (cmp != 0) return cmp;
                return a[1].compareTo(b[1]);
                } 
        });
        list_edges = sortedEdges;
    }
    
    //Only arcs in space-separated tuples. The vertices are capitalized. The edges must always be in alphabetical order.
    //For example, (A, B) (C, D) 
    public String toString() {
        alphabetize();
        StringBuilder sb = new StringBuilder();
        for (String[] edge : list_edges) {
            sb.append("(")
            .append(edge[0])  
            .append(", ")
            .append(edge[1])  
            .append(") ");
        }
        return sb.length() > 0 ? sb.toString().trim() : "";
    }
         
}
