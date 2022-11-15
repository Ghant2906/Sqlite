package com.example.testsqlite;

public class Computer {
    int idPC;
    String namePC;
    int idCategory;

    public Computer(int idPC, String namePC, int idCategory) {
        this.idPC = idPC;
        this.namePC = namePC;
        this.idCategory = idCategory;
    }

    public Computer() {
    }

    public int getIdPC() {
        return idPC;
    }

    public void setIdPC(int idPC) {
        this.idPC = idPC;
    }

    public String getNamePC() {
        return namePC;
    }

    public void setNamePC(String namePC) {
        this.namePC = namePC;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
