public class Main{
  public class Edge{
    int src,dest;
    public Edge(int src. int dest){
      this.src=src;
      this.dest=dest;
    }
  }
  public static boolean cycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par){
    vis[curr]=true;
    for(int i=0;i<graph[curr].size();i++){
      Edge e=graph[curr].get(i);
      if(vis[e.dest] && e.dest!= par)return true;
      if(!vis[e.dest] && cycleUndirected(graph, vis, e.dest, curr ))return true;
    }
    return false;
  }
  public static boolean cycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
    vis[curr]=true;
    rec[curr]=true;
      for(int i=0;i<graph[curr].size();i++){
         Edge e=graph[curr].get(i);
         if(rec[e.dest])return true;
         if(!vis[e.dest] && cycleDirected(graph, vis, e.dest, rec))return true;
      }
    rec[curr]=false;
    return false;
  }
    public static void createGraph(ArrayList<Edge> graph[]){
    graph[0].add(new Edge(0,2));

    graph[1].add(new Edge(1,2));
    graph[1].add(new Edge(1,3));

    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));
    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(3,1));
    graph[3].add(new Edge(3,2));
      
    }
  public static void main(String args[]){
    int V= 4;
    ArrayList<Edge> graph[]=new ArrayList[V];
    for(int i=0;i<V;i++){
      graph[i]=new ArrayList<Edge>();
    }
    createGraph(graph);
    cycleUndirected(graph, new boolean[V], 0, -1);
    cycleDirected(graph, new boolean[V], 0, new boolean [V]);
  }
}
