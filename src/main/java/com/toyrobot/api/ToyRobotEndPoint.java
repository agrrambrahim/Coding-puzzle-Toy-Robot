package com.toyrobot.api;

import com.toyrobot.api.tabletop.CommandResult;
import com.toyrobot.api.tabletop.CommandRunnerService;
import com.toyrobot.api.tabletop.CommandsParser;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
public class ToyRobotEndPoint {

    private CommandRunnerService commandRunnerService;

    public ToyRobotEndPoint(CommandRunnerService commandRunner) {
        this.commandRunnerService = commandRunner;
    }

    // @RequestMapping(value = "/run", method = RequestMethod.POST)
    public String runCommands(@RequestBody String input) {
        CommandResult result = commandRunnerService.runCommands(CommandsParser.parseToStringList(input));
        return result.getOutput();


    }
}
