package com.toyrobot.api.tabletop;

import com.toyrobot.api.robot.Orientation;
import com.toyrobot.api.robot.Position;

public class PlacingCommand extends Command {
    private Position position;
    private Orientation orientation;

    public PlacingCommand(String code, Position position,Orientation orientation) {
        super(code);
        this.position = position;
        this.orientation=orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
