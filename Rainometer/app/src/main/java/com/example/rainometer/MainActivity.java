package com.example.rainometer;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    GraphView tvdata;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdata=(GraphView) findViewById(R.id.tvdata);

        final LineGraphSeries<DataPoint> series=new LineGraphSeries<>(new  DataPoint[0]);

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://139.59.81.152:9090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestApi restApi=retrofit.create(RestApi.class);
        Call<List<Restmodel>> call= restApi.getRestmodels();
        call.enqueue(new Callback<List<Restmodel>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<List<Restmodel>> call, Response<List<Restmodel>> response) {
                Log.d("res", String.valueOf(response));
                if(!response.isSuccessful()){
                    Toast toast=Toast.makeText(getApplicationContext(),"Code: "+response.code(),Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                List<Restmodel> raindata =response.body();

                for (final Restmodel restmodel :raindata) {
                    int rain = restmodel.getRain();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                    Date date = null;
                    try {
                        date = (Date) formatter.parse(restmodel.getDate1());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    ;
//
                    Long x;
                    x = date.getTime();
                    tvdata.addSeries(series);
                    series.appendData(new DataPoint(x, rain), true, raindata.size());


                }


            }



                @Override
            public void onFailure(Call<List<Restmodel>> call, Throwable t) {
                 Toast toast=Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT);
                 toast.show();
            }
        });
    }}
