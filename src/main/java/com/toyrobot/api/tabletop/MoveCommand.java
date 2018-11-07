package com.toyrobot.api.tabletop;

public class MoveCommand extends Command {

    @Override
    public CommandResult executeOn(TableTop tableTop) {
        if (tableTop.makeRobotMoveForward())
            return CommandResult.SUCCESS;
        return CommandResult.FAILED;
    }
}
