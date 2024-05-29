import java.util.*;

public class Chakravyuha {
    public static boolean check(List<Integer> v, int initialPower, int p, int a, int b, int i) {
        if (i >= v.size())
            return true;
        if (p <= 0)
            return false;

        boolean skipResult = false, rechargeResult = false;

        if (a > 0) {
            skipResult = check(v, initialPower, p, a - 1, b, i + 1);
        }

        if (p >= v.get(i)) {
            int newPower = p - v.get(i);

            if (i == 2 || i == 6) {
                if (newPower < (v.get(i) / 2))
                    return false;
            }

            boolean battleResult = check(v, initialPower, newPower, a, b, i + 1);
            if (battleResult)
                return true;
        }

      
        if (b > 0) {
            rechargeResult = check(v, initialPower, initialPower, a, b - 1, i);
        }

        return skipResult || rechargeResult; 
    }

    public static void main(String[] args) {
        // Test Case 1
        List<Integer> v = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 6, 7, 8, 2, 3, 10));
        int p = 1, a = 11, b = 0;
        System.out.println("Test case 1: " + (check(v, p, p, a, b, 0) ? "Can cross" : "Cannot cross"));

        // Test Case 2
        List<Integer> v1 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110));
        int p1 = 50, a1 = 3, b1 = 10;
        System.out.println("Test case 2: " + (check(v1, p1, p1, a1, b1, 0) ? "Can cross" : "Cannot cross"));
    }
}
