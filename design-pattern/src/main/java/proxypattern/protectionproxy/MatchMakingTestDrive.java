package proxypattern.protectionproxy;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/1/13
 */
public class MatchMakingTestDrive {
    public static void main(String[] args) {
        MatchMakingTestDrive testDrive = new MatchMakingTestDrive();
        testDrive.drive();
    }

    PersonBean getOwnProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
    }

    private void drive() {
        PersonBean tim = new PersonBeanImpl("tim", "male", "", 2);
        PersonBean ownProxy = getOwnProxy(tim);
        System.out.println("Name: " + ownProxy.getName());
        ownProxy.setInterests("Sports");
        System.out.println("Interest set from owner proxy.");
        try {
            ownProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy!");
        }
        System.out.println("Rating: " + ownProxy.getHotOrNotRating());

        PersonBean nonOwnProxy = getNonOwnerProxy(tim);
        System.out.println("Name: " + nonOwnProxy.getName());
        try {
            nonOwnProxy.setInterests("Sports");
        } catch (Exception e) {
            System.out.println("Can't set set interests from owner proxy!");
        }
        nonOwnProxy.setHotOrNotRating(8);
        System.out.println("Rating set from owner proxy.");
        System.out.println("Rating: " + nonOwnProxy.getHotOrNotRating());
    }
}
