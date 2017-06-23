package ru.kraftlab.integration.model;

/**
 * Created by Maria on 27.01.2017.
 */
public class ADDepartment {
    private final String name;
    private final int employeesCount;

    public ADDepartment(String name, int employeesCount) {
        this.name = name;
        this.employeesCount = employeesCount;
    }

    public String getName() {
        return name;
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    @Override
    public String toString() {
        return "ADDepartment{" +
                ", name='" + name + '\'' +
                ", employeesCount='" + employeesCount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ADDepartment that = (ADDepartment) o;

        return name.toLowerCase().equals(that.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
