package BLIND_2018_2;

import java.util.HashMap;
/*
    트라이라는 자료구조를 사용하여 풀이하였습니다.
    트라이는 트리구조의 응용구조로 검색을 용이하게 해줍니다.

    트라이는 root node 부터
    각각의 문자열을 문자(c)로 쪼개어
    c를 key 로 갖는 hashMap<key,node> child 구조로 이루어져있습니다.
    Node{
        HashMap<char,node> child
        childCount
    }

    중요한 점은 node 에 input 할 때,
    거쳐오는 노드의 childCount 를 1씩 증가 시켜주어야 합니다.
    word , war  을 넣는다고 한다면

    1. word 부터
    root / count :1
    w / count :1
    o / count :1
    r / count :1
    d / count :1

    2. war
    root / count :2
    w / count:2
    a / count:1
    r / count:1

    이 됩니다.
                root
                 'w':2
            'o':1     'a':1
            'd':1     'r':1
            'r':1
            'd':1

    그리고 문자열의 마지막을 표시하기 위해 단어의 마지막 노드에 '*'를 추가해주었습니다.
        (원래는 boolean 을 사용하여 end 를 체크하는것이 기본)

    '*'를 추가하여
    war , warrior 의 분기점을 추가하여 단어를 쳐야하는 갯수를 세기 쉽게하였습니다.
        w
        a
        r
    r       *
    i
    o
    r
    *

    만약 boolean end 를 썼다면,
    war, warrior 를 구분할 때
    조건식이
    if( end && childCount>=2 )  // 하나의 문자는 끝났지만, 길이 더 있을 경우 탐색을 계속해야됨.
    가 추가되어야합니다.

 */


public class AutoComplete {
    static Node root= new Node();

    public static void main(String[] args) {
        String[] words = {"word","war","warrior","world"};

        for(String w : words){ insert(w); }
        System.out.println(search(root,0));
    }

    static int search(Node root, int cnt){

        if(root.childCount==1){ return cnt; }   // 길이 하나밖에없는 즉 자동완성이 되는 경우
        int count = 0;

        for(char key: root.child.keySet()){
            if(key=='*'){ count+= cnt; }        // 하나의 단어가 끝이나므로 현재까지 친 단어의 갯수를 더해줌.
            else { count += search(root.child.get(key), cnt+1); }
        }
        return count;
    }

    static void insert(String word){
        Node curNode = root;
        for(char c : word.toCharArray()){
            Node newNode = curNode.put(c);
            curNode = newNode;
        }
        curNode.put('*');
    }

    static class Node{
        HashMap<Character,Node> child = new HashMap<>();
        int childCount = 0;

        Node put(char c){
            childCount++;
            if(!child.containsKey(c)){
                child.put(c,new Node());
            }
            return child.get(c);
        }
    }
}
