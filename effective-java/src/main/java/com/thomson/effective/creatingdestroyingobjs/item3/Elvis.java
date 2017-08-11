package com.thomson.effective.creatingdestroyingobjs.item3;

/**
 * Enforce the singleton property with a private constructor or an enum type
 * <p/>
 * A singleton is simply a class that is instantiated exactly once.
 * Before release 1.5, there were two ways to implement singleton. Both are
 * based on keeping the constructor private and exporting a public static member
 * to provide access to the sole instance.
 * <p/>
 * -- first approach, the member is a final field.
 * -- second approach, the member is a static factory method.
 * <p/>
 * The main advantage of the public field approach is that the declarations make it
 * clear that the class is a singleton: the public static field is final, so it will
 * always contain the same object reference.
 * One advantage of the factory-method approach is that it gives you the flexibility
 * to change your mind about whether the class should be a singleton without changing
 * its API.
 * <p/>
 * As of release 1.5, there is a third approach to implementing singletons. Simply make
 * an enum type with one element. This approach is functionally equivalent to the public
 * field approach, except that it is more concise, provides the serialization machinery
 * for free, and provides an ironclad guarantee against multiple instantiation, even in
 * the face of sophisticated serialization or reflection attacks. While this approach has
 * yet to be widely adopted a single-element enum type is the best way to implement a singleton.
 *
 * @author Thomson Tang
 * @since 1.0-SNAPSHOT
 */

// Singleton with public final field
//public class Elvis {
//    public static final Elvis INSTANCE = new Elvis();
//    private Elvis() {/* ... */}
//
//    public void leaveTheBuilding() {/* ... */}
//}


// Single with static factory
//public class Elvis {
//    private static final Elvis INSTANCE = new Elvis();
//    private Elvis() {/* ... */}
//    public static Elvis getInstance() { return INSTANCE; }
//
//    public void leaveTheBuilding() {/* ... */}
//}

public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {/* ... */}
}
