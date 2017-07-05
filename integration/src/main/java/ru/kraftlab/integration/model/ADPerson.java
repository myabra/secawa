package ru.kraftlab.integration.model;

/**
 * Created by Maria on 26.01.2017.
 */
public class ADPerson {
    private final String sid;
    private final String displayName;
    private final String department;
    private final String position;
    private final String mail;
    private final String manager;

    public ADPerson(Builder builder) {
        this.sid = builder.sid;
        this.displayName = builder.displayName;
        this.department = builder.department;
        this.position = builder.position;
        this.mail = builder.mail;
        this.manager = builder.manager;

    }

    public String getSid() {
        return sid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getMail() {
        return mail;
    }

    public String getManager() {
        return manager;
    }

    public static class Builder {
        private String sid;
        private String displayName;
        private String department;
        private String position;
        private String mail;
        private String manager;

        public Builder sid(String sid) {
            this.sid = sid;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder manager(String manager) {
            this.manager = manager;
            return this;
        }

        public ADPerson build() {
            //todo validation
            return new ADPerson(this);
        }
    }

    @Override
    public String toString() {
        return "ADPerson{" +
                "sid='" + sid + '\'' +
                ", displayName='" + displayName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", mail='" + mail + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ADPerson adPerson = (ADPerson) o;

        return sid.equals(adPerson.sid);
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(sid)
                .toHashCode();
    }
}
