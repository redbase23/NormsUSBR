package com.example.normsusbr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class SectionsRecyclerAdapter extends RecyclerView.Adapter<SectionsRecyclerAdapter.ViewHolder> {
    private String[] sections;
    private Listener listener;

    //интерфейс для привязки листнера на нажатия
    interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public SectionsRecyclerAdapter(String[]sections){
        this.sections = sections;
    }

    @Override
    public int getItemCount(){
        return sections.length;
    }

    @Override
    public SectionsRecyclerAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_section_item,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        CardView cardView = holder.cardView;
        TextView textView = (TextView)cardView.findViewById(R.id.section_text_view);
        textView.setText(sections[position]);
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(listener!=null){
                    listener.onClick(position);
                }
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public ViewHolder(CardView view){
            super(view);
            cardView = view;
        }
    }

}
