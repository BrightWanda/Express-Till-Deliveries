
package com.ndinaholding.expresstilldeliveries.POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Retailer_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("retailer")
    @Expose
    private String retailer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

}
