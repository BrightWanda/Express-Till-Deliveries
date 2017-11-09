
package com.ndinaholding.expresstilldeliveries.POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Special {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("retailers")
    @Expose
    private Double price;
    @SerializedName("price")
    @Expose
    private String item;
    @SerializedName("item")
    @Expose
    private String dateValidity;
    @SerializedName("date_validity")
    @Expose
    private String imageString;
    @SerializedName("image_string")

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDateValidity() {
        return dateValidity;
    }

    public void setDateValidity(String dateValidity) {
        this.dateValidity = dateValidity;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

}
