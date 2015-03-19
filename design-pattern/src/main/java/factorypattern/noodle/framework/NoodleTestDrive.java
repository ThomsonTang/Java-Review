package factorypattern.noodle.framework;

/**
 * Wow, I want to eat noodles.
 *
 * @author Thomson Tang
 */
public class NoodleTestDrive {
    public static void main(String[] args) {
        NoodleStore beefNoodleStore = new LanzhouNoodleStore();
        NoodleStore knifingNoodleStore = new ShanxiNoodleStore();

        Noodle noodle = beefNoodleStore.orderNoodle("beef");
        System.out.println("tom orders " + noodle.getName());

        noodle = knifingNoodleStore.orderNoodle("knifing");
        System.out.println("elvis orders " + noodle.getName());
    }
}
