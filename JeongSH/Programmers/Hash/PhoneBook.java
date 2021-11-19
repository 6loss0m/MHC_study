public class PhoneBook {

    // 시간복잡도1 : O(n^2)
    //Hash없이 풀어본 방식.
    public static void main(String args[]){
        // testcase
        String[] phoneBook = {"119", "97674223", "1195524421"};
        boolean result=true;

        //phoneBook을 순회하면 서로가 서로의 접두사인지 확인하고
        //접두사가 맞으면 거기서 return 을 바로하면 더이상의 무의미한 순회를 하지않음.
        for(int i=0; i<phoneBook.length; i++){
            for(int j=i+1; j<phoneBook.length; j++){
                if(phoneBook[i].startsWith(phoneBook[j]) || phoneBook[j].startsWith(phoneBook[i]))
                {result=false;}
            }
        }
        System.out.println(result);
    }



    // 시간복잡도2 : O(n^2)
    //hash사용하여 풀어본 방식
    public class PhoneBook {
        public static void main(String args[]){
            // testcase
            String[] phoneBook = {"119","11", "97674223", "1195524421"};

            boolean result=true;
            HashMap<String,Integer> hashMap = new HashMap<>();

            for(int i=0; i<phoneBook.length; i++){
                hashMap.put(phoneBook[i],i);
            }
            // substring(start,end) start는 시작 인덱스 end는 end인덱스 바로전까지 자르는 메소드
            // i=0 j=2 일 경우 phoneBook[i].substring(0,j) 는 문자열 "11"이 됩니다.
            // 자기자신이 key로 포함되는지 탐색하는 부분을 방지하기 위해.
            
            for(int i=0; i<phoneBook.length; i++){
                for(int j=0; j<phoneBook[i].length(); j++){
                    if(hashMap.containsKey(phoneBook[i].substring(0,j)))
                    {
                        //return
                        result = false;}
                }
            }
            //return
        }
}
