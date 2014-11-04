package annotations.database.jdbc;

import annotations.database.Constraints;
import annotations.database.DBTable;
import annotations.database.SqlInteger;
import annotations.database.SqlString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * The DBTable annotation processor.
 * It process and resolve the annotations of a bean, finally, generate the SQL statement for
 * creating the relative table.
 *
 * @author Thomson Tang
 */
public class SchemaStatementCreator {

    private static final Logger logger = LoggerFactory.getLogger(SchemaStatementCreator.class);

    public static String getCreateStatement(Class<?> clazz) {
        if (null == clazz) {
            logger.info("arguments clazz null");
            System.exit(0);
        }

        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if (null == dbTable) {
            logger.info("no DBTable annotation in class {}.", clazz.getName());
            System.exit(0);
        }

        String tableName = getTableName(clazz, dbTable);

        List<String> columnDefinitions = getColumnDefinitions(clazz);

        StringBuilder createStatement = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnDef : columnDefinitions) {
            createStatement.append("\n  ").append(columnDef).append(",");
        }
        String schemaCreateStatement = createStatement.substring(0, createStatement.length() - 1) + ");";
        logger.info("Table Creation SQL for {} is:\n\n {}", clazz.getName(), schemaCreateStatement);
        return schemaCreateStatement;
    }

    private static List<String> getColumnDefinitions(Class<?> clazz) {
        List<String> columnDefinitions = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            String columnName;
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1) {
                logger.info("{} field is not a DB table column.", field.getName());
                continue;
            }

            if (annotations[0] instanceof SqlInteger) {
                SqlInteger sqlInteger = (SqlInteger) annotations[0];
                if (sqlInteger.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sqlInteger.name();
                }
                columnDefinitions.add(columnName + " INT " + getConstraints(sqlInteger.constraints()));
            }

            if (annotations[0] instanceof SqlString) {
                SqlString sqlString = (SqlString) annotations[0];
                if (sqlString.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sqlString.name();
                }
                columnDefinitions.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraints()));
            }
        }
        return columnDefinitions;
    }

    private static String getTableName(Class<?> clazz, DBTable dbTable) {
        String tableName = dbTable.name();
        if (tableName.length() < 1) {
            tableName = clazz.getName().toUpperCase();
        }
        return tableName;
    }

    private static String getConstraints(Constraints constraints) {
        StringBuilder constraintsBuilder = new StringBuilder();
        if (!constraints.allowNull()) {
            constraintsBuilder.append(" NOT NULL");
        }
        if (constraints.primaryKey()) {
            constraintsBuilder.append(" PRIMARY KEY");
        }
        if (constraints.unique()) {
            constraintsBuilder.append(" UNIQUE");
        }
        return constraintsBuilder.toString();
    }
}
