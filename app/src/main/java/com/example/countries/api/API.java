package com.example.countries.api;

import com.example.countries.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    //URL to fetch data
    static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    //fetch only naes of countries
    @GET("all?fields=name")
    Call<List<Country>> getCountry();
}
