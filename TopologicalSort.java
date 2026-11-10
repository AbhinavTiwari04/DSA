import java.util.*;
public class Main{
  public class Edge{
    int src, dest;
    public Edge(int src, int dest){
      this.src=src;
      this.dest=dest;
    }
  }
  public void topoSort(ArrayList<Edge> graph, boolean vis[], Stack<Integer> st, int curr){
    vis[curr]=true;
    for(int i=0;i< graph[curr].size();i++){
      Edge e=graph[curr].get(i);
      if(!vis[e.dest]){
        topoSort(graph, vis, st, e.dest);
      }
    }
    st.push(curr);
  }
  public static void main(String args[]){
    int V=4;
    ArrayList<Edge> graph=new ArrayList[V];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<V;i++)
      if(!vis[i])
        topoSort(graph, vis[i], st, i);
    while(st.isEmpty())
      System.out.print(st.pop()+" ");
  }
}
