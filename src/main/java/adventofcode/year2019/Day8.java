package adventofcode.year2019;


import adventofcode.utils.FileHandler;

import java.util.List;

public class Day8 {

    final int X_LENGTH = 6;
    final int Y_LENGTH = 25;
    final int IMAGE_SIZE = X_LENGTH * Y_LENGTH;
    int inputLength = 0;
    int Z_LENGTH = 0;
    int[][][] image;

    public void solveDay8Part1() {
        List<String> inputList = readFileIntoList();
        String input = inputList.get(0);
        inputLength = input.length();
        Z_LENGTH = inputLength / IMAGE_SIZE;
        image = new int[inputLength / IMAGE_SIZE][X_LENGTH][Y_LENGTH];

        int i = 0;
        for (int z = 0; z < inputLength / IMAGE_SIZE; z++) {
            for (int x = 0; x < X_LENGTH; x++) {
                for (int y = 0; y < Y_LENGTH; y++) {
                    if (i + 1 < inputLength) {
                        image[z][x][y] = Integer.parseInt(input.substring(i, i + 1));
                    }
                    i++;
                }
            }
        }

        printImage(image);
        System.out.println(findLowestAmountOfZeros(image));
        System.out.println(calculateLayer(findLowestAmountOfZeros(image)));

        printDecodedImage(decodeImage(image));

    }


    private int[][] decodeImage(int[][][] image) {
        int[][] decodedImage = new int[X_LENGTH][Y_LENGTH];
        for (int x = 0; x < X_LENGTH; x++) {
            for (int y = 0; y < Y_LENGTH; y++) {
                for (int z = 0; z < Z_LENGTH; z++) {
                    if (image[z][x][y] < 2) {
                        decodedImage[x][y] = image[z][x][y];
                        break;
                    }
                }
                System.out.println("");
            }
        }
        return decodedImage;
    }

    private void printDecodedImage(int[][] decodedImage) {
        for (int x = 0; x < X_LENGTH; x++) {
            for (int y = 0; y < Y_LENGTH; y++) {
                System.out.print(decodedImage[x][y] + " ");
            }
            System.out.println("");
        }
    }

    private void printImage(int[][][] image) {
        for (int z = 0; z < Z_LENGTH; z++) {
            System.out.println("Layer: " + z);
            for (int x = 0; x < X_LENGTH; x++) {
                for (int y = 0; y < Y_LENGTH; y++) {
                    System.out.print(image[z][x][y]);
                }
                System.out.println("");
            }
        }
    }


    private int findLowestAmountOfZeros(int[][][] image) {
        int lowestAmountZeros = Integer.MAX_VALUE;
        int layerIdWithLowestAmountZeros = 0;
        for (int z = 0; z < Z_LENGTH; z++) {
            int amountZeros = 0;
            for (int x = 0; x < X_LENGTH; x++) {
                for (int y = 0; y < Y_LENGTH; y++) {
                    if (image[z][x][y] == 0) {
                        amountZeros++;
                    }
                }
            }
            if (amountZeros < lowestAmountZeros) {
                layerIdWithLowestAmountZeros = z;
                lowestAmountZeros = amountZeros;
            }
        }
        return layerIdWithLowestAmountZeros;
    }

    private int calculateLayer(int layerId) {
        int numberOf1Digits = 0;
        int numberOf2Digits = 0;

        for (int x = 0; x < X_LENGTH; x++) {
            for (int y = 0; y < Y_LENGTH; y++) {
                if (image[layerId][x][y] == 1) {
                    numberOf1Digits++;
                } else if (image[layerId][x][y] == 2) {
                    numberOf2Digits++;
                }
            }
        }
        return numberOf1Digits * numberOf2Digits;

    }

    public List<String> readFileIntoList() {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2019/day8.txt").getFile());
    }
}
