package com.toyrobot.api;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
    public String response;

    public ResponseDTO(String response) {
        this.response = response;
    }

}
