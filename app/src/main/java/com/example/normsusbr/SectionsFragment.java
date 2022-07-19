package com.example.normsusbr;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SectionsFragment extends Fragment {

    private RecyclerView titlesRecyclerView;
    private Button searchButton;
    private EditText searchEditText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //указываем что имеет меню
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_sections,container,false);
        titlesRecyclerView = (RecyclerView) view.findViewById(R.id.titles_recycler_view);
        titlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        SectionsRecyclerAdapter sectionsRecyclerAdapter =
                 new SectionsRecyclerAdapter(Sections.getAllSections());

        sectionsRecyclerAdapter.setListener(new SectionsRecyclerAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = SectionNormActivity.newIntent(getActivity(),position);
                getActivity().startActivity(intent);
            }
        });

        titlesRecyclerView.setAdapter(sectionsRecyclerAdapter);

        searchButton = (Button)view.findViewById(R.id.search_button_by_number);
        searchEditText = (EditText)view.findViewById(R.id.search_edit_text);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int controlNumber =Integer.parseInt(searchEditText.getText().toString());
                if (controlNumber>0&&controlNumber<=NormsArray.getAllNorms().length){
                    Intent intent = DetailsActivity.newIntent(getActivity(),controlNumber);
                    getActivity().startActivity(intent);
                } else {
                    searchEditText.setText(null);
                    Toast toast = Toast.makeText(getActivity(),getString(R.string.Norm_is_not_found),Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            }
        });
        return view;
    }

    //создание панели инструментов
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.title_menu,menu);
    }

    //реакция на нажатия элементов меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.developer_item:
                Intent intent = new Intent(getActivity(),DeveloperActivity.class);
                getActivity().startActivity(intent);
                return true;
            case R.id.saw_diamond_item:
                Intent intent_1 = new Intent(getActivity(),DiamondSawActivity.class);
                getActivity().startActivity(intent_1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
