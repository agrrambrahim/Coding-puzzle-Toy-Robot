package com.toyrobot.api.tabletop;

import com.toyrobot.api.robot.Position;
import com.toyrobot.api.robot.Robot;

import java.util.LinkedList;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Tabletop {
    private final static int DEFAULT_TABLE_DIMENSIONS=5;
    private Robot robot;
    private Position robotPosition;

    public String runCommands(LinkedList<Command> commands) {
        if(isRobotMissing(commands))
         return"Robot is Missing";
        else{
          commands = erasebeforePlacingRobotCommands(commands);

            return "";
        }

            }

    private LinkedList<Command> erasebeforePlacingRobotCommands(LinkedList<Command> commands) {
        return new LinkedList<>(commands.subList(getRobotPlacingCmdIndex(commands).getAsInt(),commands.size()));
    }

    private Boolean isRobotMissing(LinkedList<Command> commands) {
        return commands.stream().filter(PlacingCommand.class::isInstance).findFirst().isPresent();
    }

    private OptionalInt getRobotPlacingCmdIndex(LinkedList<Command> commands){
        return IntStream.range(0, commands.size())
                .filter(PlacingCommand.class::isInstance)
                .findFirst();
    }
}
