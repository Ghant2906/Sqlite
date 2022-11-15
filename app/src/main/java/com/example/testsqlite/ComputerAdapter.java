package com.example.testsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ComputerAdapter extends BaseAdapter {

    Context context;
    List<Computer> listComputer;

    public ComputerAdapter(Context context, List<Computer> listComputer) {
        this.context = context;
        this.listComputer = listComputer;
    }

    @Override
    public int getCount() {
        return listComputer.size();
    }

    @Override
    public Object getItem(int position) {
        return listComputer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_computer, null);
        }

        TextView textViewIDPC = convertView.findViewById(R.id.textViewIDPC);
        TextView textViewNamePC = convertView.findViewById(R.id.textViewNAMEPC);
        TextView textViewIDCATE = convertView.findViewById(R.id.textViewIDCATEGORY);

        Computer computer = listComputer.get(position);
        textViewIDPC.setText("" + computer.getIdPC());
        textViewNamePC.setText((computer.getNamePC()));
        textViewIDCATE.setText(""+ computer.getIdCategory());

        return convertView;
    }
}
