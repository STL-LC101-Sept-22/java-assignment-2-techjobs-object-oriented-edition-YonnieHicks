package org.launchcode.techjobs.oo.test;

import org.junit.Test;

import static org.junit.Assert.*;

import org.launchcode.techjobs.oo.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product Tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();
        assertTrue(jobString.startsWith("\n"));
        assertTrue(jobString.endsWith("\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();

        assertTrue(jobString.contains("\nID: " + job.getId() + "\n"));
        assertTrue(jobString.contains("\nName: Product Tester\n"));
        assertTrue(jobString.contains("\nEmployer: ACME\n"));
        assertTrue(jobString.contains("\nLocation: Desert\n"));
        assertTrue(jobString.contains("\nPosition Type: Quality control\n"));
        assertTrue(jobString.contains("\nCore Competency: Persistence\n"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product Tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();
        assertTrue(jobString.contains("\nID: " + job.getId() + "\n"));
        assertTrue(jobString.contains("\nName: Product Tester\n"));
        assertTrue(jobString.contains("\nEmployer: Data not available\n"));
        assertTrue(jobString.contains("\nLocation: Desert\n"));
        assertTrue(jobString.contains("\nPosition Type: Quality control\n"));
        assertTrue(jobString.contains("\nCore Competency: Persistence\n"));
    }


}
