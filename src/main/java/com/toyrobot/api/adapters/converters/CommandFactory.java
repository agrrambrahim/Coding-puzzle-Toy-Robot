package com.toyrobot.api.adapters.converters;

import com.toyrobot.api.adapters.presenters.StringResultPrinter;
import com.toyrobot.api.core.command.*;
import com.toyrobot.api.core.tabletop.Orientation;
import com.toyrobot.api.core.tabletop.Position;

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
                    throw new IllegalArgumentException(" UNSUPPORTED COMMANDE : " + string);
            }
        }

    }

    private static PlacingCommand toPlacingCommand(String string) {
        Position robotPosition = PositionFactory.fromPlacingCommandString(string);
        Orientation robotOrientation = OrientationFactory.fromPlacingCommandString(string);
        return new PlacingCommand(robotPosition, robotOrientation);
    }


}
