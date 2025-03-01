public class Ref {
    public static void main(String[] args) {
       int i = 0;
       int sum = 0;
       while (i < 10) {
           sum += i * (i + 1);
           i++;
       }
        System.out.println(sum);
    }
}
