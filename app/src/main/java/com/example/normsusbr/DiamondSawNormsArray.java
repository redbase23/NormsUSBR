package com.example.normsusbr;

import java.util.Arrays;
import java.util.HashSet;


public class DiamondSawNormsArray {

    private static DiamondSawNorm [] sawNorms = {
            new DiamondSawNorm(sawMaterials.dry,300,1, normMeasures.m2,0.17, "КЧ-33"),
            new DiamondSawNorm(sawMaterials.beton,450,1, normMeasures.m2,0.027, "КЧ-34"),
            new DiamondSawNorm(sawMaterials.beton,600,1,normMeasures.m2,0.02, "КЧ-36"),
            new DiamondSawNorm(sawMaterials.beton,800,1,normMeasures.m2,0.015, "КЧ-38"),
            new DiamondSawNorm(sawMaterials.beton,900,1,normMeasures.m2,0.013, "КЧ-40"),
            new DiamondSawNorm(sawMaterials.beton,1000,1,normMeasures.m2,0.012, "КЧ-42"),
            new DiamondSawNorm(sawMaterials.beton,1200,1,normMeasures.m2,0.01, "КЧ-44"),
            new DiamondSawNorm(sawMaterials.beton,350,2,normMeasures.m2,0.068, "КЧ-46"),
            new DiamondSawNorm(sawMaterials.beton,350,3,normMeasures.m2,0.102, "КЧ-48"),
            new DiamondSawNorm(sawMaterials.asphalt,450,1,normMeasures.m2,0.008, "КЧ-50"),
            new DiamondSawNorm(sawMaterials.asphalt,500,1,normMeasures.m2,0.007, "КЧ-51"),
            new DiamondSawNorm(sawMaterials.asphalt,600,1,normMeasures.m2,0.006, "КЧ-52"),
            new DiamondSawNorm(sawMaterials.asphalt,700,1,normMeasures.m2,0.0055, "КЧ-53"),
            new DiamondSawNorm(sawMaterials.asphalt,800,1,normMeasures.m2,0.005, "КЧ-54"),
            new DiamondSawNorm(sawMaterials.asphalt,900,1,normMeasures.m2,0.0045, "КЧ-55"),
            new DiamondSawNorm(sawMaterials.asphalt,1000,1,normMeasures.m2,0.004, "КЧ-56"),
            new DiamondSawNorm(sawMaterials.asphalt,450,2,normMeasures.m2,0.016, "КЧ-57"),
            new DiamondSawNorm(sawMaterials.asphalt,450,3,normMeasures.m2,0.024, "КЧ-58"),
            new DiamondSawNorm(sawMaterials.greenbeton,350,1,normMeasures.m2,0.008, "КЧ-59"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,350,1,normMeasures.m2,0.008, "КЧ-59"),
            new DiamondSawNorm(sawMaterials.greenbeton,450,1,normMeasures.m2,0.007, "КЧ-61"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,450,1,normMeasures.m2,0.007, "КЧ-61"),
            new DiamondSawNorm(sawMaterials.greenbeton,600,1,normMeasures.m2,0.005, "КЧ-63"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,600,1,normMeasures.m2,0.005, "КЧ-63"),
            new DiamondSawNorm(sawMaterials.greenbeton,700,1,normMeasures.m2,0.0045, "КЧ-65"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,700,1,normMeasures.m2,0.0045, "КЧ-65"),
            new DiamondSawNorm(sawMaterials.greenbeton,800,1,normMeasures.m2,0.004, "КЧ-67"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,800,1,normMeasures.m2,0.004, "КЧ-67"),
            new DiamondSawNorm(sawMaterials.greenbeton,900,1,normMeasures.m2,0.0035, "КЧ-69"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,900,1,normMeasures.m2,0.0035, "КЧ-69"),
            new DiamondSawNorm(sawMaterials.greenbeton,1000,1,normMeasures.m2,0.003, "КЧ-70"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,1000,1,normMeasures.m2,0.003, "КЧ-70"),
            new DiamondSawNorm(sawMaterials.greenbeton,350,2,normMeasures.m2,0.014, "КЧ-71"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,350,2,normMeasures.m2,0.014, "КЧ-71"),
            new DiamondSawNorm(sawMaterials.greenbeton,350,3,normMeasures.m2,0.021, "КЧ-73"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,450,3,normMeasures.m2,0.021, "КЧ-73"),
            new DiamondSawNorm(sawMaterials.greenbeton,450,2,normMeasures.m2,0.012, "КЧ-75"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,450,2,normMeasures.m2,0.012, "КЧ-75"),
            new DiamondSawNorm(sawMaterials.greenbeton,450,3,normMeasures.m2,0.018, "КЧ-77"),
            new DiamondSawNorm(sawMaterials.lowgradebeton,450,3,normMeasures.m2,0.018, "КЧ-77"),
            new DiamondSawNorm(sawMaterials.facet,230,2,normMeasures.pm,0.0002, "КЧ-75")

    };

