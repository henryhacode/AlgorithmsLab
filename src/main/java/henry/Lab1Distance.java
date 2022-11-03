package henry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Find the largest distance between any two even integers in an integer array
 */
public class Lab1Distance {
    static List<Integer> generateInput(int size) {
        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            input.add((int) (Math.random() * Integer.MAX_VALUE));
        }

        return input;
    }

    static int alg1UsingNewArray(List<Integer> input) {
        List<Integer> evenNums = new ArrayList<>();
        for (Integer n : input) {
            if (n % 2 == 0) {
                evenNums.add(n);
            }
        }

        int max = 0;
        for (int i = 0; i < evenNums.size(); i++) {
            for (int j = 0; j < evenNums.size(); j++) {
                int dis = Math.abs(evenNums.get(i) - evenNums.get(j));
                if (dis > max) {
                    max = dis;
                }
            }
        }

        return max;
    }

    static int alg2UsingNestedLoopOnly(List<Integer> input) {
        int max = 0;
        for (int i = 0; i < input.size(); i++) {
            int val1 = input.get(i);
            if (val1 % 2 == 0) {
                for (int j = 0; j < input.size(); j++) {
                    int val2 = input.get(j);
                    if (val2 % 2 == 0) {
                        int dis = Math.abs(val2 - val1);
                        if (dis > max) {
                            max = dis;
                        }
                    }
                }
            }
        }

        return max;
    }

    static int alg3UsingOneLoop(List<Integer> input) {
        int max = 0, min = Integer.MAX_VALUE;
        for (Integer val : input) {
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }

        return max - min;
    }

    static int alg4UsingStream(List<Integer> input) {
        int max = input.stream().max(Comparator.naturalOrder()).orElse(0);
        int min = input.stream().min(Comparator.naturalOrder()).orElse(0);

        return max - min;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int size = i * 1000;
            List<Integer> input = generateInput(size);
//            System.out.println(input);

            System.out.println("Size: " + size);
            long start = System.currentTimeMillis();
            int alg1Val = alg1UsingNewArray(input);
            long end = System.currentTimeMillis();
            System.out.println("Alg1: val: " + alg1Val + "; time: " + (end - start));

            start = System.currentTimeMillis();
            int alg2Val = alg2UsingNestedLoopOnly(input);
            end = System.currentTimeMillis();
            System.out.println("Alg2: val: " + alg2Val + "; time: " + (end - start));

            start = System.currentTimeMillis();
            int alg3Val = alg3UsingOneLoop(input);
            end = System.currentTimeMillis();
            System.out.println("Alg3: val: " + alg3Val + "; time: " + (end - start));

            start = System.currentTimeMillis();
            int alg4Val = alg4UsingStream(input);
            end = System.currentTimeMillis();
            System.out.println("Alg4: val: " + alg4Val + "; time: " + (end - start));
        }
    }
}