package adventofcode.year2019;


import adventofcode.utils.FileHandler;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Day5 {
    final static String INPUT = "5";
       static int[] operations = {3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
               1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
               999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99};

    Queue<Boolean> operationModeIsImmediate = new ArrayBlockingQueue<>(10);


    public int solveDay5Part1(){
        operations = readFileIntoStringArray();
        int i = 0;
        while(i<operations.length){
            if (operations[i] == 99){
//                System.out.println("Breaking due to 99");
                break;
            }
            int interpretedOperation = interpretOperation(operations[i]);
            int parameter1 = 0;
            int parameter2 = 0;
            int parameter3 = 0;


            if(!operationModeIsImmediate.isEmpty() && operationModeIsImmediate.poll()){
                parameter1 = i + 1;
            }
            else{
                parameter1 = operations[i+1];
            }
                if (!operationModeIsImmediate.isEmpty() && operationModeIsImmediate.poll()) {
                    parameter2 = i + 2;
                } else {
                    parameter2 = operations[i + 2];
                }
                if(i+3<operations.length) {
                    parameter3 = operations[i + 3];
                }
                operationModeIsImmediate.clear();


       //     System.out.println(operations[i]);
            switch (interpretedOperation) {
                case 1:
                    operations[parameter3] = operations[parameter1] + operations[parameter2];
                    i = i+4;
                    break;
                case 2:
                    operations[parameter3] = operations[parameter1] * operations[parameter2];
                    i = i+4;
                    break;
                case 3:
               //     System.out.print("Input: ");
                   // Scanner in = new Scanner(System.in);
                    //String s = in.nextLine();
                    operations[parameter1] = Integer.parseInt(INPUT);
                    i = i + 2;
                    break;
                case 4:
                    System.out.println(operations[parameter1]);
                    i = i + 2;
                    break;
                case 5:
                    if(operations[parameter1] != 0){
                        i = operations[parameter2];
                    }
                    else{
                        i+=3;
                    }
                    break;
                case 6:
                    if(operations[parameter1] == 0){
                        i = operations[parameter2];
                    }
                    else{
                        i+=3;
                    }
                    break;
                case 7:
                    if(operations[parameter1] < operations[parameter2]){
                        operations[parameter3] = 1;
                    }
                    else
                    {
                        operations[parameter3] = 0;
                    }
                    i+=4;
                    break;
                case 8:
                    if(operations[parameter1] == operations[parameter2]){
                        operations[parameter3] = 1;
                    }
                    else
                    {
                        operations[parameter3] = 0;
                    }
                    i+=4;
                    break;
                case 99:
                    break;
                default:
                    i++;
                    System.out.println(interpretedOperation);
                    break;
            }
        }
        return operations[0];
    }

    private int interpretOperation(int operation) {

        String operationString = String.valueOf(operation);
        int interpretedOperation = 0;
        if(operationString.length()> 2) {
             interpretedOperation = Integer.parseInt(operationString.substring(operationString.length() - 2));
        }
        else{
            interpretedOperation = operation;
        }
        for(int i = operationString.length()-3; i>= 0; i--){
            operationModeIsImmediate.add(String.valueOf(operationString.charAt(i)).equals("1"));
        }

        return interpretedOperation;
    }

    public int[] readFileIntoStringArray(){
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readCommaSeparatedFile(getClass().getClassLoader().getResource("adventofcode/year2019/day5.txt").getFile());
    }

    public void printResult(){
        for(int i : operations){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

