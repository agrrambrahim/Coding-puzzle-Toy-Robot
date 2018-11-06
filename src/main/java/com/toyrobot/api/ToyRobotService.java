package com.toyrobot.api;

import com.toyrobot.api.tabletop.Tabletop;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyRobotService {

    private Tabletop tabletop;

    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public String runCommands(@RequestBody String input) {
        return tabletop.runCommands(CommandsParser.parseToStringList(input));

    }

    public Tabletop getTabletop() {
        return tabletop;
    }

    public void setTabletop(Tabletop tabletop) {
        this.tabletop = tabletop;
    }
}
