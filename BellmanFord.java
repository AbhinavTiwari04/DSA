public class Main{
  public static class Edge{
    int src,dest,wt;
    public Edge(int src, int dest, int w){
      this.src=src;
      this.dest=dest;
      this.wt=w;
    }
  }
  public static void bellmanFord(ArrayList<Edge> graph[], int src, int V){
    int dist[]=new int[V];
    for(int i=0;i<V;i++){
      if(i!=src)
        dist[i]=Integer.MAX_VALUE;
    }
    //loop for valid iterations for bellman ford algo which is no. of vertices minus one
    for(int k=0;k<V-1;k++){
      // loop for going through all edges
      for(int i=0;i<V;i++){
        for(int j=0;j<graph[i].size();j++){
          Edge e= graph[i].get(j);
          int u=e.src;
          int v=e.dest;
          if(dist[u]!=Integer.MAX_VALUE && dist[u]+ e.wt <dist[v]){
            dist[v]=dist[u]+e.wt;
          }
        }
      }
    }
    //Bellman ford fails for cycle with negative edges, that means loops will produce lower distance infinetely so another iteration is done to check whther 
    // bellman ford algo is producing a low output, hence this is cycle detection is bellman ford
     for(int i=0;i<V;i++){
        for(int j=0;j<graph[i].size();j++){
          Edge e= graph[i].get(j);
          int u=e.src;
          int v=e.dest;
          if(dist[u]!=Integer.MAX_VALUE && dist[u]+ e.wt <dist[v]){
            System.out.println("Negative Edge Cycle detected");
            return;
          }
        }
      }
    }
    for(int i: dist)
      System.out.print(i+" ");
  }  
  public static void createGraph(ArrayList<Edge> graph[], int V){
    for(int i=0;i<V;i++){
      graph[i]=new ArrayList<Edge>();
    }
    graph[0].add(new Edge(0,1,2));
    graph[0].add(new Edge(0,2,4));

    graph[1].add(new Edge(1,2,-4));
    
    graph[2].add(new Edge(2,3,2));

    graph[3].add(new Edge(3,4,4));
    
    graph[4].add(new Edge(4,1,-1));  
    }
  public static void main(String args[]){
    int V= 5;
    ArrayList<Edge> graph[]=new ArrayList[V];
    createGraph(graph, V);
    bellmanFord(graph, 0,V);
  }
}
