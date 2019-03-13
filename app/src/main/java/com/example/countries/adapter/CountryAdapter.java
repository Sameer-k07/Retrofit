package com.example.countries.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.countries.R;
import com.example.countries.model.Country;

import java.util.List;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private List<Country> mCountry;

    public CountryAdapter(List<Country> country) {
        this.mCountry = country;
    }
    //to create view
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup,
                false);

        return new MyViewHolder(itemView);
    }
    public void setAdpaterData(List<Country> country) {
        this.mCountry = country;
        notifyDataSetChanged();
    }
    //to bind the data with view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Country student = mCountry.get(i);
        MyViewHolder viewHolder = (MyViewHolder) myViewHolder;
        viewHolder.mCountryName.setText(student.getCountryName());

    }

    @Override
    public int getItemCount() {
        return mCountry==null ? 0:mCountry.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mCountryName;

        public MyViewHolder(View view) {
            super(view);
            mCountryName = view.findViewById(R.id.tv_country_name);
        }
    }

}

