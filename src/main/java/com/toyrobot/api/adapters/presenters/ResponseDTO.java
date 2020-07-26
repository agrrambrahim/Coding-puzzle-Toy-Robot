package com.toyrobot.api.adapters.presenters;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
    public String response;

    public ResponseDTO(String response) {
        this.response = response;
    }

}
