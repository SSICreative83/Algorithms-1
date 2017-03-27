public class ConnectingGraph { 
    private int[] father;
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b) {
            father[root_a] = root_b;
        }
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        return root_a == root_b;
    }
    

    private int find(int a) {
        if(father[a] == 0) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
}
