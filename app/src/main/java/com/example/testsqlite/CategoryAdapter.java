package com.example.testsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Context context;
    List<Category> listCategory;

    public CategoryAdapter(Context context, List<Category> listCategory) {
        this.context = context;
        this.listCategory = listCategory;
    }

    @Override
    public int getCount() {
        return listCategory.size();
    }

    @Override
    public Object getItem(int position) {
        return listCategory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_category, null);
        }

        TextView textViewID = convertView.findViewById(R.id.textViewIdCate);
        TextView textViewName = convertView.findViewById(R.id.textViewNameCate);

        Category category = listCategory.get(position);
        textViewID.setText("" + category.getIdCategory());
        textViewName.setText((category.getNameCategory()));

        return convertView;
    }
}
