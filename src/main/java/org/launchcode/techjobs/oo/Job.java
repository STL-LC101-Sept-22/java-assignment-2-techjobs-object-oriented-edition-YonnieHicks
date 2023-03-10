package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


    @Override
    public String toString() {
        String emptyField = "Data not available";
        if (name == null && employer == null && location == null && positionType == null && coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }
        if (name == null || name.isEmpty()) {
            name = emptyField;
        }
        if (employer == null || employer.getValue().isEmpty()) {
            employer = new Employer(emptyField);
        }
        if (location == null || location.getValue().isEmpty()) {
            location = new Location(emptyField);
        }
        if (positionType == null || positionType.getValue().isEmpty()) {
            positionType = new PositionType(emptyField);
        }
        if (coreCompetency == null || coreCompetency.getValue().isEmpty()) {
            coreCompetency = new CoreCompetency(emptyField);
        }
        return "\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer.getValue() + "\n" +
                "Location: " + location.getValue() + "\n" +
                "Position Type: " + positionType.getValue() + "\n" +
                "Core Competency: " + coreCompetency.getValue() + "\n";
    }
}
