package com.toyrobot.api.core.command;

import com.toyrobot.api.usecase.CommandResult;
import com.toyrobot.api.core.tabletop.TableTop;

public abstract class Command {
    public abstract CommandResult executeOn(TableTop tableTop);
}
