
package com.ndinaholding.expresstilldeliveries.POJOs;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Retailer {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("retailers")
    @Expose
    private List<Retailer_> retailers = null;
    @Expose
    private String message;
    @SerializedName("message")

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Retailer_> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<Retailer_> retailers) {
        this.retailers = retailers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
