
package com.ndinaholding.expresstilldeliveries.POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("apiKey")
    @Expose
    private String apiKey;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @Expose
    private String message;
    @SerializedName("message")

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
