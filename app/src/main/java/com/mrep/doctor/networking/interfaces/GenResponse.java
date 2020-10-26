package com.mrep.doctor.networking.interfaces;

public class GenResponse<S, RP> {

    S statusCode;
    RP response;

    public S getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(S statusCode) {
        this.statusCode = statusCode;
    }


    public RP getResponse() {
        return response;
    }

    public void setResponse(RP response) {
        this.response = response;
    }

}
