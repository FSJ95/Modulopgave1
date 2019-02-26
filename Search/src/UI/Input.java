package UI;

import java.util.*;

public class Input {

    private static Scanner sc = new Scanner(System.in);


    public static int getIntFromConsole(){

        while (true) {
            System.out.print("> ");
            sc.nextLine();
            if (sc.hasNextInt()) {
                break;
            } else {
                System.out.println("Please enter an integer.");
            }

        }
        return sc.nextInt();
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
