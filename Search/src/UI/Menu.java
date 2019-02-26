package UI;

import Session.Config;

import java.util.*;


public class Menu {

    private boolean quit = false;
    Config cfg = new Config();


    public void mainMenu(){


        while (!quit){

            clearScreen();
            showMenu();

            int choice = Input.getIntFromConsole();

            if(choice==0){
                quit = true;
            }

            else if(choice==1){
                clearScreen();
                chooseLimit();
            }

            else if(choice==2){
                clearScreen();
                chooseYear();
            }

            else if(choice==9){
                clearScreen();
                showSettings();
                Input.pressToContinue();
            }
        }
    }

    private void showMenu() {
        System.out.println(
                        "\n   Search tool   \n" +
                        "-------------------\n" +
                        "1. Number of rows \n" +
                        "3. Year \n" +
                        "4. Gender  \n" +
                        "-------------------\n" +
                        ". Complete search\n" +
                        "9. Show settings\n" +
                        "-------------------\n" +
                        "0. Exit program \n");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void chooseLimit(){
        System.out.println("How many rows do you want?");
        cfg.setRows(Input.getIntFromConsole());
    }
    public void chooseYear(){
        System.out.println("Vælg Årstal");
        cfg.setYear(Input.getIntFromConsole());
    }

    private void showSettings() {
        System.out.println(
                        "\n     Settings   \n" +
                        "-------------------");

        // List of settings here
        System.out.println("Number of results:\t" + cfg.getRows() + " (0 = ALL)");
        System.out.println("Year:\t\t\t" + cfg.getYear());

        System.out.println(
                        "-------------------");


    }



}
