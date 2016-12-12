package edu.facemash.SQLite;

class WorkerTable extends Table {

    WorkerTable() {
        this.setFields(5);
        this.setName("worker");
        this.addField(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT", null);
        this.addField(1, "DATA", "TEXT", null);
    }
}

