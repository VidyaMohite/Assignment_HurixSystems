package com.example.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseObjectData {
    private String numFound;
    private String start;
    private String maxScore;
    @SerializedName("docs")
    private List<Journal> journalList;

    public List<Journal> getJournalList() {
        return journalList;
    }

    public void setJournalList(List<Journal> journalList) {
        this.journalList = journalList;
    }

}
