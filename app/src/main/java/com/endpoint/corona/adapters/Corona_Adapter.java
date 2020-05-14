package com.endpoint.corona.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.endpoint.corona.R;
import com.endpoint.corona.databinding.CoronaRowBinding;
import com.endpoint.corona.models.CoronaDataModel;


import java.util.List;
import java.util.Locale;


public class Corona_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CoronaDataModel> orderlist;
    private Context context;
    private LayoutInflater inflater;


    public Corona_Adapter(List<CoronaDataModel> orderlist, Context context) {
        this.orderlist = orderlist;
        this.context = context;
        inflater = LayoutInflater.from(context);
   }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            CoronaRowBinding binding  = DataBindingUtil.inflate(inflater, R.layout.corona_row,parent,false);
            return new EventHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

            EventHolder eventHolder = (EventHolder) holder;
           // eventHolder.binding.setLang(lang);

            eventHolder.binding.setCoronaModel(orderlist.get(position));




    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder {
        public CoronaRowBinding binding;
        public EventHolder(@NonNull CoronaRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
