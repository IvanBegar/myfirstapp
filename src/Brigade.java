import java.util.Scanner;

/**
 * @author Ivan Begar
 */

public class Brigade {

    public Brigade(){
        this.nameOfBrigade = "Name of brigade is default";
        this.idOfBrigade = 0;
        this.nameOfBrigadeMaster = "Default";
    }

    private String nameOfBrigade;
    private int idOfBrigade;
    private String nameOfBrigadeMaster;
    private static final String DEFAULT_PA = "PA is default";

    public String getNameOfBrigadeMaster() {
        return nameOfBrigadeMaster;
    }

    public void setNameOfBrigadeMaster(String nameOfBrigadeMaster) {
        this.nameOfBrigadeMaster = nameOfBrigadeMaster;
    }

    public String getNameOfBrigade() {
        return nameOfBrigade;
    }

    public void setNameOfBrigade(String nameOfBrigade) {
        this.nameOfBrigade = nameOfBrigade;
    }

    public int getIdOfBrigade() {
        return idOfBrigade;
    }

    public void setIdOfBrigade(int idOfBrigade) {
        if (idOfBrigade > 0) {
            this.idOfBrigade = idOfBrigade;
        } else if (idOfBrigade < 0) {
            System.out.println("ID can`t be less then 0, automatically setted as default");
        } else {
            this.idOfBrigade = 0;
            System.out.print("ID of brigade is default = ");
        }
    }

    public String getPA() {
        return DEFAULT_PA;
    }

    public void getDescription() {
        System.out.println("Default description");
    }

    public String getTypeOfBrigade() {
        String typeOfBrigade = "Default";
        return typeOfBrigade;
    }

}

