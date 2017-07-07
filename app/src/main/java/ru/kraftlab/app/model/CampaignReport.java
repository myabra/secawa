package ru.kraftlab.app.model;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created by Мария on 07.02.2017.
 */
public class CampaignReport {
    private final Campaign campaign;
    private final String departmentName;
    private final Double informedPercent;
    private final Double testedPercent;
    private final Double controlPercent;
    private final Double averageScore;
    private final Integer employeeCount;

    public CampaignReport(Builder builder) {
        this.campaign = builder.campaign;
        this.departmentName = builder.departmentName;
        this.informedPercent = builder.informedPercent;
        this.testedPercent = builder.testedPercent;
        this.controlPercent = builder.controlPercent;
        this.averageScore = builder.averageScore;
        this.employeeCount = builder.employeeCount;
    }

    public static class Builder {
        private final Campaign campaign;
        private final String departmentName;
        private Double informedPercent;
        private Double testedPercent;
        private Double controlPercent;
        private Double averageScore;
        private Integer employeeCount;

        public Builder(Campaign campaign, ADDepartment adDepartment) {
            this.campaign = campaign;
            this.departmentName = adDepartment.getName();
            this.employeeCount = adDepartment.getEmployeesCount();
        }

        public Builder informedPercent(double informedPercent) {
            this.informedPercent = informedPercent;
            return this;
        }

        public Builder testedPercent(double testedPercent) {
            this.testedPercent = testedPercent;
            return this;
        }

        public Builder controlPercent(double controlPercent) {
            this.controlPercent = controlPercent;
            return this;
        }

        public Builder averageScore(double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public CampaignReport build() {
            return new CampaignReport(this);
        }

        public CampaignReport buildRandomScores() {
            informedPercent = Double.valueOf(RandomUtils.nextInt(0, 100));
            testedPercent = Double.valueOf(RandomUtils.nextInt(0, 100));
            controlPercent = Double.valueOf(RandomUtils.nextInt(0, 100));
            averageScore = Double.valueOf(RandomUtils.nextInt(0, 100));
            return new CampaignReport(this);
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Double getInformedPercent() {
        return informedPercent;
    }

    public Double getTestedPercent() {
        return testedPercent;
    }

    public Double getControlPercent() {
        return controlPercent;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public String toString() {
        return "CampaignReport{" +
                "departmentName='" + departmentName + '\'' +
                ", informedPercent=" + informedPercent +
                ", testedPercent=" + testedPercent +
                ", controlPercent=" + controlPercent +
                ", averageScore=" + averageScore +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
