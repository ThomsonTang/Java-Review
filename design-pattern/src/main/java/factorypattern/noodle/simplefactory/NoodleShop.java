package factorypattern.noodle.simplefactory;

/**
 * The shop sales beef noodle.
 *
 * @author Thomson Tang
 */
public class NoodleShop {

    SimpleNoodleFactory noodleFactory; // now we give BeefNodeShop a reference to a SimpleNoodleFactory.

    // BeefNoodleShop gets the factory passed to it in the constructor.
    public NoodleShop(SimpleNoodleFactory noodleFactory) {
        this.noodleFactory = noodleFactory;
    }

    /**
     * Basic order for a simple beef noodle.
     *
     * @return #BeefNoodle
     */
    Noodle orderBeefNoodle() {
        Noodle noodle =
            new Noodle(); // for flexibility, we really want this to be an abstract class or interface, but we can't directly instantiate either of those.

        noodle.prepare();
        noodle.make();
        noodle.cook();
        noodle.fill();
        return noodle;
    }

    /**
     * Order the beef noodle by specific type.
     *
     * @param type the type
     * @return #BeefNoodle
     */
    Noodle orderBeefNoodle(String type) {
        /*
         * ues the factory to create noodle by simply passing on the type of the order.
         * we've replaced the new operator with a create method on the factory object,
         * no more concrete instantiation here.
         */
        Noodle noodle = noodleFactory.createNoodle(type);

        //        if (type.equals("thinner")) {
        //            noodle = new ThinnerBeefNoodle();
        //        } else if (type.equals("thin")) {
        //            noodle = new ThinBeefNoodle();
        //        } else if (type.equals("thick")) {
        //            noodle = new ThickBeefNoodle();
        //        } else {
        //            noodle = new BeefNoodle();
        //        }

        noodle.prepare();
        noodle.make();
        noodle.fill();
        return noodle;
    }
}
