package edu.facemash.SQLite;

abstract class Table {

    private String name = "";
    private Field[] fields;

    String getStructure() {
        String query = "CREATE TABLE " + this.getName() + " (";

        // sql query concat names and types and close accordingly
        for (int i = 0; i < this.fields.length ; i++) {
            query += fields[i].getName() + " " + fields[i].getType();

            if (i + 1 < this.fields.length) {
                query += ", ";
            } else {
                query += ");";
            }
        }

        return query;
    }

    String[] getColumns()
    {
        String[] columns = new String [fields.length];

        // push column names to array
        for (int i = 0; i < this.fields.length ; i++) {
            columns[i] = fields[i].getName();
        }

        return columns;
    }

    void setFields(int count) {
        this.fields = new Field[count];
    }

    String getDrop() {
        return "DROP TABLE IF EXISTS " + this.getName();
    }

    void addField(int index, String name, String type, String value) {
        this.fields[index] = new Field(name, type, value);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Field[] getFields() {
        return fields;
    }
    public void setFields(Field[] fields) {
        this.fields = fields;
    }
}
