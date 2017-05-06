package com.gmu.tutors.controllers;

import java.io.Serializable;

/**
 * Created by Andrew on 5/5/2017.
 */
public class Response<T> implements Serializable {
    T payload;

    public Response(){}
    public Response(T payload){
        super();
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
