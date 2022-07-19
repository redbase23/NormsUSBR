package com.example.normsusbr;
/*
адаптер для заполнения списка норм конкретного раздела
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class SectionNormRecyclerAdapter
        extends RecyclerView.Adapter<SectionNormRecyclerAdapter.ViewHolder> {
    private int positionSection;
    private Norm[] sectionNorms;
    private Listener listener;

    //интерфейс для привязки листнера на нажатия
    interface Listener{
        void onClick(int controlNumber);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    //конструктор адаптера
    public SectionNormRecyclerAdapter (int positionSection){
        this.positionSection =positionSection;
    }

    @Override
    public SectionNormRecyclerAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_norm_name_item,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        TextView textView = (TextView)cardView.findViewById(R.id.norm_name);
        textView.setText(sectionNorms[position].getName());
        TextView numberView = (TextView)cardView.findViewById(R.id.norm_number);
        numberView.setText(Integer.toString(sectionNorms[position].getControl_number()));

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(listener!=null){
                    int controlNumber = sectionNorms[position].getControl_number();
                    listener.onClick(controlNumber);
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        sectionNorms = NormsArray.getSectionNorms(Sections.allSections[positionSection]);
        return sectionNorms.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public ViewHolder (CardView view){
            super(view);
            cardView = view;
        }
    }
}
