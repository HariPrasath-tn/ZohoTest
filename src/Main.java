/*
 *  Application to prepare a bot to crack the Fourte app(math game app) developed by zoho
 *
 *   ==> Approach applied here uses the algorithm of brute force
 */

import input.GetUserInput.*;

import java.io.IOException;
import java.util.Arrays;
import static input.GetUserInput.getNumber;
import static input.GetUserInput.getNumberArrayFromUser;
import static java.lang.System.out;

public class Main {


    // App initializer
    public void init(){
        try{
            // user manual display
            out.println("Tool to crack the Fourte app provided by zoho");
            out.println("You will be asked for the numbers to solve the Q");
            out.println("Firstly target number followed by option numbers");

            // initializing containers for the required numbers such as target and option numbers
            int targetNumber = getNumber("Enter the target number : ");
            int [] numbers = getNumberArrayFromUser(4);

            // printing the resultant equation
            out.print("Solution equation for this numbers to attain the the number " + targetNumber + " with the numbers " + Arrays.toString(numbers) + " is ");

            // bruteforce is applied to find the resultant equation by applying all the possibilities
            BruteForce.startBruteForceFor(numbers, targetNumber);
        }
        catch(IOException e){
            // block will execute when the user gives input other than numbers
            out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        Main app = new Main();
        app.init();
    }
}

