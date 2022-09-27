import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.System.out;

public class BruteForce {

    // method to do arithmetic operation
    private static int doThisOperationOn(String operator, int number1, int number2) throws Exception{

        switch(operator){
            case "+":{
                number1 += number2;     // Adding two numbers
                break;
            } case "-":{
                number1 -= number2;     // subtracting two numbers
                break;
            } case "*":{
                if(number1 == 0) {
                    throw new Exception("err");
                }
                else if(number2 == 0) {
                    throw new Exception("err");
                }
                number1 *= number2;     // multiplying two numbers
                break;
            } case "/":{
                if(number1 == 0) {
                    throw new Exception("err");
                }else if((double)number1/number2 % 1 != 0)
                    throw new Exception("err");
                number1 /= number2;    // Dividing two numbers
                break;
            } case "Join":{
                number1 = Integer.parseInt(number2 + "" + number1); // joining two numbers
                break;
            }
        }
        return number1;
    }


    // method to normal operation
    private static String tryThisWithNormalOperations(int[] numbers, int target){
        String [] operators = {"+", "-", "*", "/"};
        int result = 0;
        String resultantEquation="";
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    try {
                        result = doThisOperationOn(operators[k], doThisOperationOn(operators[j], doThisOperationOn(operators[i], numbers[0], numbers[1]), numbers[2]), numbers[3]);
                        if (result == target) {
                            resultantEquation = "((" + numbers[0] + operators[i] + numbers[1] + ")" +  operators[j] + numbers[2] + ")" + operators[k] + numbers[3] + "=" + target;
                            out.println(resultantEquation);
                            System.exit(1);
                        }
                    }catch (Exception ignored){}
                }
            }
        }
        return resultantEquation;
    }


    // method to try different number combinations
    private static void tryDifferentNumberCombinations(int[] numbers, int target){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for (int k=0; k<4; k++){
                    int l=0;
                    while(l<4){
                        if(i != j && i != k && i != l && j != k && j!= l && k != l)
                            tryThisWithNormalOperations(new int[]{numbers[i], numbers[j], numbers[k], numbers[l]}, target);
                        l++;
                    }
                }
            }
        }
    }


    // method to single join and do operations
    private static void singleJoinAndDo(int[] numbers, int target){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for (int k=0; k<4; k++){
                    int l=0;
                    while(l<4){
                        if(i != j && i != k && i != l && j != k && j!= l && k != l)
                            try {
                                tryDifferentNumberCombinations(new int[]{doThisOperationOn("Join", numbers[i], numbers[j]), numbers[k], numbers[l], 0}, target);
                            }catch (Exception ignored){}
                        l++;
                    }
                }
            }
        }
    }

    // method to double join and do operations
    private static void doubleJoinAndDo(int[] numbers, int target){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for (int k=0; k<4; k++){
                    int l=0;
                    while(l<4){
                        if(i != j && i != k && i != l && j != k && j!= l && k != l)
                            try{
                                tryDifferentNumberCombinations(new int[]{ doThisOperationOn("Join", doThisOperationOn( "Join",  numbers[i], numbers[j]), numbers[k]), numbers[l], 0, 0}, target);
                            }catch (Exception ignored){}
                        l++;
                    }
                }
            }
        }
    }

    // method to triple join and do operations
    private static void tripleJoinAndDo(int[] numbers, int target){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for (int k=0; k<4; k++){
                    int l=0;
                    while(l<4){
                        if(i != j && i != k && i != l && j != k && j!= l && k != l)
                            try {
                                tryDifferentNumberCombinations(new int[]{doThisOperationOn("Join", doThisOperationOn("Join", doThisOperationOn("Join", numbers[i], numbers[j]), numbers[k]), numbers[l]), 0, 0, 0}, target);
                            }catch (Exception ignored){}
                        l++;
                    }
                }
            }
        }
    }

    // method to find all the possible combination to get the target number
    public static void startBruteForceFor(int[] numbers, int target){
        tryThisWithNormalOperations(numbers, target);
        singleJoinAndDo(numbers, target);
        doubleJoinAndDo(numbers, target);
    }
}
