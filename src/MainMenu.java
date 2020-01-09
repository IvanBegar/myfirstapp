import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private static List<Brigade> brigades = new ArrayList<>();
    ServiceCompany serviceCompany = new ServiceCompany(brigades);
    boolean exit;

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.runMain();
    }

        public void runMain() {
        printHeadOfMenu();
        while (!exit) {
            printAvailableCommands();
            String command = getCommandFromUser();
            performCommand(command);
        }
    }

        private void printHeadOfMenu() {
        System.out.println("+---------------------------+");
        System.out.println("|   Welcome to our program  |");
        System.out.println("+---------------------------+");
    }

        private void printAvailableCommands () {
        System.out.println("\nAvailable command's: ");
        System.out.println("1. 'List' - Show's list of brigade's");
        System.out.println("2. 'Add' - Add a new brigade to the list");
        System.out.println("3. 'Remove' - Remove brigade from the list");
        System.out.println("4. 'Exit' - Close the program");
    }

        public void performCommand(String command){
            switch (command) {
                case "List":
                    if (brigades.isEmpty()) {
                        System.out.println("\nNo brigades exists.");
                    }
                    for (Brigade br : brigades) {
                        System.out.println(br.toString());
                    }
                    break;
                case "Add":
                    Brigade newBrigade = brigadeCreation();
                    brigades.add(newBrigade);
                    System.out.println("You returned to main menu.");
                    break;
                case "Remove":
                    if (brigades.isEmpty()) {
                    System.out.println("\nNo brigades exists.");
                } else {
                        int i = 1;
                        for (Iterator<Brigade> it = brigades.iterator(); it.hasNext(); i++) {
                            Brigade s = it.next();
                            System.out.println("'"+i+"'" + ". " + s.getBrigadeNumber()+ " " + s.getTypeOfBrigade());
                        }
                        System.out.print("\nWhat brigade you want to remove: ");
                        brigades.remove(getIndexForRemoveBrigade());
                    }
                    break;
                case "Exit":
                    exit = true;
                    System.out.println("Thank you for using our app.");
                    break;
                default:
                    System.out.println("\nWrong command! Try again");
                    break;
            }
    }

        public String getCommandFromUser () {
            System.out.print("\nEnter here: ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            return command;
        }

        public int getBrigadeNumberFromUser() {
        Scanner sc = new Scanner(System.in);
            int num;
            while (true)
                try {
                    num = Integer.parseInt(sc.nextLine());
                    if ( num < 0 ) {
                        System.out.print("Only positive numbers: ");
                        continue;
                    }
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.print("It must be a number. Try again: ");
                }
            return num;
    }

        public int getIndexForRemoveBrigade() {
            Scanner sc = new Scanner(System.in);
            int num;
            while (true)
                try {
                    num = Integer.parseInt(sc.nextLine());
                    if (num < 0 || num >= brigades.size()) {
                        System.out.print("Only number from the list: ");
                        continue;
                    }
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.print("It must be a number. Try again: ");
                }
            return num-1;
    }

        public Brigade brigadeCreation(){
            Brigade newBrigade = new Brigade();

            System.out.print("\nPlease set type of brigade (PRS/KRS): ");
            String typeOfBrigadeFromUser = getCommandFromUser();
            if (typeOfBrigadeFromUser.equals("PRS") || typeOfBrigadeFromUser.equals("KRS")) {
                newBrigade.setTypeOfBrigade(typeOfBrigadeFromUser);
            } else {
                System.out.println("\nWrong type. Try again.");
                brigadeCreation();
            }

            System.out.print("\nPlease set brigade number: ");
            int brigadeNumberFromUser = getBrigadeNumberFromUser();
            newBrigade.setBrigadeNumber(brigadeNumberFromUser);

            System.out.print("\nPlease set name of brigade's master: ");
            String mastersNameFromUser = getCommandFromUser();
            newBrigade.setNameOfBrigadeMaster(mastersNameFromUser);

            System.out.print("\nYou create new brigade successfully: ");
            System.out.println(newBrigade.toString());

            return newBrigade;
        }
}
