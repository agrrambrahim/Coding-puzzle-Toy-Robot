package com.toyrobot.api;

import com.toyrobot.api.tabletop.CommandRunnerService;
import com.toyrobot.api.tabletop.TableTop;

//@SpringBootApplication
public class ToyrobotApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ToyrobotApplication.class, args);
        TableTop tableTop = new TableTop();
        CommandRunnerService commandRunner = new CommandRunnerService(tableTop);
        ToyRobotEndPoint endPoint = new ToyRobotEndPoint(commandRunner);
        String commands = String.join(System.getProperty("line.separator"),
                "MOVE",
                "MOVE",
                "LEFT",
                "MOVE",
                "REPORT");
        System.out.println(endPoint.runCommands(commands));

         commands = String.join(System.getProperty("line.separator"),
                "PLACE 1,2,EAST",
                "MOVE",
                "MOVE",
                "LEFT",
                "MOVE",
                "REPORT");
        System.out.println(endPoint.runCommands(commands));

        commands = String.join(System.getProperty("line.separator"),
                "MOVE",
                "MOVE",
                "LEFT",
                "MOVE",
                "REPORT");
        System.out.println(endPoint.runCommands(commands));

        commands = String.join(System.getProperty("line.separator"),
                "PLACE 0,0,EAST",
                "LEFT",
                "REPORT");
        System.out.println(endPoint.runCommands(commands));

        commands = String.join(System.getProperty("line.separator"),
                "PLACE -1,2,EAST",
                "MOVE",
                "MOVE",
                "LEFT",
                "MOVE",
                "REPORT");

        commands = String.join(System.getProperty("line.separator"),
                "PLACE -1,2,EAST",
                "PLACE 1,1,SOUTH",
                "MOVE",
                "REPORT");


        System.out.println(endPoint.runCommands(commands));

    }
}
