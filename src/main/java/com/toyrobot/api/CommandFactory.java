package com.toyrobot.api;

import com.toyrobot.api.robot.Orientation;
import com.toyrobot.api.robot.Position;
import com.toyrobot.api.tabletop.Command;
import com.toyrobot.api.tabletop.PlacingCommand;

public class CommandFactory {


    public static Command from(String string){

        if(string.startsWith("PLACE")) return toPlacingCommand(string);
        else{
            switch (string){
                case "MOVE" : return new Command("MOVE");
                case "LEFT" : return new Command("LEFT");
                case "RIGHT" : return new Command("RIGHT");
                case "REPORT" : return new Command("REPORT");
                default: throw new IllegalArgumentException("UNSUPPORTED COMMANDE"+ string);
            }
        }

    }

    private static PlacingCommand toPlacingCommand(String string) {
        Position robotPosition =PositionFactory.fromPlacingCommandString(string);
        Orientation robotOrientation =OrientationFactory.fromPlacingCommandString(string);
        return new PlacingCommand("PLACE",robotPosition,robotOrientation);
    }


}
