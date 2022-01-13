package GymWakeUp;

import java.util.Scanner; //import av Scanner
public class GymWakeUp {
    private static String[][] spinning = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}}; // här skapas Arrays som har platser som finns för olika aktiviteter
    private static String[][] yoga = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private static String[][] aerobics = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private static String[] personNr = new String[100000]; // Array som ska innehålla personnummer av medlemmar
    private static int counter; // medlems räknare
    public static void main(String[]args){
        selectMenu();

    }
    public static void spinningTable(){
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("---------------");
        System.out.printf ("A | %s | %s | %s |\n", spinning[0][0], spinning[0][1],spinning[0][2]);
        System.out.println("---------------");
        System.out.printf ("B | %s | %s | %s |\n", spinning[1][0], spinning[1][1],spinning[1][2]);
        System.out.println("---------------");
        System.out.printf ("C | %s | %s | %s |\n", spinning[2][0], spinning[2][1],spinning[2][2]);
        System.out.println("---------------");
    }
    public static void yogaTable(){
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("---------------");
        System.out.printf ("A | %s | %s | %s |\n", yoga[0][0], yoga[0][1],yoga[0][2]);
        System.out.println("---------------");
        System.out.printf ("B | %s | %s | %s |\n", yoga[1][0], yoga[1][1],yoga[1][2]);
        System.out.println("---------------");
        System.out.printf ("C | %s | %s | %s |\n", yoga[2][0], yoga[2][1],yoga[2][2]);
        System.out.println("---------------");
    }
    public static void aerobicsTable(){
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("---------------");
        System.out.printf ("A | %s | %s | %s |\n", aerobics[0][0], aerobics[0][1],aerobics[0][2]);
        System.out.println("---------------");
        System.out.printf ("B | %s | %s | %s |\n", aerobics[1][0], aerobics[1][1],aerobics[1][2]);
        System.out.println("---------------");
        System.out.printf ("C | %s | %s | %s |\n", aerobics[2][0], aerobics[2][1],aerobics[2][2]);
        System.out.println("---------------");
    }

    public static boolean kontroll(String personNr){ // den här metoden kontrollerar om personummer är giltigt vid registrering
        int summa = 0;
        int tal;

        if(personNr.length()==10){
            for(int a = 0; a < personNr.length(); a++){
                tal = personNr.charAt(a) - '0';
                if(tal > 0 || tal < 9){
                    if (a % 2 == 0){
                        summa += (tal * 2 > 9) ? (tal * 2) - 9 : tal * 2;
                    } else {
                        summa += tal;
                    }
                }
                else {
                    return false;
                }

            }
            return((summa%10)==0);
        }
        return false;
    }

    public static void selectMenu() { // här ska man få de 4 alternativ som man ska välja

        Scanner select = new Scanner(System.in);

        System.out.print("1.Logga in \n2.Bli medlem \n3.Boka pass \n4.Avsluta\n");
        while(true) {

            int selectMenu = select.nextInt();

            switch(selectMenu) {

                case 1: {
                    loggIn();

                    //loggIn
                    break;
                }
                case 2:{
                    memberShip();
                    counter += 1;
                    break;
                }
                case 3:{
                    loggIn();
                    bokaPass();
                    // Boka pass
                    break;
                }
                case 4:{
                    System.exit(0);
                    //Avsluta
                    break;
                }
                default:{
                    System.out.println("Ogiltligt val. Försök igen"); // om man har skrivit in fel numret då ska programmet begär personen att välja igen
                    selectMenu();
                }

            }

        }
    }
    public static void loggIn() { // metoden för att logga in

        int medlemsnummer;
        Scanner input = new Scanner(System.in); // här skapas scanner som ska användas för att någon ska kunna skriva in sitt personnummer
        System.out.println("Skriv in ditt personnummer"); // begäer personen att skriva in sitt personnummer
        String personnr = input.next(); // här ska man skriva in sitt personnummer
        System.out.println("Vad är ditt medlemsnummer?"); // begär personen att skriva in sitt medlemsnummer
        medlemsnummer = input.nextInt(); // här ska man skriva in sitt medlemsnummer
        if(counter > medlemsnummer) { // kontrollerar om det finns medlemsnumret
        } else { // om man har skrivit fel ska programmet begär personen att försöka igen eller registrera sig
            System.out.println("Det verkar som det inte finns någon med det personumret och medlemanummret. Var vänlig och registrera dig för att fortsätta eller försök igen loggain");
            selectMenu();
        }
        if(personNr[medlemsnummer].equalsIgnoreCase(personnr)){ // om man har skrivit rätt personumret och medlemsnumret då är man inloggad och då kan man boka pass
            System.out.print("Du är inloggad nu.");
            bokaPass();
        }else{ // om man har skrivit fel då ska programmet begär personen att försöka igen
            System.out.println("Det gick något fel. Du har kanske skrivit fel personumret/medlemsnumret. Var vänlig försök igen");
            loggIn();
        }
    }
    public static void memberShip() { // här kan man bli medlem
        Scanner input = new Scanner(System.in);
        System.out.println("Ange ditt personNr (tio siffror)"); // programmet begär personen att skriva in sitt personnummer
        personNr[counter] = input.nextLine(); // här skriver man in sitt personnummer

        if(kontroll(personNr[counter]) == false){ // här görs kontroll av personnumret
            System.out.println("Ditt personnummer är ogiltigt"); // om man har skrivit ett ogiltigt tal då ska programmet säga att det är fel
            memberShip(); // och skicka igen till början av memberShip metoden

        }else{System.out.println("Det här är ditt medlemsnummer " +counter++); // om man har skrivit giltigt personnumer då ska man bli medlem och få ett medlemsnummer

            System.out.print("Hur många månader vill du \nteckna medlemskap?\n"); // här ska man välja hur många månader man vill vara medlem
            int m = input.nextInt();

            if (m <=2) {
                // här väljer man olika alternativ och får pris för de olika alternativen
                int price = 400 * m +100;
                System.out.println("\nFör" + " "+ m + " " + "månader blir totalpriset:" + price + "kr");
                System.out.println("Pris/månad är 450kr");
                System.out.println("Ditt medlemskap är registrerat");
                selectMenu();
            }
            else if (m<=6) {

                int	price = 350 * m + 100;
                System.out.println("\nFör" + " "+ m + " " + "månader blir totalpriset:" + price + "kr");
                System.out.println("Pris/månad är 350kr");
                System.out.println("Ditt medlemskap är registrerat");
                selectMenu();
            }
            else if (m<=12) {

                int price = 300 * m + 100;
                System.out.println("\nFör" + " "+ m + " " + "månader blir totalpriset:" + price + "kr");
                System.out.println("Pris/månad är 300kr");
                System.out.println("Ditt medlemskap är registrerat");
                selectMenu();
            }
            else if (m>12) {

                int price = 250 * m + 100;
                System.out.println("\nFör" + " "+ m + " " + "månader blir totalpriset:" + price + "kr");
                System.out.println("Pris/månad är 250kr");
                System.out.println("Ditt medlemskap är registrerat");
                selectMenu();
            }
        }
    }        // de här kontrollerar om en plats en ledig när man vill boka en plats till de olika aktiviteter
    public static boolean plats(int forstaIndex, int andraIndex){ //den här kontrollerar för spinning
        if((spinning[forstaIndex][andraIndex]).equals(" ")) {

            return true;
        } else {
            return false;
        }
    }
    public static boolean plats1(int forstaIndex, int andraIndex){ //den här kontrollerar för yoga
        if((yoga[forstaIndex][andraIndex]).equals(" ")) {

            return true;
        } else {
            return false;
        }
    }
    public static boolean plats2(int forstaIndex, int andraIndex){ //den här kontrollerar för aerobics
        if((aerobics[forstaIndex][andraIndex]).equals(" ")) {

            return true;
        } else {
            return false;
        }
    }

    public static void bokaPass(){ // här kan man boka platser till de olika aktiviteterna som finns på GymWakeUp
        Scanner input = new Scanner(System.in);

        int forstaIndex = 0;
        int andraIndex = 0;
        boolean placed = false;

        System.out.println("Välj mellan olika aktiviteter: 1.Spninning/2.Yoga/3.Aerobics"); //begär personen att välja mellan olika aktiviteter
        int a = input.nextInt(); // här skriver man in sitt val
        if(a == 1){ // om man väljer spinning
            spinningTable();
            System.out.println("Skriv in vilken plats du vill boka såhär ex: 1A "); // begär personen att skriva in vilken plats man vill boka och säger hur man ska skriva
            String val = "";
            val = input.next(); //man skriver in sitt val

            char[] xy = val.toCharArray(); //kontrollerar om man har skrivit rätt
            if(xy.length != 2 || !((xy[0] == '1' || xy[0] == '2' || xy[0] == '3') && (xy[1] == 'A' || xy[1] == 'B' || xy[1] == 'C'))  ){
                System.out.println("Du ska skriva platsnummer såhär ex: 1A"); // begär personen att skriva igen om man har skrivit fel
            } else {
                forstaIndex = xy[0] - '1';
                andraIndex = xy[1] - 'A';

                placed = plats(forstaIndex, andraIndex); // kontrollerar om plats är ledig
                if(!placed) { // om den inte är ledig
                    System.out.println("Den här platsen är upptagen. Var vänlig och försök igen"); // begär personen att välja igen
                    bokaPass();
                } else {

                    System.out.println("Du har bokat plats: "+val); // om den är ledig bokar man den platsen
                    spinning[forstaIndex][andraIndex] = "X";
                    spinningTable();
                    try{
                        Thread.sleep(2000);
                    } catch (Exception e){
                        System.out.println("Sömn gick inte");
                    }
                    selectMenu();
                }
            }

        } else if(a == 2){ // om man väljer yoga
            yogaTable();
            System.out.println("Skriv in vilken plats du vill boka såhär ex: 1A: "); // begär personen att skriva in vilken plats man vill boka och säger hur man ska skriva
            String val = "";
            val = input.next(); //man skriver in sitt val

            char[] xy = val.toCharArray();  //kontrollerar om man har skrivit rätt

            if(xy.length != 2 || !((xy[0] == '1' || xy[0] == '2' || xy[0] == '3') && (xy[1] == 'A' || xy[1] == 'B' || xy[1] == 'C'))  ){
                System.out.println("Du ska skriva platsnummer såhär ex: 1A"); // begär personen att skriva igen om man har skrivit fel
            } else {
                forstaIndex = xy[0] - '1';
                andraIndex = xy[1] - 'A';

                placed = plats1(forstaIndex, andraIndex); // kontrollerar om plats är ledig
                if(!placed) { // om den inte är ledig

                    System.out.println("Den här platsen är upptagen. Var vänlig och försök igen"); // begär personen att välja igen
                    bokaPass();
                } else {

                    System.out.println("Du har bokat plats: "+val); // om den är ledig bokar man den platsen
                    yoga[forstaIndex][andraIndex] = "X";
                    yogaTable();
                    try{
                        Thread.sleep(2000);
                    } catch (Exception e){
                        System.out.println("Sömn gick inte");
                    }
                    selectMenu();
                }
            }


        }else if(a == 3){ // om man väljer aerobics
            aerobicsTable();
            System.out.println("Skriv in vilken plats du vill boka såhär ex: 1A ");
            String val = "";
            val = input.next(); //man skriver in sitt val

            char[] xy = val.toCharArray(); //kontrollerar om man har skrivit rätt


            if(xy.length != 2 || !((xy[0] == '1' || xy[0] == '2' || xy[0] == '3') && (xy[1] == 'A' || xy[1] == 'B' || xy[1] == 'C'))  ){
                System.out.println("Du ska skriva platsnummer såhär ex: 1A"); // begär personen att skriva igen om man har skrivit fel
            } else {
                forstaIndex = xy[0] - '1';
                andraIndex = xy[1] - 'A';

                placed = plats2(forstaIndex, andraIndex); // kontrollerar om plats är ledig
                if(!placed) { // om den inte är ledig
                    System.out.println("Den här platsen är upptagen. Var vänlig och försök igen"); // begär personen att välja igen
                    bokaPass();
                } else {

                    System.out.println("Du har bokat plats: "+val); // om den är ledig bokar man den platsen
                    aerobics[forstaIndex][andraIndex] = "X";
                    aerobicsTable();
                    try{
                        Thread.sleep(2000);
                    } catch (Exception e){
                        System.out.println("Sömn gick inte");
                    }
                    selectMenu();
                }
            }

        }else{
            System.out.println("Du har inte anget rätt plats! Försök igen!");
            bokaPass();

        }
    }
}