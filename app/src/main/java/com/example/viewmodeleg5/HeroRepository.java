package com.example.viewmodeleg5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroRepository {

    public LiveData<List<HeroModel>> getheromodellistfromApi()
    {
         final MutableLiveData<List<HeroModel>> herolist=new MutableLiveData<>();

        Apicalls apicalls=RetrofitObj.getRetrofit().create(Apicalls.class);
        final Call<List<HeroModel>> heromodellist=apicalls.getHeroList();
        heromodellist.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                List<HeroModel> heroModels=response.body();
                herolist.setValue(heroModels);
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {

            }
        });
        return herolist;
    }
}
