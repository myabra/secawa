package ru.kraftlab.report.model;

import java.util.Date;

/**
 * Created by Мария on 22.06.2017.
 */
public class Campaign {
    private int id;
    private final String name;
    private final Date startDate;
    private final String createdBy;
    private boolean isActive;

    public Campaign(String name, Date startDate, String createdBy) {
        this.name = name;
        this.startDate = startDate;
        this.createdBy = createdBy;
        isActive = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return new Date(startDate.getTime());
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public boolean isActive() {
        return isActive;
    }
}
