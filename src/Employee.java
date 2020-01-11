import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

    private String name;
    private String position;
    private int age;
    private double salary;
    private static int onlyOneMaster = 0;
    private static int onlyTwoDrillers = 0;
    private static int onlyOneMachinist = 0;
    private static int onlyFourHelper = 0;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
            if (position.equals("Master")) {
                if (onlyOneMaster == 0) {
                    this.position = position;
                    this.salary = 50000;
                    onlyOneMaster++;
                } else {
                    System.out.println("Brigade already have a master. Try to add another employee.");
                }
            } else if (position.equals("Machinist")) {
                if (onlyOneMachinist == 0) {
                    this.position = position;
                    this.salary = 20000;
                onlyOneMachinist++;
                } else {
                    System.out.println("Brigade already have a machinist. Try to add another employee.");
                }
            } else if (position.equals("Driller")) {
                if (onlyTwoDrillers < 2) {
                    this.position = position;
                    this.salary = 35000;
                    onlyTwoDrillers++;
                } else {
                    System.out.println("Brigade already have two drillers`s. Try to add another employee.");
                }
            } else if (position.equals("Helper")) {
                if (onlyFourHelper < 4) {
                    this.position = position;
                    this.salary = 20000;
                    onlyFourHelper++;
                } else {
                    System.out.println("Brigade already have four helper`s. Try to add another employee.");
                }
            } else {
                this.position = position;
            }
        }

    @Override
    public String toString() {
        return "Employee " + name  + ", position: " + position + ", age: "+ age + ", salary: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
