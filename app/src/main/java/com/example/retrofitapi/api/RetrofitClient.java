package com.example.retrofitapi.api;

import java.io.IOException;
import android.util.Base64;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //private static final String AUTH = "Basic " + Base64.encodeToString(("ajinkya:aj123").getBytes(),Base64.NO_WRAP);
    private static final String BASE_URL = "http://192.168.43.124/MyApi/public/";
    //private static final String BASE_URL = "http://localhost/MyApi/public/";

    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient() {
        /*OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor(){
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder().addHeader("Authorization", AUTH)
                                .method(original.method(),original.body());
                        Request request = builder.build();
                        return  chain.proceed(request);
                    }
                }).build();*/
        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /*retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();*/
    }

    public static synchronized  RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }
    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
