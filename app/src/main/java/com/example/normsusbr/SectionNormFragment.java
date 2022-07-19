package com.example.normsusbr;
/*
Фрагмент для вывода норм конкретного раздела
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SectionNormFragment extends Fragment {

    public static final String ARG_SECTION_NORM="com.example.normsusbr.section_norm_fragment";
    private RecyclerView sectionNormRecyclerView;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_section_norm,container,false);
        sectionNormRecyclerView = (RecyclerView)view.findViewById(R.id.section_norm_recycler_view);
        sectionNormRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        SectionNormRecyclerAdapter sectionNormRecyclerAdapter =
                new SectionNormRecyclerAdapter(getArguments().getInt(ARG_SECTION_NORM));

        sectionNormRecyclerAdapter.setListener(new SectionNormRecyclerAdapter.Listener() {
            @Override
            public void onClick(int controlNumber) {
                Intent intent = DetailsActivity.newIntent(getActivity(),controlNumber);
                getActivity().startActivity(intent);
            }
        });
        sectionNormRecyclerView.setAdapter(sectionNormRecyclerAdapter);

        return view;
    }

    //создание фрагмента с присоединенными аргументами
    public static SectionNormFragment newInstance (int position){
        //присоединение аргументов к фрагменту при создании
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NORM,position);

        SectionNormFragment fragment = new SectionNormFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
