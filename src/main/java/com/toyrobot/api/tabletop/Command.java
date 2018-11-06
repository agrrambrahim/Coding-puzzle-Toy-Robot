package com.toyrobot.api.tabletop;

public class Command {
    protected String code;

    public Command(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
