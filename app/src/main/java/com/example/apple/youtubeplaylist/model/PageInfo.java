package com.example.apple.youtubeplaylist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageInfo {
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("resultsPerPage")
    @Expose
    private Integer resultsPerPage;

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }


}
