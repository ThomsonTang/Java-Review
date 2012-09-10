package strings;

/**
 * Since <code>String</code> objects are immutable, you can alias to a particular <code>String</code> as
 * many times as you want. Because a <code>String</code> is read-only, there's no possibility that one
 * reference will change something that will affect the other references.
 * <p></p>
 * Immutability can have efficiency issues. The '+' and '+=' for <code>String</code> are the only operators
 * that are overloaded in Java, and Java does not allow the programmer to overload any others.
 * <p></p>
 * The following code works like this:
 * <p>The String "abc" could have a method append() that creates a new <code>String</code> object containing
 * "abc" concatenated with the contents of mango. The new String object would then create another new String
 * that added "def", and so on.
 * <p></p>
 * There was no mention of <code>StringBuilder</code> in the source code, but the compiler decided to use it
 * anyway, because it is much more efficient.
 * <p></p>
 * In this case, the compiler creates a <code>StringBuilder</code> object to build the Strings, and call append()
 * four times, one for each of the pieces. Finally, it calls toString() to produce the result.
 *
 *
 * User: tangguike
 * Date: 8/11/12
 * Time: 6:30 PM
 */
public class Concatenation {
    public static void main(String[] args){
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
/*
[tangguike@thomsontang classes]$ javap -c strings.Concatenation
Compiled from "Concatenation.java"
public class strings.Concatenation {
  public strings.Concatenation();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String mango
       2: astore_1
       3: new           #3                  // class java/lang/StringBuilder
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: ldc           #5                  // String abc
      12: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      15: aload_1
      16: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: ldc           #7                  // String def
      21: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: bipush        47
      26: invokevirtual #8                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      29: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      32: astore_2
      33: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
      36: aload_2
      37: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      40: return
}
 */
