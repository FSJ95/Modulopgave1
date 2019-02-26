package UI;

import java.util.*;

public class Input {

    private static Scanner sc = new Scanner(System.in);


    public static int getIntFromConsole(){

        int choice;

        while (true) {

            System.out.print("> ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                break;
            } catch(NumberFormatException e) {

                System.out.println("\nPlease type a number.");

            }
        }
        return choice;
    }

    public static int getIntRangeFromConsole(int x, int y){

        int choice;

        while (true) {

            System.out.print("> ");

            try {
                int userInput = Integer.parseInt(sc.nextLine());

                if (userInput >= x && userInput <= y)
                {
                    choice = userInput;
                    break;
                }

                System.out.println("\nPlease type a number between " + x + " and " + y + ".");

            } catch(NumberFormatException e) {

                System.out.println("\nPlease type a number between " + x + " and " + y + ".");

            }

        }

        return choice;
    }

    public static void pressToContinue()
    {
        System.out.println("Press ENTER to continue...");
        try{
            System.in.read();
        }catch(Exception e){
            e.printStackTrace();
        }
    }








}
