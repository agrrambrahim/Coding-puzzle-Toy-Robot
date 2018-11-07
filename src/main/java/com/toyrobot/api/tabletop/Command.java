package com.toyrobot.api.tabletop;

public abstract class Command {
    public abstract CommandResult executeOn(TableTop tableTop);
}
