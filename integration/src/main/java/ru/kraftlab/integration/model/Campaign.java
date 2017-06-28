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

    public Campaign(String name, String createdBy, String fileName) {
        this.name = name;
        this.createdBy = createdBy;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static class Builder {
        private Integer id;
        private Date creationDate;
        private String createdBy = "auto created"; //todo fix
        private String name;
        private String fileName;
        private boolean isActive;

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
            Objects.requireNonNull(fileName, String.format(errMsq, "fileName"));

            Campaign campaign = new Campaign(name, createdBy, fileName);
            campaign.setActive(isActive);
            if (id != null) {
                campaign.setId(id);
            }
            if (creationDate != null) {
                campaign.setCreationDate(creationDate);
            }

            return campaign;
        }
    }
}
