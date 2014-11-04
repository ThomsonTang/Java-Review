package exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class that dynamically adds fields to itself.
 *
 * @author Thomson Tang
 */

class DynamicFieldsException extends Exception {
}


public class DynamicFields {
    private static final Logger logger = LoggerFactory.getLogger(DynamicFields.class);
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[] {null, null};
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }

        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        //No empty fields, Add one.
        Object[][] temp = new Object[fields.length + 1][2];
        System.arraycopy(fields, 0, temp, 0, fields.length);
        for (int i = fields.length; i < temp.length; i++) {
            temp[i] = new Object[] {null, null};
        }
        fields = temp;

        // Recursive call with expanded fields.
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {
        if (null == value) {
            // Most Exceptions don't have a "cause" constructor.
            // In these cases, you must use initCause(), available in all Throwable subclasses.
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }

        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }
        Object result = null;
        try {
            result = getField(id); // Got old value.
        } catch (NoSuchFieldException e) {
            // Use constructor that takes "cause"
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        logger.info("df: \n{}", df);
        try {
            df.setField("d", "a value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            logger.info("df: \n{}", df);
            df.setField("d", "a new value for d");
            df.setField("nubmer3", 11);
            logger.info("df: \n{}", df);
            logger.info("df.getField(\"d\"): \n{}", df.getField("d"));
            Object field = df.setField("d", null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        } catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}
