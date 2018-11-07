package com.toyrobot.api.tabletop;


import com.toyrobot.api.ResultPrinter;
import com.toyrobot.api.robot.Robot;

import java.util.Optional;

public class TableTop {
    public final static int DEFAULT_TABLE_DIMENSIONS = 5;
    private Optional<Robot> robot;

    public TableTop() {
        this.robot = Optional.empty();
    }

    public String report(ResultPrinter printer) {
        if (robot.isPresent()) {
            return robot.get().report(printer);
        }
        return printer.printMissingRobot();

    }

    public void placeNewRobot(Robot robot) {
        this.robot = Optional.of(robot);
    }

    public boolean changeRobotOrientationTo(int cardinalDirection) {
        if (robot.isPresent()) {
            robot.get().changeOrientation(cardinalDirection);
            return true;
        }
        return false;
    }

    public boolean makeRobotMoveForward() {
        if (robot.isPresent()) {
            return robot.get().moveForward(DEFAULT_TABLE_DIMENSIONS);
        }
        return false;
    }
}
