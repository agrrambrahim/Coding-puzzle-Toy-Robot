package com.toyrobot.api.adapters.springconfig;

import com.toyrobot.api.core.tabletop.TableTop;
import com.toyrobot.api.usecase.CommandExecutor;
import com.toyrobot.api.usecase.TableTopCommandExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public CommandExecutor commandExecutor(){
        return new TableTopCommandExecutor(new TableTop());
    }
}
