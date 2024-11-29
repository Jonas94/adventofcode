package adventofcode.year2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        List<String> rows = readFileIntoList();
        List<Claim> claims = createClaimsFromString(rows);
        int[][] fabricMatrix = createFabricMatrixWithClaims(claims);
        System.out.println("Number of multiple claimed inches: " + calculateNumberOfMultipleClaims(fabricMatrix));
        System.out.println("Intact claim ID: " + findIntactClaimID(claims, fabricMatrix));
    }

    private static int[][] createFabricMatrixWithClaims(List<Claim> claims) {
        int[][] fabricMatrix = new int[1000][1000];
        for (Claim c : claims) {
            for (int i = c.getInchFromLeft(); i < c.getInchFromLeft() + c.getWidth(); i++) {
                for (int j = c.getInchFromTop(); j < c.getInchFromTop() + c.getHeight(); j++) {
                    fabricMatrix[i][j] = ++fabricMatrix[i][j];
                }
            }
        }
        return fabricMatrix;
    }

    private static int findIntactClaimID(List<Claim> claims, int[][] fabricMatrix) {
        Collections.reverse(claims); //For looping "backwards".
        for (Claim c : claims) {
            boolean claimIntact = true;
            for (int i = c.getInchFromLeft(); i < c.getInchFromLeft() + c.getWidth(); i++) {
                for (int j = c.getInchFromTop(); j < c.getInchFromTop() + c.getHeight(); j++) {
                    if (fabricMatrix[i][j] > 1) {
                        claimIntact = false;
                    }
                }
            }
            if (claimIntact) {
                return c.getId();
            }
        }
        return -1;
    }

    private static List<Claim> createClaimsFromString(List<String> rows) {
        List<Claim> claims = new ArrayList<Claim>();
        for (String s : rows) {
            String[] token = s.split("#| @ |,|: |x");
            Claim c = new Claim(Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3]), Integer.parseInt(token[4]), Integer.parseInt(token[5]));
            claims.add(c);
        }
        return claims;
    }

    private static int calculateNumberOfMultipleClaims(int[][] fabricMatrix) {
        int numberOfClaims = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (fabricMatrix[i][j] > 1) {
                    numberOfClaims++;
                }
            }
        }
        return numberOfClaims;
    }

    private static List<String> readFileIntoList() {
        List<String> rows = new ArrayList<String>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/inputDay3.txt"));
            String line = reader.readLine();
            while (line != null && line.length() > 1) {
                rows.add(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
}