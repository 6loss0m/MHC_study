package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    dfs로 전위,중위,후위 탐색을 구현하는 문제입니다.

    전위
        현재노드 출력 - left - right
    중위
        left - 현재노드 출력 - right
    후위
        left - right - 현재노드 출력

 */

public class boj1991_TreeSearch {
    static Node[] tree = new Node[32];
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N; i++){
            input=br.readLine().split(" ");
            tree[input[0].charAt(0)-'A']=new Node(input[0],input[1].charAt(0)-'A',input[2].charAt(0)-'A');
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb);

    }

    //전위순회
    public static void preorder(int n){
        if(n<0){ return; }
        Node node = tree[n];
        sb.append(node.name);
        preorder(node.left);
        preorder(node.right);
    }

    //중위순회
    public static void inorder(int n){
        if(n<0){ return; }
        Node node = tree[n];
        inorder(node.left);
        sb.append(node.name);
        inorder(node.right);
    }

    //후위순회
    public static void postorder(int n){
        if(n<0){ return; }
        Node node = tree[n];
        postorder(node.left);
        postorder(node.right);
        sb.append(node.name);
    }
    static class Node{
        int left;
        int right;
        String name;

        public Node(String name, int left, int right) {
            this.left = left;
            this.right = right;
            this.name = name;
        }
    }

}
