/**
 * @author Ivan Begar
 */

public class PrsBrigade extends Brigade {

    private static final String PA = "APRS-50";

    @Override
    public String getPA() {
        return PA;
    }

    @Override
    public void getDescription() {
        System.out.println("PRS brigade makes simple well repairs");
    }

    @Override
    public String getTypeOfBrigade() {
        String typeOfBrigade = "PRS";
        return typeOfBrigade;
    }
}
