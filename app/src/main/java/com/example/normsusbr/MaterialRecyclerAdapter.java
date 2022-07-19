package com.example.normsusbr;
/*
адаптер для заполнения списка материалов конкретной нормы
 */

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MaterialRecyclerAdapter extends
        RecyclerView.Adapter<MaterialRecyclerAdapter.ViewHolder>{
    private int controlNumber;
    private Material [] materials;


    //конструктор адаптера
    public MaterialRecyclerAdapter(int controlNumber){
        this.controlNumber=controlNumber;
    }

    @Override
    public MaterialRecyclerAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_material,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.cardView;

        TextView name_material =(TextView)cardView.findViewById(R.id.name_material);
        name_material.setText(materials[position].getName());

        TextView measure_material =(TextView)cardView.findViewById(R.id.measure_material);
        measure_material.setText(materials[position].getMeasure());

        TextView norm_material = (TextView)cardView.findViewById(R.id.norm_material);
        //создание строки с отображением типа double в нужном формате
        double requirement = materials[position].getRequirement();
        int lengthAfterComma = String.valueOf(requirement).split("\\.")[1].length();
        norm_material.setText(String.format("%."+lengthAfterComma+"f",requirement));

    }

    @Override
    public int getItemCount(){
        materials=NormsArray.getNorm(controlNumber).getMaterialsRequirement();
        return  materials.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder (CardView view){
            super(view);
            cardView = view;
        }
    }
}
