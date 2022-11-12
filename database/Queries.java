package database;

import java.util.List;

public class Queries {

    private final static String SCHEMA = "example_schema";

    public static String createTable(String tableName, List<String> attributesList) {
        StringBuilder sqlQuery = new StringBuilder("CREATE TABLE " + SCHEMA + "." + tableName + "(");
        populateQueryWithAttributes(sqlQuery, attributesList);
        sqlQuery.append(");");
        return sqlQuery.toString();
    }

    public static String post(String tableName, List<String> attributesList) {
        StringBuilder sqlQuery = new StringBuilder("INSERT INTO " + SCHEMA + "." + tableName + " VALUES(");
        populateQueryWithAttributes(sqlQuery, attributesList);
        sqlQuery.append(");");
        return sqlQuery.toString();
    }

    public static String update(String tableName, List<String> attributesList, String condition) {
        StringBuilder sqlQuery = new StringBuilder("UPDATE " + SCHEMA + "." + tableName + " SET ");
        populateQueryWithAttributes(sqlQuery, attributesList);
        sqlQuery.append(" WHERE " + condition + ";");
        return sqlQuery.toString();
    }

    public static String delete(String tableName, String condition) {
        return "DELETE FROM " + SCHEMA + "." + tableName + " WHERE " + condition;
    }

    public static String get(String tableName) {
        return "SELECT * FROM " + SCHEMA + "." + tableName;
    }

    public static String findByColumn(String tableName, String condition) {
        return "SELECT * FROM " + tableName + " WHERE " + condition;
    }

    public static String getTablesNames() {
        return "SELECT table_name FROM INFORMATION_SCHEMA.tables WHERE table_schema='" + SCHEMA + "'";
    }

    public static String getTableColumns(String tableName) {
        return "SELECT * FROM postgres.information_schema.columns WHERE table_schema='" + SCHEMA + "' AND table_name='" + tableName + "'";

    }

    private static void populateQueryWithAttributes(StringBuilder sqlQuery, List<String> attributesList) {
        if (attributesList != null) {
            for (int i = 0; i < attributesList.size(); i++) {
                String attribute = attributesList.get(i).replace("-", "");
                sqlQuery.append(attribute);
                if (i != attributesList.size() - 1) {
                    sqlQuery.append(", ");
                }
            }
        }
    }
}