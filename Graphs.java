public class Main{
  public class Edge{
    int src,dest;
    public Edge(int src. int dest){
      this.src=src;
      this.dest=dest;
    }
  }
  // Single component Graph
  public static void bfs(ArrayList<Edge> graph[], int curr){
    Queue<Integer> q=new LinkedList<>();
    q.offer(curr);
    boolean vis[]=new boolean[graph.length];
    while(!q.isEmpty()){
      int node= q.poll();
      vis[node]=true;
      System.out.print(node+" ");
      for(int i=0;i<graph[node].size();i++){
        Edge e=graph[node].get(i);
        if(!vis[e.dest]){
          q.offer(e.dest);
          vis[e.dest]=true;
        }
      }
    }
  }
  //Multi Component Graph
  public static void bfsWC(ArrayList<Edge> graph[], boolean vis[], int curr){
    vis[curr]=true;
    Queue<Integer> q=new LinkedList<>();
    q.offer(curr);
    while(!q.isEmpty()){
      int node= q.poll();
      System.out.print(node+" ");
      for(int i=0;i<graph[node].size();i++){
        Edge e=graph[node].get(i);
          if(!vis[e.dest]){
          q.offer(e.dest);
          vis[e.dest]=true;
          }
        }
      }
  }
  //Single component dfs + Disconnected graph
  public static void dfs(ArrayList<Edge> graph[], boolean vis[] ,int curr){
    vis[curr]=true;
    System.out.print(curr+" ");
    for(int i=0;i<graph[curr].size();i++){
      Edge e=graph[curr].get(i);
      if(!vis[e.dest])
        dfs(graph, vis, e.dest);
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
      graph[i]=new ArrayList<Edge>();
    }
    createGraph(graph);
    //Single component call
    bfs(graph, 0);
    //Multi Component graph
    boolean vis[]= new boolean[V];
    for(int i=0;i<V;i++){
    if(!vis[i])
    bfsWC(graph, vis, i);
    }
    //Single component call
    dfs(graph, vis ,0);
    //disconnected graph
    for(int i=0;i<V;i++){
      if(!vis[i]){
        dfs(graph, vis, i);
      }
    }
  }
}
