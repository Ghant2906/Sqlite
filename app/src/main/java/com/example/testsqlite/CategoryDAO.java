package com.example.testsqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    SQLiteDatabase database;

    public CategoryDAO(Context context) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);

        database = databaseHandler.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Category> get(String sql,String ...selectArgs){
        List<Category> listCategory = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql,selectArgs);

        while(cursor.moveToNext()){
            Category category = new Category();
            category.setIdCategory(cursor.getInt(cursor.getColumnIndex("idCategory")));
            category.setNameCategory(cursor.getString(cursor.getColumnIndex("nameCategory")));

            listCategory.add(category);
        }
        return listCategory;
    }

    public List<Category> getAll(){
        String sql = "Select * from category";
        return get(sql);
    }

    public Category getCategoryById(int id){
        String sql = "select * form category where idCategory = ?";
        List<Category> list = get(sql, String.valueOf(id));
        return list.get(0);
    }

    public long insert(Category category){
        ContentValues values = new ContentValues();
        values.put("idCategory", category.getIdCategory());
        values.put("nameCategory", category.getNameCategory());

        return database.insert("Category", null, values);
    }

    public long upadte(Category category) {
        ContentValues values = new ContentValues();
        values.put("namCategory", category.getNameCategory());

        return database.update("Category", values,"idCategory=?",new String[]{String.valueOf(category.getIdCategory())});
    }

    public int delete(int id){
        return database.delete("Category", "idCategory=?", new String[] {String.valueOf(id)});
    }
}
