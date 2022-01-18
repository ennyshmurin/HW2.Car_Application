package com.example.hw2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper {

    public static Context Context;

    public static void StoreData(List<Car> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars );
        editor.putString("cars", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("cars",null);
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Car> cars = new ArrayList<Car>();
            cars.add(new Car(R.drawable.car1,"Porsche","Taycan","2020","250,000"));
            cars.add(new Car(R.drawable.car2,"Lamborgini","Urus","2014","180,000"));
            cars.add(new Car(R.drawable.car3,"Mercedes","G-Wagon","2013","60,000"));
            cars.add(new Car(R.drawable.car4,"Kia","Rio","2022","25,000"));
            cars.add(new Car(R.drawable.car5,"Toyota","Camry","2021","45,000"));
            cars.add(new Car(R.drawable.car6,"Tesla","S","2022","40,000"));
            cars.add(new Car(R.drawable.car7,"BMW","i8","2019","200,000"));
            cars.add(new Car(R.drawable.car8,"Volvo","XC90","2017","100,000"));
            return cars;
        }
    }

}