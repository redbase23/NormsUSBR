package com.example.normsusbr;
/*
Фрагмент для вывода конкретной нормы
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsFragment extends Fragment {

    public static final String ARG_DETAILS = "com.example.normsusbr.details_fragment";
    private TextView numberNorm;
    private TextView nameNorm;
    private TextView measureNorm;
    private RecyclerView materialsRecyclerView;
    private Norm norm;

    //создание фрагмента с присоединенными аргументами
    public static DetailsFragment newInstance (int controlNumber){
        //присоединение аргументов к фрагменту при создании
        Bundle args = new Bundle();
        args.putInt(ARG_DETAILS,controlNumber);

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        norm=NormsArray.getNorm(getArguments().getInt(ARG_DETAILS,1));
        setHasOptionsMenu(true); //указывает что имеет меню
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);

        numberNorm = (TextView)view.findViewById(R.id.number);
        numberNorm.setText("# "+Integer.toString(norm.getControl_number()));

        nameNorm = (TextView)view.findViewById(R.id.name);
        nameNorm.setText(norm.getName());

        measureNorm = (TextView) view.findViewById(R.id.measure);
        measureNorm.setText(getString(R.string.measure)+": "+norm.getMeasure());

        materialsRecyclerView = (RecyclerView)view.findViewById(R.id.materials);
        materialsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MaterialRecyclerAdapter adapter =
                new MaterialRecyclerAdapter(getArguments().getInt(ARG_DETAILS));

        materialsRecyclerView.setAdapter(adapter);

        return view;
    }

    //создание панели инструментов
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.details_menu,menu);
    }

    //реакция на нажатия элементов меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.to_main:
                Intent intent = new Intent(getActivity(),MainActivity.class);
                getActivity().startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
