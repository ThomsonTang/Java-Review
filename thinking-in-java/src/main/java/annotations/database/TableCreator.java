package annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementing the database annotation processor which reads in a class file, checks for
 * its database annotations and generates the SQL command for making the database.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/3/13
 */
public class TableCreator {
    public static void main(String[] args) throws Exception{
        if (args.length < 1) {
            System.out.println("arguments: annotated classes.");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DbTable annotation in class " + className);
                continue;
            }

            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1) {
                    continue; // not a db table column
                }
                if (annotations[0] instanceof SqlInteger) {
                    SqlInteger sqlInteger = (SqlInteger) annotations[0];
                    // Use field name if name not specified.
                    if (sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }
                    columDefs.add(columnName + " INT " + getConstraints(sqlInteger.constraints()));
                }
                if (annotations[0] instanceof SqlString) {
                    SqlString sqlString = (SqlString)annotations[0];
                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraints()));
                }

                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columDefs) {
                    createCommand.append("\n    ").append(columnDef).append(",");
                }
                //Remove tail comma
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constraints cons) {
        String constraints = "";
        if (!cons.allowNull())
            constraints += " NOT NULL";
        if (cons.primaryKey())
            constraints += " PRIMARY KEY";
        if (cons.unique())
            constraints += " UNIQUE";
        return constraints;
    }
}
