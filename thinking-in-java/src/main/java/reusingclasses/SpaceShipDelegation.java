package reusingclasses;

/**
 * Reusing Classes/Delegation
 * <p/>
 * It's more accurate to say that a SpaceShip contains SpaceShipControllers,
 * and at the same time all the methods in SpaceShipControllers are exposed
 * in a SpaceShip.
 * ----------------------Delegation solve this dilemma.
 * <p/>
 * caution: Java language doesn't support delegation directly.
 *
 * @author Thomson Tang
 * @version 10/11/13
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipController spaceShipController = new SpaceShipController();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    //Delegated methods
    public void up(int velocity) {
        spaceShipController.up(velocity);
    }

    public void down(int velocity) {
        spaceShipController.down(velocity);
    }
}
