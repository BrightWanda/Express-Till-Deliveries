
package com.ndinaholding.expresstilldeliveries.POJOs;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clients {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("clients")
    @Expose
    private List<Client> clients = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
