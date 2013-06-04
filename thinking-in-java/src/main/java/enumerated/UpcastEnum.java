package enumerated;

/**
 * If you upcast an {@code enum} type to {@code Enum}, the {@code values()} method will not be available.
 * Notice, however, that there is a {@code getEnumConstants()} method in {@code Class}, so even if {@code values()}
 * is not part of the interface of {@code Enum}, we can still get the {@code enum} instances via the {@code Class}
 * object.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */
enum Search {
    HITHER, YON
}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum e = Search.HITHER; // upcast
        //e.values();  // cannot resolve the method, no values() in Enum.

        for (Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}
