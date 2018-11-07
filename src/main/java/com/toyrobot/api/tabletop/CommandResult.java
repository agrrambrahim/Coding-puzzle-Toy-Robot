package com.toyrobot.api.tabletop;

public enum CommandResult {
    SUCCESS, FAILED, SUCCESSWITHOUTPUT;

    private String output;

    public String getOutput() {
        return output;
    }

    public void SetOutput(String output) {
        this.output = output;
    }
}
