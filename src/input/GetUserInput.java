package input;/*
 * class to get user inputs of required format
 */

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class GetUserInput {
    // initialing console input stream
    private static final Scanner input = new Scanner(System.in);

    // method to get integer from the user
    public static int getNumber(String request) throws InvalidInputException{
        int number;
        out.print(request);
        if(input.hasNextInt())
            number = input.nextInt();
        else
            throw new InvalidInputException("Expecting numbers only");
        return number;
    }


    // method to get integer array from the user
    public static int[] getNumberArrayFromUser(int size) throws InvalidInputException {
        int[] numberArray = new int[size];

        for(int index=0; index<4; index++)
            numberArray[index] = getNumber("Enter number " + (index+1) + " : ");

        return numberArray;
    }
}


/*
 * user defined exception inorder to tell that the input given mismatch the required type
 */
class InvalidInputException extends IOException {
    InvalidInputException(String message){
        super(message);
    }
}