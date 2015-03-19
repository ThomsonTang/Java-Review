package factorypattern.noodle.abstractfactory;

/**
 * The new noodle store test driver.
 *
 * @author Thomson Tang
 */
public class NewNoodleTestDrive {

    public static void main(String[] args) {
        NewNoodleStore lanzhouNoodleStore = new LanzhouNoodleStore();
        NewNoodleStore shanxiNoodleStore = new ShanxiNoodleStore();

        NewNoodle beefNoodle = lanzhouNoodleStore.orderNoodle("beef");
        System.out.println("Tom orders " + beefNoodle.getName());
        System.out.println("Clover orders " + lanzhouNoodleStore.orderNoodle("fired").getName());

        NewNoodle knifingNoodle = shanxiNoodleStore.orderNoodle("knifing");
        System.out.println("Hui orders " + knifingNoodle.getName());

    }
}
