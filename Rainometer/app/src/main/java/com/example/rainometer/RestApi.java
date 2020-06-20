package com.example.rainometer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApi {

  @GET("raindata")
  Call<List<Restmodel>> getRestmodels();

}
