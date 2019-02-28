package UI;

import Query.Selection;
import Session.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class Menu {

    private boolean quit = false;
    Config cfg = new Config();
    Selection select = new Selection();


    public void mainMenu() {

        while (!quit) {

            if (cfg.getChosenMenu() == 1) {
                clearScreen();
                showToFromMenu();


                switch (Input.getIntRangeFromConsole(0, 9)) {
                    case 1:
                        // CHANGE MENU
                        changeMenu();
                        break;
                    case 2:
                        // CHANGE LIMIT
                        clearScreen();
                        chooseLimit();
                        break;
                    case 3:
                        // CHANGE YEAR
                        clearScreen();
                        chooseYear();
                        break;
                    case 4:
                        // CHANGE GENDER
                        clearScreen();
                        chooseGender();
                        break;
                    case 5:
                        // CHOSE AGE GROUP
                        clearScreen();
                        chooseAgeBracket();
                        break;
                    case 6:
                        // CHOSE FROM - CITY
                        clearScreen();
                        chooseFromCity();
                        break;
                    case 7:
                        // CHOSE TO - CITY
                        clearScreen();
                        chooseToCity();
                        break;
                    case 8:
                        // SHOW TABLES FROM SETTINGS
                        clearScreen();
                        showTables();
                        Input.pressToContinue();
                        break;
                    case 9:
                        // SHOW ALL SETTINGS
                        clearScreen();
                        showSettings();
                        Input.pressToContinue();
                        break;
                    case 0:
                        // QUIT PROGRAM
                        quit = true;


                }

            } else if (cfg.getChosenMenu() == 2) {
                clearScreen();
                showMovementMenu();

                switch (Input.getIntRangeFromConsole(0, 9)) {
                    case 1:
                        // CHANGE MENU
                        changeMenu();
                        break;
                    case 2:
                        // CHANGE LIMIT
                        clearScreen();
                        chooseLimit();
                        break;
                    case 3:
                        // CHANGE YEAR
                        clearScreen();
                        chooseYear();
                        break;
                    case 4:
                        // CHANGE GENDER
                        clearScreen();
                        chooseGender();
                        break;
                    case 5:
                        // CITY
                        clearScreen();
                        chooseCity();
                        break;
                    case 6:
                        // MOVEMENT TYPE
                        clearScreen();
                        chooseMovementType();
                        break;
                    case 8:
                        // SHOW TABLES FROM SETTINGS
                        clearScreen();
                        showTables();
                        Input.pressToContinue();
                        break;
                    case 9:
                        // SHOW ALL SETTINGS
                        clearScreen();
                        showSettings();
                        Input.pressToContinue();
                        break;
                    case 0:
                        // QUIT PROGRAM
                        quit = true;
                }


            }
        }
    }


    private void showToFromMenu() {
        System.out.println(
                        "\nSEARCH TOOL (TO/FROM CITYS)\n" +
                        "-------------------\n" +
                        "1. Change menu \n" +
                        "-------------------\n" +
                        "2. Number of results. \n" +
                        "3. Year. \n" +
                        "4. Gender.  \n" +
                        "5. Age group.  \n" +
                        "6. City moving from.  \n" +
                        "7. City moving to.  \n" +
                        "-------------------\n" +
                        "8. Show results.\n" +
                        "9. Show settings.\n" +
                        "-------------------\n" +
                        "0. Exit program. \n");
    }


    private void showMovementMenu() {
        System.out.println(
                        "\nSEARCH TOOL (MOVEMENT TYPE)\n" +
                        "-------------------\n" +
                        "1. Change menu \n" +
                        "-------------------\n" +
                        "2. Number of results. \n" +
                        "3. Year. \n" +
                        "4. Gender.  \n" +
                        "5. City.  \n" +
                        "6. Movement type.  \n" +
                        "-------------------\n" +
                        "8. Show results.\n" +
                        "9. Show settings.\n" +
                        "-------------------\n" +
                        "0. Exit program. \n");
    }

    public void changeMenu(){
        if (cfg.getChosenMenu()==1){
            cfg.setChosenMenu(2);
        } else {
            cfg.setChosenMenu(1);
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void chooseLimit(){
        System.out.println("How many rows do you want?");
        System.out.println("(0 for no limit)");
        cfg.setRows(Input.getIntFromConsole());
    }
    public void chooseYear(){
        System.out.println("What year do you want?");
        System.out.println("(0) = All of them");
        System.out.println(select.settingOptions("Aar", cfg.getConnection()));
        cfg.setYear(Input.getIntRangeFromConsole(0, 12));
    }

    public void chooseGender(){
        System.out.println("What gender do you want?");
        System.out.println("(0) = All of them");
        System.out.println(select.settingOptions("Kon", cfg.getConnection()));
        cfg.setGender(Input.getIntRangeFromConsole(0, 2));
    }

    public void chooseCity(){
        System.out.println("What city do you want?");
        System.out.println("(0) = All of them");
        System.out.println(select.settingOptions("Kommune", cfg.getConnection()));
        cfg.setMovementCity(Input.getIntRangeFromConsole(0, 99));
    }

    public void chooseFromCity(){
        System.out.println("What city do you want?");
        System.out.println("(0) = All of them");
        System.out.println(select.settingOptions("Kommune", cfg.getConnection()));
        cfg.setFromCity(Input.getIntRangeFromConsole(0, 99));
    }

    public void chooseToCity(){
        System.out.println("What city do you want?");
        System.out.println("(0) = All of them");;
        System.out.println(select.settingOptions("Kommune", cfg.getConnection()));
        cfg.setToCity(Input.getIntRangeFromConsole(0, 99));
    }



    public void chooseMovementType(){
        System.out.println("What movement type do you want?");
        System.out.println("(0) = All of them");
        System.out.println(select.settingOptions("Bevaegelse", cfg.getConnection()));
        cfg.setMovementType(Input.getIntRangeFromConsole(0, 99));
    }

    public void chooseAgeBracket(){
        System.out.println("What age group do you want?");
        System.out.println("(0) = All of them");
        System.out.println(select.settingOptions("Alder", cfg.getConnection()));
        cfg.setAgeBracket(Input.getIntRangeFromConsole(0, 99));
    }

    // Print for showing current settings.
    private void showSettings() {
        System.out.println(
                        "\n     Settings   \n" +
                        "-------------------");

        // List of settings here.
        System.out.println("Number of results:\t" + cfg.getRows() + " (0 = ALL)");
        System.out.println("Year:\t\t\t" + select.settingValues("aarstal","aarstal_id","Aar", cfg.getYear(), cfg.getConnection()));
        System.out.println("Gender:\t\t\t" + select.settingValues("kon_type", "kon_id", "Kon", cfg.getGender(), cfg.getConnection()));

        // Show different setting depending on what menu were in.
        if (cfg.getChosenMenu() == 1) {
            System.out.println("Age bracket:\t\t" + select.settingValues("aldersgruppe","aldersgruppe_id","Alder", cfg.getAgeBracket(), cfg.getConnection()));
            System.out.println("City (FROM):\t\t" + select.settingValues("kommune_navn","kommune_id","Kommune", cfg.getFromCity(), cfg.getConnection()));
            System.out.println("City (TO):\t\t" + select.settingValues("kommune_navn","kommune_id","Kommune", cfg.getToCity(), cfg.getConnection()));

        } else {
            System.out.println("City:\t\t\t" + select.settingValues("kommune_navn","kommune_id","Kommune", cfg.getMovementCity(), cfg.getConnection()));
            System.out.println("Movement type:\t\t" + select.settingValues("bevaegelse_typer","bevaegelse_id","Bevaegelse", cfg.getMovementType(), cfg.getConnection()));
        }

        System.out.println(
                        "-------------------");

    }

    public void showTables(){
        if (cfg.getChosenMenu()==1){
            System.out.println(select.toFromResults(cfg));
        } else if (cfg.getChosenMenu() == 2) {
            System.out.println(select.movementResults(cfg));
        }
    }


}
