package corejava;

public class Inherit {
    
    static {
        System.out.print( "A" );
    }

    public static void main( String[] args ) {
        SubClass s1 = new SubClass( 1 );
        SubClass s2 = s1;
        change( s2 );

        System.out.print( s1.value );
        System.out.print( s2.value );
        System.out.println( "a" + 100%3 + 100 );
    }

    static void change( SubClass s2 ) {
        s2.value = 2;
    }
}

class SubClass {
    int value;

    public SubClass(int value) {
        this.value = value;
    }
}
