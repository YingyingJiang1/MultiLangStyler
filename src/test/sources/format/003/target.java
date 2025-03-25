import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int count2 = 0;
        int countOther = 0;
        for(int i : countMap.values()){
            if(i == 2){
                count2++;
            } else {
                countOther++;
            }
        }
        if(count2 == 2 && countOther == 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}