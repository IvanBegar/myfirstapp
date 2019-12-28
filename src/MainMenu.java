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
            switch (command) {
                case "List":
                    break;
                case "Add":
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

        private String getCommandFromUser () {
            System.out.println("\nEnter a command:");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            return command;
        }


}
