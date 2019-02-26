package UI;

import Session.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.*;


public class Menu {

    private boolean quit = false;
    Config cfg = new Config();


    public void mainMenu(){


        while (!quit){


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
            else if(choice==5){

                dbSearch();
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
    private void dbSearch(){

        try{

            Connection sqlCon = cfg.getConnection();
            Statement stmt = sqlCon.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Aar.aarstal, Flytning.antal, til.kommune_navn AS tilKommune, fra.kommune_navn AS fraKommune, Kon.kon_type, Alder.aldersgruppe FROM Flytning INNER JOIN Kommune AS til ON Flytning.kommune_til_id = til.kommune_id INNER JOIN Kommune AS fra ON Flytning.kommune_fra_id = fra.kommune_id INNER JOIN Kon ON Flytning.kon_id = Kon.kon_id INNER JOIN Alder ON Flytning.aldersgruppe_id = Alder.aldersgruppe_id INNER JOIN Aar ON Flytning.aarstal_id = Aar.aarstal_id LIMIT 100");
            while (rs.next()){
                System.out.println("---------------------------------------------");

                System.out.println("Antal: " + rs.getInt("antal")+
                        " År: "+rs.getInt("aarstal")+
                        " fra Kommune: "+rs.getString("fraKommune")+
                        " til Kommune: "+rs.getString("tilKommune")+
                        " Køn: "+rs.getString("kon_type")+
                        " Aldersgruppe: "+rs.getString("aldersgruppe")
                        );

                //System.out.println("Antal" + rs.getInt("antal"));
                System.out.println("---------------------------------------------");
            }
        }
        catch (SQLException e){
            e.getMessage();
        }


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
