package com.example.countries.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.countries.R;
import com.example.countries.adapter.CountryAdapter;
import com.example.countries.api.API;
import com.example.countries.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private ArrayList<Country> mCountryList = new ArrayList<Country>();
    private RecyclerView mRlRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //to initialize recycler view
        initRecycler();

        //to check if data already exists then read otherwise write
        if(!Paper.book().contains(getString(R.string.countries))){
            getCountryApi();
        }else{
            mCountryList=Paper.book().read(getString(R.string.countries));
            mRlRecyclerView.setAdapter(new CountryAdapter(mCountryList));
        }
     }
    //method to get API of country using Retrofit
    private void getCountryApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API myAPI = retrofit.create(API.class);

        Call<List<Country>> call = myAPI.getCountry();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                List<Country> country = response.body();
                //writing data to database
                Paper.book().write(getString(R.string.countries), country);
                for(int i=0;i<country.size();i++) {
                    Log.i(getString(R.string.country_name), country.get(i).getCountryName());
                }
                //setting adapter to recycler view
                mRlRecyclerView.setAdapter(new CountryAdapter(country));
            }
            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }
        });
    }
    //method to initialize recycler view
    private void initRecycler(){
            mRlRecyclerView =  findViewById(R.id.rv_recycler_view);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRlRecyclerView.setLayoutManager(mLayoutManager);
            mRlRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
            mRlRecyclerView.setHasFixedSize(true);
        }
    }

