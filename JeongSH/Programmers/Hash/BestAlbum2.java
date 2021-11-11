import java.util.*;

/*
    시간복잡도: O(n^2)
 */
public class BestAlbum2 {
    public static void main(String args[]) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        HashMap<String, Object> genresMap = new HashMap<String, Object>(); // <장르,곡정보>
        HashMap<String, Integer> playMap = new HashMap<String, Integer>(); // <장르, 총 장르 재생수>
        ArrayList<Integer> resultArrList = new ArrayList<Integer>();

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            HashMap<Integer, Integer> infoMap; //<곡 번호, 재생횟수>
            if (genresMap.containsKey(key)) {
                infoMap = (HashMap<Integer, Integer>) genresMap.get(key);
            } else {
                infoMap = new HashMap<Integer, Integer>();
            }
            infoMap.put(i, plays[i]);
            genresMap.put(key, infoMap);

            if (playMap.containsKey(key)) {
                playMap.put(key, playMap.get(key) + plays[i]);
            } else {
                playMap.put(key, plays[i]);
            }
        }

        // 장르의 총 재생횟수별로 장르 내림차순정렬
        Iterator it = sortByValue(playMap).iterator();

        //내림차순 장르로 순회
        while (it.hasNext()) {
            String key = (String) it.next();
            //해당 장르 내 재생횟수로 곡 정보를 내림차순으로 정렬
            Iterator indexIt = sortByValue((HashMap<Integer, Integer>) genresMap.get(key)).iterator();
            int playsCnt = 0;
            
            //해당 장르내에서 두곡만 수록해야하므로 앞에서 두 곡만 add
            while (indexIt.hasNext()) {
                resultArrList.add((int) indexIt.next());
                playsCnt++;
                if (playsCnt > 1) break;
            }
        }

        //answer[] 에 넣고 결과값 보내기.
            int[] answer = new int[resultArrList.size()];

            for (int i = 0; i < resultArrList.size(); i++) {
                answer[i] = resultArrList.get(i).intValue();
            }

            for (int i = 0; i < answer.length; i++) {
                System.out.println(answer[i]);
            }
        }

        //value 값으로 key를 내림차순 정렬
    private static ArrayList sortByValue(final Map map){
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator(){
            public int compare(Object o1, Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        return keyList;
    }
}
