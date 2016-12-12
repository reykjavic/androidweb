package edu.facemash.SQLite;

class Field {

    private String Name;
    private String Type;
    private String Value;

    Field(String name, String type, String value) {
        Name = name;
        Type = type;
        Value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
