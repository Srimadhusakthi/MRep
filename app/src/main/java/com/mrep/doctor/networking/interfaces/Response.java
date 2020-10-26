package com.mrep.doctor.networking.interfaces;

public class Response<S,RP,SR,ER> {
    S statusCode;
    RP response;
    SR successResponse;
    ER errorResponse;

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

    public SR getSuccessResponse() {
        return successResponse;
    }

    public void setSuccessResponse(SR successResponse) {
        this.successResponse = successResponse;
    }

    public ER getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ER errorResponse) {
        this.errorResponse = errorResponse;
    }
}
