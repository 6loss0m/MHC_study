package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1168_Josephus2 {
    static int[] tree = new int[400005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int x = K;
        init(1,1,N);
        sb.append("<");
        for(int i=0; i<N-1; i++) {
            sb.append(query(1,1,N,x)).append(", ");
            x += K-1;
            if(x%tree[1]==0) {x=tree[1];}
            else {x%=tree[1];}
        }
        sb.append(query(1,1,N,x)).append("").append(">");
        System.out.println(sb);

    }
    static int init (int node, int s, int e){
        if(s==e) {return tree[node]=1;}
        int mid = (s+e)/2;
        return tree[node] = init(2*node,s,mid)+ init(2*node+1,mid+1,e);
    }
    static int query(int node, int s, int e, int k){
        tree[node]--;
        if(s==e) {return s;}
        int mid = (s+e)/2;
        if(tree[2*node] >= k) {return query(2*node,s,mid,k);}
        else return query(2*node+1,mid+1,e,k-tree[2*node]);
    }
}
