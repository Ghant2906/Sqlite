package com.example.testsqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ComputerDAO {
    SQLiteDatabase database;

    public ComputerDAO(Context context) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);

        database = databaseHandler.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Computer> get(String sql,String ...selectArgs){
        List<Computer> listComputer = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql,selectArgs);

        while(cursor.moveToNext()){
            Computer computer = new Computer();
            computer.setIdPC(cursor.getInt(cursor.getColumnIndex("idPC")));
            computer.setNamePC(cursor.getString(cursor.getColumnIndex("namePC")));
            computer.setIdCategory(cursor.getInt(cursor.getColumnIndex("idCategory")));

            listComputer.add(computer);
        }
        return listComputer;
    }

    public List<Computer> getAll(){
        String sql = "Select * from computer";
        return get(sql);
    }

    public Computer getComputerById(int id){
        String sql = "select * from computer where idPC = ?";
        List<Computer> list = get(sql, String.valueOf(id));
        return list.get(0);
    }

    public List<Computer> getListComputerByIdCategory(int idCate){
        String sql = "select * from computer where idCategory = ?";
        List<Computer> list = get(sql, String.valueOf(idCate));
        return list;
    }

    public long insert(Computer computer){
        ContentValues values = new ContentValues();
        values.put("idPC",computer.getIdPC());
        values.put("namePC", computer.getNamePC());
        values.put("idCategory", computer.getIdCategory());

        return database.insert("Computer", null, values);
    }

    public long upadte(Computer computer) {
        ContentValues values = new ContentValues();
        values.put("namePC", computer.getNamePC());
        values.put("idCate", computer.getIdCategory());

        return database.update("Computer", values,"idPC=?",new String[]{String.valueOf(computer.getIdPC())});
    }

    public int delete(int id){
        return database.delete("Computer", "idPC=?", new String[] {String.valueOf(id)});
    }
}

