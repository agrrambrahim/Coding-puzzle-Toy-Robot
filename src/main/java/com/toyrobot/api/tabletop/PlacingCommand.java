package com.toyrobot.api.tabletop;

import com.toyrobot.api.robot.Orientation;
import com.toyrobot.api.robot.Position;
import com.toyrobot.api.robot.Robot;

public class PlacingCommand extends Command {
    private Position position;
    private Orientation orientation;

    public PlacingCommand(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    @Override
    public CommandResult executeOn(TableTop tableTop) {
        if (position.isInTheSquareTableTopOf(tableTop.DEFAULT_TABLE_DIMENSIONS)) {
            tableTop.placeNewRobot(new Robot(orientation, position));
            return CommandResult.SUCCESS;
        }
        return CommandResult.FAILED;

    }
}
