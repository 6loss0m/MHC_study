package BLIND_2019;

import java.util.Arrays;
/*
    y 값의 내림차순으로 정렬하면
    루트 노드를 구할 수 있습니다.

    그러면 루트 노드를 기준으로
    모든 노드 x 값의 크기와 비교하여 left, right 노드를 구하여 트리를 완성 할 수 있습니다.

    트리를 완성하고나서는 전위탐색, 후위탐색을통해 답을 반환하면 됩니다.

 */

public class FindGame {
    static int[][] ret;
    static int idx = 0;

    public static void main(String[] args) {
        int[][] nodeinfo ={{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

        ret=new int[2][nodeinfo.length];

        Node[] nodes = new Node[nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            nodes[i]=new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
        }
        Arrays.sort(nodes);
        Node root= nodes[0];
        for(int i=1;i<nodes.length;i++){
            insert(root,nodes[i]);
        }

        pre(root);
        idx=0;
        post(root);
        System.out.println(Arrays.toString(ret[0]));
        System.out.println(Arrays.toString(ret[1]));

    }
    static void insert(Node parent, Node child){
        if(parent.x>child.x){
            if(parent.left == null){ parent.left=child; }
            else { insert(parent.left, child); }
        }
        else{
            if(parent.right == null){ parent.right=child; }
            else { insert(parent.right, child);}
        }
    }
    static void pre(Node node){
        if(node==null){ return; }
        ret[0][idx++]=node.value;
        pre(node.left);
        pre(node.right);
    }

    static void post(Node node){
        if(node==null){ return; }
        post(node.left);
        post(node.right);
        ret[1][idx++]=node.value;

    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) { return o.y- this.y; }
    }

}
