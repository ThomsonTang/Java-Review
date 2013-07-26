package corejava;

public class Inherit {

    static {
        System.out.print("A");
    }

    public static void main(String[] args) {
        SubClass s1 = new SubClass(1);
        SubClass s2 = s1;
        change(s2);

        System.out.print(s1.value);
        System.out.print(s2.value);
        System.out.println("a" + 100 % 3 + 100);

        String s = "...a.b.c.....";
        String[] arr = s.split("\\.");
        System.out.println("length of arra: " + arr.length);
        System.out.println("first element of arra: " + arr[0]);
        System.out.println("second element of arra: " + arr[1]);
        System.out.println("second element of arra: " + arr[2]);
    }

    static void change(SubClass s2) {
        s2.value = 2;
    }
}

class SubClass {
    int value;

    public SubClass(int value) {
        this.value = value;
    }
}
