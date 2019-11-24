package com.example.viewmodeleg5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apicalls {
    @GET("marvel")
    Call<List<HeroModel>> getHeroList();
}
