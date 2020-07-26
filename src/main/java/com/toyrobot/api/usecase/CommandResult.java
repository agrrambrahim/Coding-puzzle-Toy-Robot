package com.toyrobot.api.usecase;

public enum CommandResult {
    SUCCESS, FAILED, SUCCESSWITHOUTPUT;

    private String output;

    public String toDto() {

        return output;
    }

    public void SetOutput(String output) {
        this.output = output;
    }
}
