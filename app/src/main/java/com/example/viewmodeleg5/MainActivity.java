package com.example.viewmodeleg5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain=findViewById(R.id.rvMain);
rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
rvMain.setHasFixedSize(true);
        HeroViewModel hvm= ViewModelProviders.of(this).get(HeroViewModel.class);
        hvm.storeHeroModelLiveData().observe(this, new Observer<List<HeroModel>>() {
            @Override
            public void onChanged(List<HeroModel> heroModels) {
rvMain.setAdapter(new HeroAdapter(heroModels));
            }
        });
    }
}
