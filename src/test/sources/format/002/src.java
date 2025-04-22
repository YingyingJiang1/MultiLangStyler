import java.util.Scanner;

public class CircleInRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input values
        int W = scanner.nextInt(); // width of rectangle
        int H = scanner.nextInt(); // height of rectangle
        int x = scanner.nextInt(); // x-coordinate of circle center
        int y = scanner.nextInt(); // y-coordinate of circle center
        int r = scanner.nextInt(); // radius of circle
        
        // Check if circle is inside rectangle
        boolean isInside = isCircleInsideRectangle(W, H, x, y, r);
        
        // Print result
        System.out.println(isInside ? "Yes" : "No");
        
        scanner.close();
    }
    
    public static boolean isCircleInsideRectangle(int W, int H, int x, int y, int r) {
        // Check if the circle fits inside the rectangle
        // For the circle to be inside, its edges must not cross the rectangle's borders
        
        // Check left border
        if (x - r < 0) return false;
        
        // Check right border
        if (x + r > W) return false;
        
        // Check bottom border
        if (y - r < 0) return false;
        
        // Check top border
        if (y + r > H) return false;
        
        return true;
    }
}