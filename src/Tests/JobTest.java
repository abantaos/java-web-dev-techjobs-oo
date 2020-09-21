package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    private Job jobOne;
    private Job jobTwo;
    private Job jobTester;
    private Job jobTesterIdentical;
    private Job jobTesterMissingName;
    private Job jobTesterMissingEmployer;
    private Job jobTesterMissingLocation;
    private Job jobTesterMissingPositionType;
    private Job jobTesterMissingCoreCompetency;

    @Before
    public void makeJob() {
        jobOne = new Job();
        jobTwo = new Job();
        jobTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTesterIdentical = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTesterMissingName = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTesterMissingEmployer = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTesterMissingLocation = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTesterMissingPositionType = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        jobTesterMissingCoreCompetency = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        }

    @Test
    public void testSettingJobId() {
    assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(jobTester.getName().equals("Product tester"));
        assertTrue(jobTester.getEmployer() instanceof Employer);
        assertTrue(jobTester.getEmployer().toString().equals("ACME"));
        assertTrue(jobTester.getLocation() instanceof Location);
        assertTrue(jobTester.getLocation().toString().equals("Desert"));
        assertTrue(jobTester.getPositionType() instanceof PositionType);
        assertTrue(jobTester.getPositionType().toString().equals("Quality control"));
        assertTrue(jobTester.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(jobTester.getCoreCompetency().toString().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(jobTester.equals(jobTesterIdentical));
    }

    @Test
    public void testBlankLinesBeforeAndAfter() {
        assertTrue(Job.toString(jobTester).startsWith("\n"));
        assertTrue(Job.toString(jobTester).endsWith("\n"));
    }

    @Test
    public void testEachFieldOnOwnLine() {
        assertTrue(Job.toString(jobTester).contains("ID: " + jobTester.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence"));

    }

    @Test
    public void testIfFieldEmptyDataNotAvailable() {
        assertTrue(Job.toString(jobTesterMissingName).contains("Name: Data not available"));
        assertTrue(Job.toString(jobTesterMissingEmployer).contains("Employer: Data not available"));
        assertTrue(Job.toString(jobTesterMissingLocation).contains("Location: Data not available"));
        assertTrue(Job.toString(jobTesterMissingPositionType).contains("Position Type: Data not available"));
        assertTrue(Job.toString(jobTesterMissingCoreCompetency).contains("Core Competency: Data not available"));
    }


}
