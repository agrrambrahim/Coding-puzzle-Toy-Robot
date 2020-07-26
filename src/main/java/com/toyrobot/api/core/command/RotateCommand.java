package com.toyrobot.api.core.command;

import com.toyrobot.api.usecase.CommandResult;
import com.toyrobot.api.core.tabletop.TableTop;

public class RotateCommand extends Command {
    private int cardinalDirection;

    public RotateCommand(int cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    @Override
    public CommandResult executeOn(TableTop tableTop) {
        if (tableTop.changeRobotOrientationTo(cardinalDirection))
            return CommandResult.SUCCESS;
        return CommandResult.FAILED;
    }
}
