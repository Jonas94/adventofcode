package adventofcode.year2015
        ;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

    /*
Santa needs help figuring out which strings in his text file are naughty or nice.

A nice string is one with all of the following properties:

It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
For example:

ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
jchzalrnumimnmhp is naughty because it has no double letter.
haegwjzuvuyypxyu is naughty because it contains the string xy.
dvszwmarrgswjxmb is naughty because it contains only one vowel.
How many strings are nice?


     */
    private List<String> forbiddenSequences = List.of("ab", "cd", "pq", "xy");

    private List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    public long part1() {
        List<String> strings = FileHandler.readFileIntoList("adventofcode/year2015/day5.txt");

        long countOfNiceStrings = 0;
        long countOfFails = 0;
        for (String s : strings) {

            if (isNicePart1(s)) {
                countOfNiceStrings++;
            } else {
                countOfFails++;
                // System.out.println("String is naughty:" + s);
            }
        }

        System.out.println(countOfFails);
        return countOfNiceStrings;
    }

    public long part2() {
        List<String> strings = FileHandler.readFileIntoList("adventofcode/year2015/day5.txt");

        long countOfNiceStrings = 0;
        long countOfFails = 0;
        for (String s : strings) {

            if (isNicePart2(s)) {
                countOfNiceStrings++;
            } else {
                countOfFails++;
                // System.out.println("String is naughty:" + s);
            }
        }

        System.out.println(countOfFails);
        return countOfNiceStrings;
    }

    public boolean isNicePart1(String s) {


        return containsThreeVowels(s) && containsLetterTwiceInRow(s) && !containsForbiddenSequence(s);
    }

    public boolean isNicePart2(String s) {
        return containsPairTwice(s) && containsRepeatingCharWithOtherCharBetween(s);
    }

    public boolean containsPairTwice(String s) {

        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i = i + 1) {
            String newPair = s.substring(i, i + 2);

            if (pairs.isEmpty()) {
                pairs.add(newPair);
            } else if (!newPair.equals(pairs.getLast())) {
                pairs.add(newPair);
            }


        }


        return containsMultiplePairs(pairs);
    }

    private boolean containsMultiplePairs(List<String> pairs) {

        for (String pair : pairs) {
            long count = pairs.stream().filter(currentPair -> currentPair.equals(pair)).count();

            if (count > 1) {
                return true;
            }
        }
           System.out.println("String does not contain multiple pairs: " + pairs);

        return false;
    }

    public boolean containsRepeatingCharWithOtherCharBetween(String s) {


        for (int i = 0; i < s.length() - 2; i++) {

            if (i > s.length() - 2) {
                continue;
            }

            if (s.charAt(i) == s.charAt(i + 2)) {
                return true;
            }


        }

      //  System.out.println("String does not have repeating char with another char inbetween (same char is alright): " + s);
        return false;
    }


    private boolean containsThreeVowels(String s) {
        long numberOfVowels = 0;

        for (Character vowel : vowels) {
            long countOfMatches = s.chars().filter(ch -> ch == vowel).count();
            numberOfVowels = numberOfVowels + countOfMatches;
            if (numberOfVowels >= 3) {
                return true;
            }
        }
        System.out.println("String does not contain three vowels: " + s);

        return false;
    }


    private boolean containsLetterTwiceInRow(String s) {
        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        System.out.println("String does not contain same letter twice in row: " + s);

        return false;
    }

    //zwqadogmpjmmxijf
    private boolean containsForbiddenSequence(String s) {
        for (String forbidden : forbiddenSequences) {
            if (s.contains(forbidden)) {
                System.out.println("String contains forbidden sequence row: " + forbidden + " : " + s);

                return true;
            }
        }

        return false;
    }
}
