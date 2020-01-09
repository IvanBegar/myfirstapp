/**
 * @author Ivan Begar
 */

public class Brigade {

    private int brigadeNumber;
    private String nameOfBrigadeMaster;
    private String typeOfPA;
    private String typeOfBrigade;

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

    public void setNameOfBrigadeMaster(String nameOfBrigadeMaster) {
        this.nameOfBrigadeMaster = nameOfBrigadeMaster;
    }

    public String getNameOfBrigadeMaster() {
        return nameOfBrigadeMaster;
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
        return "\nBrigade №'" + brigadeNumber + '\'' +
                ", name of brigade master = '" + nameOfBrigadeMaster + '\'' +
                ", type of PA = '" + typeOfPA + '\'' +
                ", type of brigade = '" + typeOfBrigade + '\'';
    }
}