    //поиск нормы
    public static DiamondSawNorm getNorm (String material, int countDisks, int diameter){
        for (DiamondSawNorm norm:sawNorms){
            if(norm.getSawMaterial().equals(material)&&norm.getCountDisks()==countDisks&&norm.getDiameter()==diameter){
                return norm;
            }
        }
        return new DiamondSawNorm(sawMaterials.beton,450,1,normMeasures.m2,0, "КЧ-?");
    }

    //получение массива всех норм
    public static DiamondSawNorm[] getAllNorms() {
        return sawNorms;
    }

    //получение массива норм согласно типа нарезаемого материала
    public static DiamondSawNorm [] sawNormsbyMaterial(String material){
        int count=0;
        DiamondSawNorm[] sawNormsTemporary = new DiamondSawNorm[sawNorms.length];

        for (int i=0; i<sawNorms.length;i++){
            if(sawNorms[i].getSawMaterial().equals(material)){
                sawNormsTemporary[count]=sawNorms[i];
                count++;
            }
        }
        DiamondSawNorm[] sawNormsSelection = new DiamondSawNorm[count];
        for(int i=0; i<count;i++){
            sawNormsSelection[i]=sawNormsTemporary[i];
        }

        return sawNormsSelection;
    }

    //получение массива норм согласно типа нарезаемого материало и типа нарезки
    public static DiamondSawNorm [] sawNormsbyMaterialAndCountDisks(String material, int countDisks){
        int count=0;
        DiamondSawNorm[] sawNormTemporary = new DiamondSawNorm[sawNorms.length];

        for(int i=0;i< sawNorms.length;i++){
            if(sawNorms[i].getSawMaterial().equals(material)&&sawNorms[i].getCountDisks()==countDisks){
                sawNormTemporary[count]=sawNorms[i];
                count++;
            }
        }
        DiamondSawNorm[] sawNormSelection = new DiamondSawNorm[count];
        for(int i=0;i<count;i++){
            sawNormSelection[i]=sawNormTemporary[i];
        }
        return sawNormSelection;
    }


    //получение массива названий из массива материалов
    public static String[] getSawMaterials(DiamondSawNorm[]putArray){
        String [] normString = new String[putArray.length];

        //массив значений из всех норм
        for (int i=0;i<normString.length;i++){
            normString[i]=putArray[i].getSawMaterial();
        }

        //получение массива уникальных значений и саортировка
         String [] sawMatrialsUnique= new HashSet<String>(Arrays.asList(normString)).toArray(new String[0]);
        Arrays.sort(sawMatrialsUnique);

        return sawMatrialsUnique;
    }

    //получение массива типа нарезки (кол-ва дисков) из массива материалов
    public static int[]getTypes(DiamondSawNorm[]putArray){
        Integer [] typesAll = new Integer[putArray.length];

        //массив значений из всех норм
        for (int i=0;i<typesAll.length;i++){
            typesAll[i]=putArray[i].getCountDisks();
        }
        //получение массива уникальных значений и сортировка
        Integer [] typesUnigueInteger = new HashSet<Integer>(Arrays.asList(typesAll)).toArray(new Integer[0]);
        int [] typesUnigue_int = new int[typesUnigueInteger.length];
        for(int i=0;i<typesUnigueInteger.length;i++){
            typesUnigue_int[i]=typesUnigueInteger[i];
        }

        Arrays.sort(typesUnigue_int);

        return typesUnigue_int;
    }

    //получение массив диаметров дисков из массива материалов
    public static int [] getDiameters(DiamondSawNorm[]putArray){
        Integer [] diametersAll = new Integer[putArray.length];

        //массив значений из всех норм
        for(int i=0;i<diametersAll.length;i++){
            diametersAll[i]=putArray[i].getDiameter();
        }
        //получение массива уникальных значений и сортировка
        Integer [] typesUnigueInteger = new HashSet<Integer>(Arrays.asList(diametersAll)).toArray(new Integer[0]);
        int [] typesUnigue_int = new int[typesUnigueInteger.length];
        for(int i=0;i<typesUnigueInteger.length;i++){
            typesUnigue_int[i]=typesUnigueInteger[i];
        }

        Arrays.sort(typesUnigue_int);

        return typesUnigue_int;
    }
}
