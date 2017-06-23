package ru.kraftlab.integration.model;

/**
 * Created by Maria on 26.01.2017.
 */
public class ADPerson {
    String id;
    String displayName;
    String department;
    String position;
    String mail;
    String manager;

    public ADPerson(String id, String displayName, String department, String position, String mail, String manager) {
        this.id = id;
        this.displayName = displayName;
        this.department = department;
        this.position = position;
        this.mail = mail;
        this.manager = manager;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "ADPerson{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", mail='" + mail + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
