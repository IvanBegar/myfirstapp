import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

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

        private void performCommand(String command) {
            List<Brigade> brigades = new ArrayList<>();
            switch (command) {
                case "List":
                    for (Brigade br : brigades) {
                        System.out.println(br.toString());
                    }
                    break;
                case "Add":
                    Brigade newBrigade = brigadeCreation();
                    brigades.add(newBrigade);
                    System.out.println("You returned to main menu. Please enter the command: ");
                    break;
                case "Remove":
                    break;
                case "Exit":
                    exit = true;
                    System.out.println("Thank you for using our app.");
                    break;
                default:
                    wrongCommand();
                    getCommandFromUser();
                    break;
            }
    }

        private void wrongCommand () {
            System.out.println("\nWrong command! Try again");
            System.out.println("Available command's: ");
            System.out.println("1. 'List'");
            System.out.println("2. 'Add'");
            System.out.println("3. 'Remove'");
            System.out.println("4. 'Exit'");
        }

        public String getCommandFromUser () {
            System.out.println("\nEnter here:");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            return command;
        }

        public int getBrigadeNumberFromUser() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) sc.next();
        int num = sc.nextInt();
        if (num < 0) {
            System.out.println("Number can't be negative. Try again: ");
            getBrigadeNumberFromUser();
        }
        return num;
    }

        public Brigade brigadeCreation() {
            Brigade newBrigade = new Brigade();
            System.out.println("\nPlease set type of brigade (PRS/KRS):");
            String typeOfBrigadeFromUser = getCommandFromUser();
            if (typeOfBrigadeFromUser.equals("PRS") || typeOfBrigadeFromUser.equals("KRS")) {
                newBrigade.setTypeOfBrigade(typeOfBrigadeFromUser);
            } else {
                System.out.println("\nWrong type. Try again.");
                brigadeCreation();
            }
            System.out.println("\nPlease set brigade number: ");
            int brigadeNumberFromUser = getBrigadeNumberFromUser();
            newBrigade.setBrigadeNumber(brigadeNumberFromUser);
            System.out.println("\nPlease set name of brigade's master: ");
            String mastersNameFromUser = getCommandFromUser();
            newBrigade.setNameOfBrigadeMaster(mastersNameFromUser);
            System.out.println("\nYou create new brigade successfully: ");
            System.out.println(newBrigade.toString());
            return newBrigade;
        }


}
