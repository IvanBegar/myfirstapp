import java.io.*;
import java.util.*;

public class MainMenu {

    private static List<Brigade> brigades = new ArrayList<>();
    private boolean exit;
    private boolean back;
    private boolean back2;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readFile();
        MainMenu mainMenu = new MainMenu();
        mainMenu.runMain();
    }

        private void runMain() {
        printHeadOfMenu();
        while (!exit) {
            availableCommandsForMainMenu();
            int command = getPositiveNumberFromUser();
            performCommand(command);
        }
    }

        private void printHeadOfMenu() {
        System.out.println("+---------------------------+");
        System.out.println("|   Welcome to our program  |");
        System.out.println("+---------------------------+");
    }

        private String getCommandFromUser() {
        System.out.print("\nEnter here: ");
        Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
    }

        private int getPositiveNumberFromUser() {
        System.out.print("\nEnter here: ");
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

        private int getIndexForRemove() {
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

        private void performCommand(int command) {
            switch (command) {
                case 1:
                    listOfBrigades();
                    doYouWantToManageBrigade();
                    break;
                case 2:
                    Brigade newBrigade = brigadeCreation();
                    brigades.add(newBrigade);
                    System.out.println("You returned to main menu.");
                    break;
                case 3:
                    brigadeRemove(brigades);
                    System.out.println("You returned to main menu.");
                    break;
                case 4:
                    exit = true;
                    saveBrigadesToTheFile();
                    System.out.println("Thank you for using our app.");
                    break;
                default:
                    System.out.println("\nWrong command! Try again");
                    break;
            }
    }

        private void brigadeManagement(Brigade brigade) {
            int command = getPositiveNumberFromUser();
                switch (command) {
            case 1:
                brigadeEdit(brigade);
                break;
            case 2:
                while (!back2){
                    availableCommandsForEmployeeManage();
                    employeeManagement(brigade);
                }
                back2 = false;
                break;
            case 3:
                System.out.println();
                System.out.println(brigade.toString());
                listOfEmployee(brigade);
                break;
            case 4:
                back = true;
                break;
            default:
                System.out.println("\nWrong command! Try again");
                break;
                }
            }

        private void employeeManagement(Brigade brigade) {
            int command = getPositiveNumberFromUser();
            switch (command) {
                case 1:
                    Employee employee = employeeCreation();
                    if (employee != null) {
                        brigade.addEmployee(employee);
                    }
                    break;
                case 2:
                    employeeRemove(brigade);
                    break;
                case 3:
                    Brigade brigade1 = finalBrigadeForEmployee();
                    employeeTransfer(brigade, brigade1);
                    break;
                case 4:
                    back2 = true;
                    break;
                default:
                    System.out.println("\nWrong command! Try again");
                    break;
            }
        }

        private void availableCommandsForMainMenu() {
        System.out.println("\nAvailable command's: ");
        System.out.println("'1'. Show's list of brigade's.");
        System.out.println("'2'. Add a new brigade to the list.");
        System.out.println("'3'. Remove brigade from the list.");
        System.out.println("'4'. Close the program.");
    }

        private void availableCommandsForBrigadeManage() {
        System.out.println("\nAvailable command's: ");
        System.out.println("'1'. Edit information to brigade.");
        System.out.println("'2'. Employee management of the brigade.");
        System.out.println("'3'. Show's info about brigade.");
        System.out.println("'4'. Back to main menu.");
    }

        private void availableCommandsForEmployeeManage() {
            System.out.println("\nAvailable commands: ");
            System.out.println("'1'. Add a new employee to the brigade.");
            System.out.println("'2'. Remove an employee from brigade.");
            System.out.println("'3'. Transfer employee from this brigade to another.");
            System.out.println("'4'. Back to brigade manage menu.");
    }

        private Employee employeeWithPosition() {
        Employee employee = new Employee();

        System.out.println("\nEmployee of what position you want to create: ");
        System.out.println("'1'. Master.");
        System.out.println("'2'. Driller.");
        System.out.println("'3'. Machinist.");
        System.out.println("'4'. Helper.");
        int positionOfEmployee = getPositiveNumberFromUser();
        if (positionOfEmployee == 1) {
            employee.setPosition("Master");
        } else if (positionOfEmployee == 2) {
            employee.setPosition("Driller");
        } else if (positionOfEmployee == 3) {
            employee.setPosition("Machinist");
        } else if (positionOfEmployee == 4) {
            employee.setPosition("Helper");
        } else {
            System.out.println("\nWrong type. Try again.");
            employeeCreation();
        }
        return employee;
    }

        private Employee employeeCreation() {

            Employee employee = employeeWithPosition();

            if (employee.getPosition() == null) {
                return null;
            } else {
                System.out.println("\nPlease set the name of employee: ");
                employee.setName(getCommandFromUser());

                System.out.println("\nPlease set the age of employee: ");
                employee.setAge(getPositiveNumberFromUser());
            }
            return employee;
    }

        private Brigade brigadeCreation(){
        List<Employee> employees = new ArrayList<>();
        Brigade newBrigade = new Brigade(employees);


        System.out.println("\nPlease set type of brigade: ");
        System.out.println("'1'. Create PRS brigade.");
        System.out.println("'2'. Create KRS brigade.");
        int typeOfBrigadeFromUser = getPositiveNumberFromUser();
        if (typeOfBrigadeFromUser == 1) {
            newBrigade.setTypeOfBrigade("PRS");
        } else if (typeOfBrigadeFromUser == 2) {
            newBrigade.setTypeOfBrigade("KRS");
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

        private void brigadeEdit(Brigade brigade) {
        System.out.println("What you want to edit?");
        System.out.println("'1'. Number of brigade.");
        System.out.println("'2'. Type of brigade.");
        int command2 = getPositiveNumberFromUser();
        if (command2 == 1) {
            System.out.println("Please set a new number for brigade: ");
            int newNumber = getPositiveNumberFromUser();
            brigade.setBrigadeNumber(newNumber);
        } else if (command2 == 2) {
            System.out.println("Please set a new brigade type: ");
            System.out.print("'1'. Create PRS brigade.");
            System.out.print("'2'. Create KRS brigade.");
            int typeOfBrigadeFromUser = getPositiveNumberFromUser();
            if (typeOfBrigadeFromUser == 1) {
                brigade.setTypeOfBrigade("PRS");
            } else if (typeOfBrigadeFromUser == 2) {
                brigade.setTypeOfBrigade("KRS");
            } else {
                System.out.println("\nWrong type. Try again.");
            }
        }
    }

        private void brigadeRemove(List<Brigade> brigades) {
        if (brigades.isEmpty()) {
            System.out.println("\nNo brigades exists.");
        } else {
            int y = 1;
            for (Iterator<Brigade> it = brigades.iterator(); it.hasNext(); y++) {
                Brigade s = it.next();
                System.out.println("'"+y+"'" + ". " + s.getBrigadeNumber()+ " " + s.getTypeOfBrigade());
            }
            System.out.print("\nWhat brigade you want to remove: ");
            brigades.remove(getIndexForRemove());
        }
    }

        private void employeeRemove(Brigade brigade) {
        List<Employee> employees = brigade.getEmployees();
        if (employees.isEmpty()) {
            System.out.println("\nBrigade have not employee`s.");
        } else {
            int y = 1;
            for (Iterator<Employee> it = employees.iterator(); it.hasNext(); y++) {
                Employee s = it.next();
                System.out.println("'"+y+"'" + ". " + s.toString());
            }
            System.out.print("\nWhat employee you want to remove: ");
            employees.remove(getIndexForRemove());
        }
    }

        private void listOfBrigades() {
        if (brigades.isEmpty()) {
            System.out.println("\nNo brigades exists.");
        } else {
            int i = 1;
            System.out.println();
            for (Iterator<Brigade> it = brigades.iterator(); it.hasNext(); i++) {
                Brigade s = it.next();
                System.out.println("'"+i+"'" + ". " + s.toString());
            }
    }
}

        private void listOfEmployee(Brigade brigade) {
        List<Employee> employees = brigade.getEmployees();
        System.out.println("Employee`s of brigade: ");
        if (!employees.isEmpty()){
            for (Employee employee1 : employees) {
                System.out.println(employee1.toString());
            }
        }   else {
            System.out.println("Brigade don`t have employee`s.");
        }
    }

        private void doYouWantToManageBrigade () {
        System.out.println("\nAvailable command`s: ");
        System.out.println("'1'. Manage a brigade.");
        System.out.println("'2'. Back to main menu.");
        int oneOrTwo = getPositiveNumberFromUser();
        if (oneOrTwo == 1) {
            System.out.println("What brigade you want manage?");
            listOfBrigades();
            System.out.print("\nEnter here: ");
            int brigadeIndex = getIndexForRemove();
            Brigade brigade = brigades.get(brigadeIndex);
            while (!back){
                availableCommandsForBrigadeManage();
                brigadeManagement(brigade);
            }
            back = false;
        } else if (oneOrTwo == 2){
            System.out.println("\nYou returned to main menu.");
        } else {
            System.out.println("\nWrong command. Try again.");
            doYouWantToManageBrigade();
        }
    }

        private void saveBrigadesToTheFile() {
        System.out.println("\nDo you want save changes?");
        System.out.println("'1'. Yes");
        System.out.println("'2'. No");
        int command = getPositiveNumberFromUser();
        if (command == 1) {
            try (FileOutputStream fous = new FileOutputStream("brigades.bin")) {
                ObjectOutputStream oos = new ObjectOutputStream(fous);
                oos.writeObject(brigades);
                System.out.println("\nChanges saved.");
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (command == 2){
            System.out.println("\nChanges not saved.");
        } else {
            System.out.println("Wrong command. Try again.");
            saveBrigadesToTheFile();
        }
    }

        private static void readFile() throws ClassNotFoundException, IOException {
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

        private void employeeTransfer(Brigade brigade1, Brigade brigade2) {
            if (brigade1.equals(brigade2)) {
                System.out.println("\nIt`s a same brigade. Try again.");
            } else {
                List<Employee> employees1 = brigade1.getEmployees();
                List<Employee> employees2 = brigade2.getEmployees();
                if (employees1.isEmpty()) {
                    System.out.println("\nBrigade have not employee`s.");
                } else {
                    int y = 1;
                    for (Iterator<Employee> it = employees1.iterator(); it.hasNext(); y++) {
                        Employee s = it.next();
                        System.out.println("\nEmployee`s: ");
                        System.out.println("'"+y+"'" + ". " + s.toString());
                    }
                    System.out.print("\nWhat employee you want to transfer: ");
                    Employee employee = employees1.get(getIndexForRemove());
                    brigade2.addEmployee(employee);
                    if (employees2.contains(employee)) {
                        employees1.remove(employee);
                    } else {
                        System.out.println("Try again.");
                    }
                }
            }
    }

        private Brigade finalBrigadeForEmployee () {
            System.out.println("\nTo which brigade you want transfer employee?");
            listOfBrigades();
            System.out.print("\nEnter here: ");
            int brigadeIndex = getIndexForRemove();
            return brigades.get(brigadeIndex);
    }
}