package com.example.normsusbr;
/*
фрагмент поиска нормы на алмазный инструмент
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class DiamondSawFragment extends Fragment {

    private String sawMaterial;
    private int countDisks;
    private int diameter;

    private Spinner saw_material_spinner;
    private Spinner count_disks_spinner;
    private Spinner diameter_spinner;
    private TextView norm_name_text_view;
    private TextView norm_measure_text_view;
    private TextView material_consumption_text_view;

    private Button show_norm_button;

    //создание фрагмента
    public static DiamondSawFragment newInstance (){
        return new DiamondSawFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater
                                         inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diamond_saw,container,false);
        saw_material_spinner = (Spinner)view.findViewById(R.id.saw_material);
        count_disks_spinner = (Spinner)view.findViewById(R.id.saw_type);
        diameter_spinner = (Spinner) view.findViewById(R.id.saw_diameter);
        material_consumption_text_view =(TextView)view.findViewById(R.id.material_consumption);
        norm_measure_text_view =(TextView)view.findViewById(R.id.norm_measure);
        norm_name_text_view =(TextView)view.findViewById(R.id.Norm_name);



        setupSawMaterialSpinner();
        saw_material_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateTypeSpinner();
                hideNorm();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        } );

        count_disks_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateDiameterSpinner();
                hideNorm();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        diameter_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showNorm();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    //очистить показ нормы
    private void hideNorm() {
        material_consumption_text_view.setText(null);
        material_consumption_text_view.setText(null);
        norm_name_text_view.setText(null);
    }

    //вывести норму
    private void showNorm() {
        diameter = updateDiameterVariable();

        DiamondSawNorm norm = DiamondSawNormsArray.getNorm(
                sawMaterial,
                countDisks,
                diameter
        );

        String nameNorm = getString(R.string.norm_number)+" "+norm.getNormNumber();
        norm_name_text_view.setText(nameNorm);

        String measureNorm=norm.getMeasure();
        if (measureNorm.equals("m2")){
            measureNorm = getString(R.string.measure)+": "+getString(R.string.m2);

        } else if(measureNorm.equals("pm")){
            measureNorm = getString(R.string.measure)+": "+getString(R.string.p_m_);
        }
        norm_measure_text_view.setText(measureNorm);

        double consumption = norm.getConsumption();
        //создание строки с отображением типа double в нужном формате
        int lenghtAfterComma = String.valueOf(consumption).split("\\.")[1].length();
        String consumptionStr =getString(R.string.consumption)+" "+
                String.format("%."+lenghtAfterComma+"f",consumption);
        material_consumption_text_view.setText(consumptionStr);

    }

    //установка списка нарезаемых материалов
    public void setupSawMaterialSpinner(){
        //получение массива названий нарезаемого материала в соответсвии с локализацией
        String []saw_materials_array =
                DiamondSawNormsArray.getSawMaterials(DiamondSawNormsArray.getAllNorms());

        for (int i=0;i<saw_materials_array.length;i++){
            switch (saw_materials_array[i]){
                case "asphalt":
                    saw_materials_array[i]=getString(R.string.asphalt);
                    break;
                case "beton":
                    saw_materials_array[i]=getString(R.string.beton);
                    break;
                case "greenbeton":
                    saw_materials_array[i]=getString(R.string.green_beton);

                    break;
                case "lowgradebeton":
                    saw_materials_array[i]=getString(R.string.low_grade_beton);
                    break;

                case "dry":
                    saw_materials_array[i]=getString(R.string.dry);
                    break;

                case "facet":
                    saw_materials_array[i]=getString(R.string.facet);
            }
        }
        //внечение в выпадающий список названий нарезаемых материалов
        saw_material_spinner.setAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                saw_materials_array
        ));
    }

    //обновление списка типов нарезки
    public void updateTypeSpinner(){
        updateMaterialVariable();

        int[] types_int = DiamondSawNormsArray.getTypes(DiamondSawNormsArray.sawNormsbyMaterial(sawMaterial));

        String [] types_string = new String[types_int.length];

        for(int i=0; i<types_int.length;i++){
            switch (types_int[i]){
                case 1:
                    types_string[i]=getString(R.string.single_cut);
                    break;
                case 2:
                    types_string[i]=getString(R.string.sandwich_two);
                    break;
                case 3:
                    types_string[i]=getString(R.string.sandwich_three);
                    break;
                case 4:
                    types_string[i]=getString(R.string.sandwich_four);
                    break;
                case 5:
                    types_string[i]=getString(R.string.sandwich_five);
                    break;
                case 6:
                    types_string[i]=getString(R.string.sandwich_six);
                    break;
                case 7:
                    types_string[i]=getString(R.string.sandwich_seven);
                    break;
                case 8:
                    types_string[i]=getString(R.string.sandwich_eight);
                    break;
                default:
                    types_string[i]=Integer.toString(types_int[i]);
            }
        }

        count_disks_spinner.setAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                types_string
        ));
    }

    //обновление доступных диаметров нарезки
    public void updateDiameterSpinner(){
        updateCountDisksVariable();

        int [] diametersInt = DiamondSawNormsArray.getDiameters
                (DiamondSawNormsArray.sawNormsbyMaterialAndCountDisks(sawMaterial,countDisks));
        String [] diametersString = new String[diametersInt.length];
        for (int i=0;i<diametersString.length;i++){
            diametersString[i]=Integer.toString(diametersInt[i]);
        }

        diameter_spinner.setAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                diametersString
        ));
    }

    //получение нарезаемого материлал из списка
    private void updateMaterialVariable() {
        if (saw_material_spinner.getSelectedItem().toString().equals(getString(R.string.asphalt))){
            sawMaterial = "asphalt";
        }else if(saw_material_spinner.getSelectedItem().toString().equals(getString(R.string.beton))){
            sawMaterial = "beton";
        }else if(saw_material_spinner.getSelectedItem().toString().equals(getString(R.string.green_beton))){
            sawMaterial = "greenbeton";
        }else if(saw_material_spinner.getSelectedItem().toString().equals(getString(R.string.low_grade_beton))){
            sawMaterial = "lowgradebeton";
        }else if(saw_material_spinner.getSelectedItem().toString().equals(getString(R.string.dry))){
            sawMaterial = "dry";
        }else if(saw_material_spinner.getSelectedItem().toString().equals(getString(R.string.facet))){
            sawMaterial = "facet";
        }
    }

    //получение кол-ва дисков из списка
    private void updateCountDisksVariable() {
        if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.single_cut))){
            countDisks=1;
        } else if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.sandwich_two))){
            countDisks=2;
        } else if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.sandwich_three))){
            countDisks=3;
        }else if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.sandwich_four))){
            countDisks=4;
        }else if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.sandwich_five))){
            countDisks=5;
        }else if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.sandwich_six))){
            countDisks=6;
        }else if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.sandwich_seven))){
            countDisks=7;
        }else if(count_disks_spinner.getSelectedItem().toString().equals(getString(R.string.sandwich_eight))){
            countDisks=8;
        }
    }

    //получение диаметра из списка
    private int updateDiameterVariable() {
        return Integer.parseInt(diameter_spinner.getSelectedItem().toString());
    }


}
