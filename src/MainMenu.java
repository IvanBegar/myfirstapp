import java.io.*;
import java.util.*;

public class MainMenu {

    private static List<Brigade> brigades = new ArrayList<>();
    ServiceCompany serviceCompany = new ServiceCompany(brigades);
    boolean exit;
    boolean back;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readFile();
        MainMenu mainMenu = new MainMenu();
        mainMenu.runMain();
    }

        public void runMain() throws IOException {
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

        public void performCommand(String command) throws IOException {
            switch (command) {
                case "List":
                    listOfBrigades();
                    doYouWantToManageBrigade();

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
                        int y = 1;
                        for (Iterator<Brigade> it = brigades.iterator(); it.hasNext(); y++) {
                            Brigade s = it.next();
                            System.out.println("'"+y+"'" + ". " + s.getBrigadeNumber()+ " " + s.getTypeOfBrigade());
                        }
                        System.out.print("\nWhat brigade you want to remove: ");
                        brigades.remove(getIndexOfBrigade());
                    }
                    System.out.println("You returned to main menu.");
                    break;
                case "Exit":
                    exit = true;
                    saveBrigadesToTheFile();
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

        public int getPositiveNumberFromUser() {
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

        public int getIndexOfBrigade() {
            Scanner sc = new Scanner(System.in);
            int num;
            while (true)
                try {
                    num = Integer.parseInt(sc.nextLine());
                    if (num < 0 || num > brigades.size()) {
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
            List<Employee> employees = new ArrayList<>();
            Brigade newBrigade = new Brigade(employees);


            System.out.print("\nPlease set type of brigade (PRS/KRS): ");
            String typeOfBrigadeFromUser = getCommandFromUser();
            if (typeOfBrigadeFromUser.equals("PRS") || typeOfBrigadeFromUser.equals("KRS")) {
                newBrigade.setTypeOfBrigade(typeOfBrigadeFromUser);
            } else {
                System.out.println("\nWrong type. Try again.");
                brigadeCreation();
            }

            System.out.print("\nPlease set brigade number: ");
            int brigadeNumberFromUser = getPositiveNumberFromUser();
            newBrigade.setBrigadeNumber(brigadeNumberFromUser);

            System.out.print("\nYou create new brigade successfully: ");
            System.out.println(newBrigade.toString());

            return newBrigade;
        }

        public void saveBrigadesToTheFile() {
            System.out.println("\nDo you want save changes?");
            String command = getCommandFromUser();
            if (command.equals("Yes")) {
                try (FileOutputStream fous = new FileOutputStream("brigades.bin")) {
                    ObjectOutputStream oos = new ObjectOutputStream(fous);
                    oos.writeObject(brigades);
                    System.out.println("\nChanges saved.");
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (command.equals("No")){
                System.out.println("\nChanges not saved.");
            } else {
                System.out.println("Wrong command. Try again.");
                saveBrigadesToTheFile();
            }
    }

        public static void readFile() throws ClassNotFoundException, IOException {
            try {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream("brigades.bin"));
                List<Object> input = (List<Object>) is.readObject();
                for (Object l : input) {
                    if (l instanceof Brigade) {
                        Brigade app = (Brigade) l;
                        brigades.add(app);
                    }
                }
            } catch (EOFException e) {
                e.printStackTrace();
            }
    }

        public void brigadeManagement(Brigade brigade) throws IOException {
            String command = getCommandFromUser();
                switch (command) {
            case "Edit":

                break;
            case "Add":
                Employee employee = employeeCreation();
                brigade.addEmployee(employee);
                break;
            case "Info":
                List<Employee> employees = brigade.getEmployees();
                System.out.println(brigade.toString());
                System.out.println("Employees of brigade: ");
                for (Employee employee1 : employees) {
                    System.out.println(employee1.toString());
                }
                break;
            case "Back":
                back = true;
                break;
            default:
                System.out.println("\nWrong command! Try again");
                break;
                }
            }

        private void printAvailableCommandsForBrigades () {
        System.out.println("\nAvailable command's: ");
        System.out.println("1. 'Edit' - Edit information to brigade");
        System.out.println("2. 'Add' - Add a new employee to the brigade");
        System.out.println("3. 'Info' - Show's info about brigade");
        System.out.println("4. 'Back' - Back to main menu");
    }

        private Employee employeeCreation() {
            Employee employee = new Employee();

            System.out.print("\nPlease set the position of employee (Master/Driller/Machinist/Helper): ");
            String positionOfEmployee = getCommandFromUser();
            if (positionOfEmployee.equals("Master") || positionOfEmployee.equals("Driller") ||
                    positionOfEmployee.equals("Machinist") || positionOfEmployee.equals("Helper")){
                    employee.setPosition(positionOfEmployee);
                } else {
                System.out.println("\nWrong type. Try again.");
                employeeCreation();
            }

            if (employee.getPosition() == null) {
                employeeCreation();
            } else {
                System.out.println("Please set the name of employee: ");
                employee.setName(getCommandFromUser());

                System.out.println("Please set the age of employee: ");
                employee.setAge(getPositiveNumberFromUser());
            }
            return employee;
    }

        private void listOfBrigades() throws IOException {
        if (brigades.isEmpty()) {
            System.out.println("\nNo brigades exists.");
        } else {
            int i = 1;
            for (Iterator<Brigade> it = brigades.iterator(); it.hasNext(); i++) {
                Brigade s = it.next();
                System.out.println("'"+i+"'" + ". " + s.toString());
            }
    }


}

        private void doYouWantToManageBrigade () throws IOException {
        System.out.println("\nDo you want manage brigade? (Manage/Back)");
        String yesOrNO = getCommandFromUser();
        if (yesOrNO.equals("Manage")) {
            System.out.println("What brigade you want manage?");
            int brigadeIndex = getIndexOfBrigade();
            Brigade brigade = brigades.get(brigadeIndex);
            while (!back){
                printAvailableCommandsForBrigades();
                brigadeManagement(brigade);
            }
        } else if (yesOrNO.equals("Back")){
            System.out.println("");
            System.out.println("\nYou returned to main menu.");
        } else {
            System.out.println("Wrong command. Try again");
            doYouWantToManageBrigade();
        }
    }
}