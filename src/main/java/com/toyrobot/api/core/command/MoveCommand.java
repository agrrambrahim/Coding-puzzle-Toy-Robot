package com.toyrobot.api.core.command;

import com.toyrobot.api.usecase.CommandResult;
import com.toyrobot.api.core.tabletop.TableTop;

public class MoveCommand extends Command {

    @Override
    public CommandResult executeOn(TableTop tableTop) {
        if (tableTop.makeRobotMoveForward())
            return CommandResult.SUCCESS;
        return CommandResult.FAILED;
    }
}
