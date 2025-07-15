import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse(dateString, formatter);

        if (date.isBefore(LocalDate.of(2019, 5, 1))) {
            System.out.println("Heisei");
        } else {
            System.out.println("TBD");
        }
    }
}