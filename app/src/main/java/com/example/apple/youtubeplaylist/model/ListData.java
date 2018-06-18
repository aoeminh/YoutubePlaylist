package com.example.apple.youtubeplaylist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListData {

    @SerializedName("items")
    @Expose
private List<Item> dataList;

    public List<Item> getDataList() {
        return dataList;
    }

    public void setDataList(List<Item> dataList) {
        this.dataList = dataList;
    }
}
