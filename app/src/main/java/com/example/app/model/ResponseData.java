package com.example.app.model;

import com.google.gson.annotations.SerializedName;

public class ResponseData {
    @SerializedName("response")
    private ResponseObjectData responseObjectData;

    public ResponseObjectData getResponseObjectData() {
        return responseObjectData;
    }

    public void setResponseObjectData(ResponseObjectData responseObjectData) {
        this.responseObjectData = responseObjectData;
    }

}
