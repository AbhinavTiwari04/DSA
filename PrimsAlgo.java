public class Main{
  public static class Edge{
    int src,dest,wt;
    public Edge(int src, int dest, int w){
      this.src=src;
      this.dest=dest;
      this.wt=w;
    }
  }
  public static class Pair implements Comparable<Pair>{
    int node,cost;
    public Pair(int n, int c){
      node=n;
      cost=c;
    }
    @Override
    public int compareTo(Pair p2){
      return cost- p2.cost;
    }
  }
  public static void primsAlgo(ArrayList<Edge> graph[], int V){
   PriorityQueue<Pair> q=new PriorityQueue<>();// Non MST set (called set only for wording not actual set)
    q.offer(new Pair(0,0));
    boolean vis[]=new boolean[V]; // MST set
    int mstCost=0;
    while(!q.isEmpty()){
      Pair curr= q.poll();
      if(!vis[curr.node]){
        vis[curr.node]=true;
        mstCost+=curr.cost; 
        for(int i=0;i<graph[curr.node].size();i++){
          Edge e=graph[curr.node].get(i);
          q.offer(new Pair(e.dest, e.wt));
        }
      }
    }
    System.out.println(mstCost);
  }  
  public static void createGraph(ArrayList<Edge> graph[], int V){
    for(int i=0;i<V;i++){
      graph[i]=new ArrayList<Edge>();
    }
    graph[0].add(new Edge(0,1,10));
    graph[0].add(new Edge(0,2,15));
    graph[0].add(new Edge(0,3,30));

    graph[1].add(new Edge(1,0,10));
    graph[1].add(new Edge(1,3,40));
    
    graph[2].add(new Edge(2,0,15));
    graph[2].add(new Edge(2,3,30));

    graph[3].add(new Edge(3,1,40));
    graph[3].add(new Edge(3,2,50));  
    }
  public static void main(String args[]){
    int V= 4;
    ArrayList<Edge> graph[]=new ArrayList[V];
    createGraph(graph, V);
    primsAlgo(graph, V);
  }
}
