package com.example.apple.youtubeplaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.apple.youtubeplaylist.model.Data;
import com.example.apple.youtubeplaylist.model.Item;
import com.example.apple.youtubeplaylist.model.ListData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements YoutubeAdapter.PlayVideo{

private ListData listiItems = new ListData();
public static List<Item> list = new ArrayList<Item>();
private RecyclerView listVideo_rv;
private YoutubeAdapter adapter;
private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ApUtils.getYoutubeAPI().getItem().enqueue(new Callback<ListData>() {
            @Override
            public void onResponse(Call<ListData> call, Response<ListData> response) {
                if(response.isSuccessful()){
                   listiItems = response.body();
                   list = listiItems.getDataList();

                   listVideo_rv = (RecyclerView) MainActivity.this.findViewById(R.id.rv_youtube_list);
                   linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                   adapter = new YoutubeAdapter(list,MainActivity.this,MainActivity.this);
                    listVideo_rv.setLayoutManager(linearLayoutManager);
                    listVideo_rv.setAdapter(adapter);
             }
            }

            @Override
            public void onFailure(Call<ListData> call, Throwable t) {
                Log.e("Error",t.getMessage().toString());
            }
        });
    }

    // setOnClick to play video
    @Override
    public void playVideo(int itemPosition) {
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("position",itemPosition);
        startActivity(intent);
    }
}
