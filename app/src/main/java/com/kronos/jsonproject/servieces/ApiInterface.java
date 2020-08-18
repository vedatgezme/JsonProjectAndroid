package com.kronos.jsonproject.servieces;

import com.kronos.jsonproject.model.ModelClass;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("vedatgezme/jsonProject/master/last_user.json")
    Observable<List<ModelClass>> getData();

    /*
    @GET("vedatgezme/jsonProject/master/users_json.json")
    Call<List<ModelClass>> getData();
    */


}
