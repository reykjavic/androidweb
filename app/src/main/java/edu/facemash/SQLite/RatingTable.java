package edu.facemash.SQLite;

class RatingTable extends Table {

    RatingTable() {
        this.setFields(3);
        this.setName("rating");
        this.addField(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT", null);
        this.addField(1, "WORKER_ID", "INTEGER", null);
        this.addField(2, "VALUE", "TEXT", null);
    }
}
