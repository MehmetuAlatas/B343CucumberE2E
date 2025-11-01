package com.snackattack.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductResponsePojo {

    private Boolean success;
    private String message;
    private CreateProductPayloadPojo data;

    public CreateProductResponsePojo() {
    }

    public CreateProductResponsePojo(Boolean success, String message, CreateProductPayloadPojo data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CreateProductPayloadPojo getData() {
        return data;
    }

    public void setData(CreateProductPayloadPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CreateProductResponsePojo{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
