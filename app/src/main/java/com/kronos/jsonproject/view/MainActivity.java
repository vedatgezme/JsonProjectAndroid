package com.kronos.jsonproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kronos.jsonproject.adapter.Adapter;
import com.kronos.jsonproject.model.ModelClass;
import com.kronos.jsonproject.R;
import com.kronos.jsonproject.servieces.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModelClass> MODEL;
//    private String BASE_URL ="https://api.nomics.com/1/";
    private String BASE_URL ="https://raw.githubusercontent.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    Adapter adapter;
    CompositeDisposable com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ModelClass modelClass = new ModelClass();

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        LoadObservable();




        /*

                Load with CALL
                LoadData();
                 retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        */


    }


    private void LoadObservable()
    {
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        com = new CompositeDisposable();
        com.add(apiInterface.getData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handler)
        );



    }

    private void handler(List<ModelClass> modelClasses)
    {
        MODEL= new ArrayList<>(modelClasses);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new Adapter(MODEL);
        recyclerView.setAdapter(adapter);


    }


    /*
     CALL Method

    private void LoadData()
    {
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<ModelClass>> call = apiInterface.getData();

        call.enqueue(new Callback<List<ModelClass>>()
        {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                if(response.isSuccessful())
                {
                    List<ModelClass> responseList = response.body();

                    modelClasses = new ArrayList<>(responseList);

                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter = new Adapter(modelClasses);
                    recyclerView.setAdapter(adapter);

                    for(ModelClass modelClass : modelClasses)
                    {
                        System.out.println(modelClass.currency +" : "+modelClass.price);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

            }
        });

    }

}
*/


}


