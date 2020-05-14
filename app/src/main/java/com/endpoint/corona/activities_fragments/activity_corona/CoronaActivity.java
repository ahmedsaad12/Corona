package com.endpoint.corona.activities_fragments.activity_corona;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.endpoint.corona.R;
import com.endpoint.corona.adapters.Corona_Adapter;
import com.endpoint.corona.databinding.ActivityCoronaBinding;
import com.endpoint.corona.databinding.DialogResultBinding;
import com.endpoint.corona.models.CoronaDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.prefs.Preferences;


public class CoronaActivity extends AppCompatActivity  {
    private ActivityCoronaBinding binding;
    private LinearLayoutManager manager;
    private List<CoronaDataModel> coronaDataModels;
    private Corona_Adapter corona_adapter;
    private double total=0;
    private double totals=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_corona);
        initView();

    }

    private void initView() {
        manager = new LinearLayoutManager(this);
        binding.recView.setLayoutManager(manager);
        coronaDataModels = new ArrayList<>();
        corona_adapter = new Corona_Adapter(coronaDataModels, this);
        binding.recView.setAdapter(corona_adapter);

        adddata();
binding.btsend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        for(int i=0;i<corona_adapter.getItemCount();i++){
View view=binding.recView.getLayoutManager().getChildAt(i);
            CheckBox checkBox=view.findViewById(R.id.radio);
            if(checkBox.isChecked()){
                totals+=coronaDataModels.get(i).getRate();
            }
        }
        Log.e(";;;",totals+"");
       total=((totals/total)*100);
       CreateCoronaDialog(CoronaActivity.this,total);

    }
});

    }
    public static void CreateCoronaDialog(Context context,double total) {
        final AlertDialog dialog = new AlertDialog.Builder(context)
                .create();

        DialogResultBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_result, null, false);

binding.tvMsg.setText(total+"");
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


            }


        });



        dialog.setCanceledOnTouchOutside(false);
        dialog.setView(binding.getRoot());
        dialog.show();
    }


    private void adddata() {
        coronaDataModels.add(new CoronaDataModel("Do you have anorexia?",10));
        coronaDataModels.add(new CoronaDataModel("Are you experiencing any changes in temperature?",10));
        coronaDataModels.add(new CoronaDataModel("Are you having trouble in  breathing or any chest pains?",10));
        coronaDataModels.add(new CoronaDataModel("Do you have a sore throat?",10));
        coronaDataModels.add(new CoronaDataModel(" Are you having a congestion problem?",10));
        coronaDataModels.add(new CoronaDataModel("You having a problem with your coughing?",10));
        coronaDataModels.add(new CoronaDataModel("How many times do you cough?",10));
        coronaDataModels.add(new CoronaDataModel(" Do you have any nausea or vomiting?",10));
        coronaDataModels.add(new CoronaDataModel(" Do you have any symptoms of renal failure?",10));
        coronaDataModels.add(new CoronaDataModel("What are your suspicious symptoms?",10));

 
 

for(int i=0;i<coronaDataModels.size();i++){
    total+=coronaDataModels.get(i).getRate();
}
        corona_adapter.notifyDataSetChanged();

    }






}
