package ru.kraftlab.integration.model;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Мария on 27.06.2017.
 */
public class Campaign {
    private int id;
    private Date creationDate;
    private String createdBy;
    private String name;
    private String fileName;
    private boolean isActive;

    public Campaign(String name, String fileName) {
        this.creationDate = new Date();
        this.name = name;
        this.createdBy = "auto created"; //todo
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }

    private void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static class Builder {
        private int id;
        private Date creationDate;
        private String createdBy;
        private String name;
        private String fileName;
        private Boolean isActive;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Campaign build() {
            final String errMsq = "Value of %s is required";
            Objects.requireNonNull(name, String.format(errMsq, "name"));
            Objects.requireNonNull(createdBy, String.format(errMsq, "createdBy"));
            Objects.requireNonNull(isActive, String.format(errMsq, "isActive"));
            Objects.requireNonNull(fileName, String.format(errMsq, "fileName"));
            Objects.requireNonNull(id, String.format(errMsq, "id"));
            Objects.requireNonNull(creationDate, String.format(errMsq, "creationDate"));

            Campaign campaign = new Campaign(name, createdBy);
            campaign.setActive(isActive);
            campaign.setFileName(fileName);
            campaign.setId(id);
            campaign.setCreationDate(creationDate);

            return campaign;
        }
    }
}
