package henry;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the THIRD largest in an array.
 */
public class Lab2Find3rdElement {
    static List<Integer> generateInput(int size) {
        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            input.add((int) (Math.random() * Integer.MAX_VALUE));
        }

        return input;
    }

    static int findUsing3Loops(List<Integer> input) {
        int firstMax = input.get(0), secondMax = input.get(0), thirdMax = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            int val = input.get(i);
            if (val > firstMax) {
                firstMax = val;
            }
        }

        for (int i = 1; i < input.size(); i++) {
            int val = input.get(i);
            if (val > secondMax && val < firstMax) {
                secondMax = val;
            }
        }

        for (int i = 1; i < input.size(); i++) {
            int val = input.get(i);
            if (val > thirdMax && val < secondMax) {
                thirdMax = val;
            }
        }

        return thirdMax;
    }

    static int findUsingOneLoop(List<Integer> input) {
        int firstMax = input.get(0), secondMax = input.get(0), thirdMax = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            int val = input.get(i);
            if (val > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = val;
            } else if (val > secondMax) {
                thirdMax = secondMax;
                secondMax = val;
            } else if (val > thirdMax) {
                thirdMax = val;
            }
        }

        return thirdMax;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int size = i * 1000_000;
            System.out.println("Size: " + size);
            List<Integer> input = generateInput(size);

            long start = System.currentTimeMillis();
            int result = findUsing3Loops(input);
            long end = System.currentTimeMillis();
            System.out.println("3 loop: Result: " + result + "; time: " + (end - start));

            start = System.currentTimeMillis();
            result = findUsingOneLoop(input);
            end = System.currentTimeMillis();
            System.out.println("1 loop: Result: " + result + "; time: " + (end - start));
        }
    }
}
