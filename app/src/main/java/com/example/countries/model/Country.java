package com.example.countries.model;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    public String mCountryName;

    /*
    *@param mCountryName - name of the country
    */
    public Country(String mCountryName){
        this.mCountryName=mCountryName;

    }
    /*
    *@return - name of the country
    */
    public String getCountryName() {
        return mCountryName;
    }

}//end of Country class
