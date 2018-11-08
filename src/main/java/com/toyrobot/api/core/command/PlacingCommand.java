package com.toyrobot.api.core.command;

import com.toyrobot.api.core.tabletop.Orientation;
import com.toyrobot.api.core.tabletop.Position;
import com.toyrobot.api.core.tabletop.Robot;
import com.toyrobot.api.usecase.CommandResult;
import com.toyrobot.api.core.tabletop.TableTop;

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
