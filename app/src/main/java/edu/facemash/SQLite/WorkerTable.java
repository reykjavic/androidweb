package edu.facemash.SQLite;

class WorkerTable extends Table {

    WorkerTable() {
        this.setFields(5);
        this.setName("worker");
        this.addField(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT", null);
        this.addField(1, "NAME", "TEXT", null);
        this.addField(2, "SURNAME", "TEXT", null);
        this.addField(3, "DEPARTMENT", "TEXT", null);
        this.addField(4, "PHONE", "TEXT", null);
    }
}
