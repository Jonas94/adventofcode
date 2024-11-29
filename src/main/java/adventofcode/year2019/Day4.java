package adventofcode.year2019;

import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public int solveDay4Part1() {
        int startNumber = 284639;
        int endNumber = 748759;

        //startNumber = 112234;
      //  endNumber = 112234;


        List<Integer> validPasswords = new ArrayList<>();
        for (int i = startNumber; i <= endNumber; i++) {
            if (isValidPassword(i)) {
                System.out.println(i);
                validPasswords.add(i);
            }
        }
        return validPasswords.size();
    }

    public boolean isValidPassword(int password) {
        String passwordString = String.valueOf(password);


        return isPassWord6Digits(passwordString) && isAdjacentsEqual(passwordString) && isNotDecreasing(passwordString);
    }

    public boolean isPassWord6Digits(String passwordString) {

        return passwordString.length() == 6;
    }

    public boolean isAdjacentsEqual(String passwordString) {
        for (int i = 0; i < passwordString.length(); i++) {
            int count = 0;

            while (i < (passwordString.length() - 1) && passwordString.charAt(i) == passwordString.charAt(i + 1)) {
                count++;
                i++;
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                if (i < 2 || passwordString.charAt(i) != passwordString.charAt(i - 2)) {
                    return true;
                }
            }
        }
        return false;
    }

        public boolean isNotDecreasing (String passwordString){
            for (int i = 0; i < passwordString.length() - 1; i++) {
                if (!(Integer.parseInt(String.valueOf(passwordString.charAt(i))) <= Integer.parseInt(String.valueOf(passwordString.charAt(i + 1))))) {
                    return false;
                }
            }
            return true;
        }
    }
