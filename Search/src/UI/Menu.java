package UI;

import java.util.*;

public class Menu {
    private boolean quit = false;
    private int rows = 0;
    private String aldersgruppe = "";
    private String table = "Flytning";
    private int årstal = 0;
    private String gender = "";
    private String kommune = "";

    public void mainMenu(){
        while (!quit){
            int choice = Input.getIntFromConsole("0. Quit\n1. Vælg antal rækker\n2. Årstal\n \n \n \n \n9. Se valg");
            if(choice==0){
                quit = true;
            }
            else if(choice==1){
                chooseLimit();
            }
            else if(choice==2){
                chooseYear();
            }
            else if(choice==9){
                printSettings();
            }
        }
    }
    public void chooseLimit(){
        this.rows = Input.getIntFromConsole("Vælg antal rækker");
    }
    public void chooseYear(){
        this.årstal = Input.getIntFromConsole("Vælg Årstal");
    }
    public void printSettings(){
        System.out.println("Indstillinger, 0 = alle/ingen begræsning: \n");
        System.out.println("Max antal resultater: "+this.rows);
        System.out.println("Årstal: "+this.årstal);
    }
    public void chooseGender(){

    }


}
