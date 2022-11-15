package com.example.testsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CategoryAdapter categoryAdapter;
    private ListView lvCategory;
    private CategoryDAO categoryDAO;
    private List<Category> listCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategory = findViewById(R.id.listViewCategory);

        categoryDAO = new CategoryDAO(this);
        ComputerDAO computerDAO = new ComputerDAO(this);

        Category category = new Category();
        category.setIdCategory(1);
        category.setNameCategory("a");
        categoryDAO.insert(category);
        category.setIdCategory(2);
        category.setNameCategory("b");
        categoryDAO.insert(category);

        Computer computer = new Computer();
        computer.setIdPC(1);
        computer.setNamePC("PC1");
        computer.setIdCategory(1);
        computerDAO.insert(computer);
        computer.setIdPC(2);
        computer.setNamePC("PC2");
        computer.setIdCategory(1);
        computerDAO.insert(computer);
        computer.setIdPC(3);
        computer.setNamePC("PC1");
        computer.setIdCategory(2);
        computerDAO.insert(computer);
        computer.setIdPC(4);
        computer.setNamePC("PC2");
        computer.setIdCategory(2);
        computerDAO.insert(computer);

        listCategory = categoryDAO.getAll();
        categoryAdapter = new CategoryAdapter(this, listCategory);
        lvCategory.setAdapter(categoryAdapter);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                List<Computer> computerList;
                ComputerDAO computerDAO1 = new ComputerDAO(view.getContext());
                ComputerAdapter computerAdapter;

                computerList = computerDAO1.getListComputerByIdCategory(listCategory.get(position).getIdCategory());
                computerAdapter = new ComputerAdapter(view.getContext(),computerList);
                lvCategory.setAdapter(computerAdapter);
            }
        });

    }
}