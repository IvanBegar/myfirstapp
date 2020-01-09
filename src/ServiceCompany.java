import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ivan Begar
 */

public class ServiceCompany {

    private static List<Brigade> brigades;

    public ServiceCompany(List<Brigade> brigades) {
        this.brigades = brigades;
    }

    public void addBrigade(Brigade brigade) {
        brigades.add(brigade);
    }

    public List<Brigade> getBrigades() {
        return brigades;
    }

}
