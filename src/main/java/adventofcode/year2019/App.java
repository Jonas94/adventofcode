package adventofcode.year2019;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //      Day1 day1 = new Day1();
        //      System.out.println(day1.solveDay1Part1());
        //     System.out.println(day1.solveDay1Part2());

        //  Day2 day2 = new Day2();
        // System.out.println(day2.solveDay2Part1());
        // System.out.println(day2.solveDay2Part2());

        //     Day3 day3 = new Day3();
        //     System.out.println(day3.solveDay3Part1());

        //       Day4 day4 = new Day4();
        //     System.out.println(day4.solveDay4Part1());

        //  Day5 day5 = new Day5();
        //    day5.solveDay5Part1();
        //   day5.printResult();
        //   Day6 day6 = new Day6();
        //   day6.solveDay6();
     /*   Day7 ampA = null;
        Day7 ampB = null;
        Day7 ampC = null;
        Day7 ampD = null;
        Day7 ampE = null;

        ampA = new Day7();
        ampB = new Day7();
        ampC = new Day7();
        ampD = new Day7();
        ampE = new Day7();

        ampA = new Day7();
        ampA.solveDay7(0, 0);
        ampB = new Day7();
        ampB.solveDay7(ampA.getOutput(), 1);
        ampC = new Day7();
        ampC.solveDay7(ampB.getOutput(), 2);
        ampD = new Day7();
        ampD.solveDay7(ampC.getOutput(), 3);
        ampE = new Day7();
        ampE.solveDay7(ampD.getOutput(), 4);
        System.out.println(ampE.getOutput());

        int highestValue = Integer.MIN_VALUE;
        String part2 = "56789";

        ampA = new Day7();
        ampB = new Day7();
        ampC = new Day7();
        ampD = new Day7();
        ampE = new Day7();
        int inputA = 0;

        ArrayList<String> permutations = new ArrayList<>();
        permutations("", part2, permutations);

        int[] permutationValues = new int[5];
        for (String permutation : permutations) {
            permutationValues[0] = Integer.parseInt(permutation.substring(0, 1));
            permutationValues[1] = Integer.parseInt(permutation.substring(1, 2));
            permutationValues[2] = Integer.parseInt(permutation.substring(2, 3));
            permutationValues[3] = Integer.parseInt(permutation.substring(3, 4));
            permutationValues[4] = Integer.parseInt(permutation.substring(4));
            ampA = new Day7();
            ampB = new Day7();
            ampC = new Day7();
            ampD = new Day7();
            ampE = new Day7();
            inputA = 0;

            int i = 0;
            while (i < 10) { //Brute force!
                ampA.solveDay7(inputA, permutationValues[0]);
                ampB.solveDay7(ampA.getOutput(), permutationValues[1]);
                ampC.solveDay7(ampB.getOutput(), permutationValues[2]);
                ampD.solveDay7(ampC.getOutput(), permutationValues[3]);
                ampE.solveDay7(ampD.getOutput(), permutationValues[4]);
                //     System.out.println(a + " " + b + " " + c + " " + d + " " + e);
                System.out.println(ampE.getOutput());
                if (ampE.getOutput() > highestValue) {
                    highestValue = ampE.getOutput();
                }

                inputA = ampE.getOutput();
                System.out.println(highestValue);

                for (Integer ampValue : permutationValues) {
                    System.out.print(ampValue + " ");
                }
                i++;
            }

        }
    }

    private static boolean isInputsUnique(int[] inputs) {
        return Arrays.stream(inputs).distinct().toArray().length == 5;
    }

    private static void permutations(String prefix, String s, List<String> list) {
        int n = s.length();
        if (n == 1) {
            list.add(prefix + s);
        } else {
            for (int i = 0; i < n; i++)
                permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), list);
        }
    }
}*/

        Day8 day8 = new Day8();

        day8.solveDay8Part1();


    }
}
