package com.toyrobot.api.tabletop;

import com.toyrobot.api.StringResultPrinter;
import com.toyrobot.api.robot.Orientation;
import com.toyrobot.api.robot.OrientationFactory;
import com.toyrobot.api.robot.Position;
import com.toyrobot.api.robot.PositionFactory;

public class CommandFactory {


    public static Command from(String string) {

        if (string.startsWith("PLACE")) return toPlacingCommand(string);
        else {
            switch (string) {
                case "MOVE":
                    return new MoveCommand();
                case "LEFT":
                    return new RotateCommand(-1);
                case "RIGHT":
                    return new RotateCommand(1);
                case "REPORT":
                    return new ReportingCommand(new StringResultPrinter());
                default:
                    throw new IllegalArgumentException("UNSUPPORTED COMMANDE" + string);
            }
        }

    }

    private static PlacingCommand toPlacingCommand(String string) {
        Position robotPosition = PositionFactory.fromPlacingCommandString(string);
        Orientation robotOrientation = OrientationFactory.fromPlacingCommandString(string);
        return new PlacingCommand(robotPosition, robotOrientation);
    }


}
