package ru.ergakov.gb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Класс для получения методов из application.yml
 */
@Component
@ConfigurationProperties(prefix = "db")
@Getter
@Setter
public class DbScripts {
    private String findAll;
    private String save;
    private String deleteById;
    private String getOne;
    private String updateAct;
}
