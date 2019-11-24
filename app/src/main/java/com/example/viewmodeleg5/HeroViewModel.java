package com.example.viewmodeleg5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class HeroViewModel extends ViewModel {


private LiveData<List<HeroModel>> heroModelLiveData;
private HeroRepository repository=new HeroRepository();

public LiveData<List<HeroModel>> storeHeroModelLiveData()
{
if(heroModelLiveData==null)
{
    heroModelLiveData=repository.getheromodellistfromApi();
}
return heroModelLiveData;
}

}
