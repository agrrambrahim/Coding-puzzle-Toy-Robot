package com.toyrobot.api.adapters.controllers;

import com.toyrobot.api.adapters.converters.CommandsParser;
import com.toyrobot.api.usecase.CommandExecutor;
import com.toyrobot.api.usecase.CommandResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyRobotEndPoint {

    private CommandExecutor commandExecutor;

    public ToyRobotEndPoint(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

     @RequestMapping(value = "/run", method = RequestMethod.POST)
    public String runCommands(@RequestBody String input) {
        CommandResult result = commandExecutor.run(CommandsParser.parseToStringList(input));
        return result.toDto();


    }
}
