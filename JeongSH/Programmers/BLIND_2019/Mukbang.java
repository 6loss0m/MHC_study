package BLIND_2019;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Mukbang {
    public static void main(String[] args) {
        int[] food_times={3, 1, 2};
        long k =5;

        ArrayList<Food> foods = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) { foods.add(new Food(i+1,food_times[i])); }
        Collections.sort(foods, (o1, o2) -> o1.time - o2.time);

        int n = foods.size();
        int pertime = 0;
        int i=0;
        for(Food f: foods){
            long diff = f.time-pertime;
            if(diff!=0){
                long spend = diff*n;
                if(spend <=k){
                    k-= spend;
                    pertime = f.time;
                }
                else{
                    k%=n;
                    foods.subList(i,food_times.length).sort((o1, o2) -> o1.n-o2.n);
                    System.out.println(foods.get(i+(int)k).n);
                    return;
                }
                i++;
                n--;
            }
        }
    }
    static class Food{
        int n;
        int time;

        public Food(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }
}
