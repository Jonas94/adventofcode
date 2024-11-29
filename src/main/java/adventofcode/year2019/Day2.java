package adventofcode.year2019;

import adventofcode.utils.FileHandler;

public class Day2 {
   static int[] operations;

    public int solveDay2Part1(){
        operations = readFileIntoStringArray();

        for (int i = 0; i < operations.length; i+=4){
            if (operations[i] == 99){
                break;
            }
            doOperation(operations[i], operations[i+1], operations[i+2], operations[i+3]);
        }

    return operations[0];
    }

    public int solveDay2Part2(){

        for(int op1 = 0; op1 < 100; op1++) {
            for(int op2 = 0; op2 < 100; op2++){
            operations = readFileIntoStringArray();
                operations[1] = op1;
                operations[2] = op2;
                for (int i = 0; i < operations.length; i += 4) {
                if (operations[i] == 99) {
                    break;
                }
                doOperation(operations[i], operations[i + 1], operations[i + 2], operations[i + 3]);
            }
            if (operations[0] == 19690720) {
                System.out.println("operation 1: " + operations[1]);
                System.out.println("operation 2: " + operations[2]);
                return 100 * operations[1] + operations[2];

            }
        }
        }
        return -1;
    }

    private void doOperation(int i, int i1, int i2, int i3) {
        if (i == 1){
            operations[i3] =operations[i1] + operations[i2];
        }
        else if(i == 2){
            operations[i3] = operations[i1] * operations[i2];
        }

    }




    public int[] readFileIntoStringArray(){
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readCommaSeparatedFile(getClass().getClassLoader().getResource("adventofcode/year2019/day2.txt").getFile());
    }
}
