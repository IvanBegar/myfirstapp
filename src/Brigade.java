import javax.swing.*;
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

    public int getOnlyOneMaster() {
        return onlyOneMaster;
    }

    public int getOnlyTwoDrillers() {
        return onlyTwoDrillers;
    }

    public int getOnlyOneMachinist() {
        return onlyOneMachinist;
    }

    public int getOnlyFourHelper() {
        return onlyFourHelper;
    }

    public void addEmployee(Employee employee) {
        String position = employee.getPosition();
        if (position.equals("Master")) {
                this.employees.add(employee);
                this.onlyOneMaster++;
        } else if (position.equals("Machinist")) {
                this.employees.add(employee);
                this.onlyOneMachinist++;
        } else if (position.equals("Driller")) {
                this.employees.add(employee);
                this.onlyTwoDrillers++;
        } else if (position.equals("Helper")) {
                this.employees.add(employee);
                this.onlyFourHelper++;
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
            this.typeOfBrigade = typeOfBrigade;
        }
    }

    public void setBrigadeNumber(int brigadeNumber) {
        this.brigadeNumber = brigadeNumber;
    }

    public int getBrigadeNumber() {
        return brigadeNumber;
    }

    public String getTypeOfPA() {
        return typeOfPA;
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

