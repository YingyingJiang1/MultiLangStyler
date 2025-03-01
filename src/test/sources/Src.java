public class Src {
    public static  void main(String[] args) {
        int sum = 0;
        while (sum < 100) {
            sum += sum + 1;
        }
        System.out.println(sum);
    }
}