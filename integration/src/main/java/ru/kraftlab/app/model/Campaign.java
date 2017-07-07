package ru.kraftlab.app.model;

import java.util.Date;
import java.util.Objects;

/**
 * Кампания по обучению сотрудников
 */
public class Campaign {
    private final Integer id;
    private final Date creationDate;
    private final String createdBy;
    private final String name;
    private final String fileName;
    private final boolean isActive;

    private Campaign(Builder builder) {
        this.id = builder.id;
        this.creationDate = builder.creationDate;
        this.createdBy = builder.createdBy;
        this.name = builder.name;
        this.fileName = builder.fileName;
        this.isActive = builder.isActive;
    }

    public Integer getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean getIsActive() {
        return isActive;
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
            return new Campaign(this);
        }
    }
}
