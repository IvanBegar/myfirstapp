/**
 * @author Ivan Begar
 */

public class KrsBrigade extends Brigade {

    private static final String PA = "UPA-60/80";

    @Override
    public String getPA() {
        return PA;
    }

    @Override
    public void getDescription() {
        System.out.println("КRS brigade makes complex well repairs");
    }

    @Override
    public String getTypeOfBrigade() {
        String typeOfBrigade = "KRS";
        return typeOfBrigade;
    }
}
