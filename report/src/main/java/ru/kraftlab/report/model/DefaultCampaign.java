package ru.kraftlab.report.model;

import java.util.Date;

/**
 * Created by Мария on 22.06.2017.
 */
public class DefaultCampaign extends Campaign {
    private static final String DEFAULT_NAME = "Название не задано";
    private static final String DEFAULT_AUTHOR_NAME = "Создано автоматически";

    public DefaultCampaign() {
        super(DEFAULT_NAME, new Date(), DEFAULT_AUTHOR_NAME);
    }
}
