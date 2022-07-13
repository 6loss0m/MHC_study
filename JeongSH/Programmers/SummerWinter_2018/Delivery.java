package SummerWinter_2018;

import java.util.ArrayList;

/*
    단순한 dfs 를 사용하면 시간초과가 납니다.

    그렇기때문에, 방문횟수를 줄여야 합니다.
    이미 방문한 적 있는 도시까지의 비용이 지금 방문한 비용보다 적다면 방문하지않습니다.

 */

public class Delivery {
    static int[] visit = new int[51];
    static City[] cities = new City[51];
    static int K;
    static int N;

    public static void main(String[] args) {
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        N = 6;
        K = 4;

        for(int[] r: road){
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            if(cities[from]==null) cities[from] = new City(to,cost);
            else{
                cities[from].nextCity.add(to);
                cities[from].cost.add(cost);
            }

            if(cities[to]==null) cities[to] = new City(from,cost);
            else{
                cities[to].nextCity.add(from);
                cities[to].cost.add(cost);
            }
        }

        dfs(1,0);

        int cnt=1;
        for (int i=2; i<=N; i++){ if(visit[i]!=0){cnt+=1;}
            System.out.println(i+" :"+visit[i]);
        }
        System.out.println(cnt);

    }
    static void dfs(int now, int cost){
        if(visit[now] != 0 && cost >= visit[now]) {return;} // 방문한 적이있고, now 도시까지의 방문 비용이 현재 cost 보다 적다면 방문하지않습니다.
        visit[now] = cost;
        int size = cities[now].nextCity.size();
        for (int i = 0; i < size; i++) {
            int nextCity = cities[now].nextCity.get(i);
            int nextCost = cities[now].cost.get(i);
            if( cost+nextCost<=K ){ dfs(nextCity,cost+nextCost); }
        }
    }
    static class City{
        ArrayList<Integer> nextCity;
        ArrayList<Integer> cost;

        public City(int n, int c) {
            nextCity=new ArrayList<>();
            cost=new ArrayList<>();
            nextCity.add(n);
            cost.add(c);
        }
    }
}