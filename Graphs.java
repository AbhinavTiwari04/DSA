public class Main{
  public class Edge{
    int src,dest;
    public Edge(int src. int dest){
      this.src=src;
      this.dest=dest;
    }
  }
  public static void bfs(ArrayList<Edge> graph[], int curr){
    Queue<Integer> q=new LinkedList<>();
    q.offer(curr);
    boolean vis[]=new vis[graph.length];
    while(!q.isEmpty()){
      vis[curr]=true;
      for(int i=0;i<graph[i].size();i++){
        
      }
    }
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
    
  }
  public static void main(String args[]){
    int V= 4;
    ArrayList<Edge> graph[]=new ArrayList[V];
    for(int i=0;i<V;i++){
      graph[i].add(new ArrayList<Edge>());
    }
    createGraph(graph);
    bfs(graph);
    dfs(graph, 0);
  }
}
