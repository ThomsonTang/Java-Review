package initialization;

/**
 * Using finalize() to detect an object that hasn't been properly cleaned up.
 *
 * @author Thomson Tang
 * @since 1.0-SNAPSHOT
 */
class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut)
            System.out.println("Error: checked out");
        else
            System.out.println("checking out");
        //Normally, you'll also do this:
        super.finalize(); //Call the base-class version
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        //Proper clean up:
        novel.checkIn();
        //Drop the reference. forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
    }
}
