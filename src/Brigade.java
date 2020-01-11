import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Ivan Begar
 */

public class Brigade implements Serializable {

    private List<Employee> employees;
    private int brigadeNumber;
    private String typeOfPA;
    private String typeOfBrigade;
    private int onlyOneMaster = 0;
    private int onlyTwoDrillers = 0;
    private int onlyOneMachinist = 0;
    private int onlyFourHelper = 0;

    public Brigade(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        String position = employee.getPosition();
        if (position.equals("Master")) {
            if (onlyOneMaster == 0) {
                this.employees.add(employee);
                onlyOneMaster++;
            } else {
            System.out.println("Brigade already have a master.");
            }
        } else if (position.equals("Machinist")) {
            if (onlyOneMachinist == 0) {
                this.employees.add(employee);
                onlyOneMachinist++;
            } else {
                System.out.println("Brigade already have a machinist.");
            }
        } else if (position.equals("Driller")) {
            if (onlyTwoDrillers < 2) {
                this.employees.add(employee);
                onlyTwoDrillers++;
            } else {
                System.out.println("Brigade already have two drillers`s.");
            }
        } else if (position.equals("Helper")) {
            if (onlyFourHelper < 4) {
                this.employees.add(employee);
                onlyFourHelper++;
            } else {
                System.out.println("Brigade already have four helper`s.");
            }
        } else {
            System.out.println("\nTry again.");
        }
    }

    public void setTypeOfBrigade(String typeOfBrigade) {
        if (typeOfBrigade.equals("PRS")) {
            this.typeOfBrigade = typeOfBrigade;
            this.typeOfPA = "APRS-50";
        } else if (typeOfBrigade.equals("KRS")) {
            this.typeOfBrigade = typeOfBrigade;
            this.typeOfPA = "UPA-60/80";
        } else {
            System.out.println("\nWrong type. Try again.");
        }
    }

    public void setBrigadeNumber(int brigadeNumber) {
        this.brigadeNumber = brigadeNumber;
    }

    public int getBrigadeNumber() {
        return brigadeNumber;
    }

    public String getTypeOfBrigade() {
        return typeOfBrigade;
    }

    @Override
    public String toString() {
        return "Brigade №'" + brigadeNumber +
                "', type of PA: '" + typeOfPA  +
                "', type of brigade: '" + typeOfBrigade + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brigade brigade = (Brigade) o;
        return brigadeNumber == brigade.brigadeNumber &&
                typeOfPA.equals(brigade.typeOfPA) &&
                typeOfBrigade.equals(brigade.typeOfBrigade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brigadeNumber, typeOfPA, typeOfBrigade);
    }
}

