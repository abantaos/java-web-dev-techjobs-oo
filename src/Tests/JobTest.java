package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    private Job jobOne;
    private Job jobTwo;
    private Job jobTester;
    private Job jobTesterTwo;

    @Before
    public void makeJob() {
        jobOne = new Job();
        jobTwo = new Job();
        jobTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTesterTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        }

    @Test
    public void testSettingJobId() {
    assertFalse(jobOne.equals(jobTwo));
//        System.out.println(jobOne.getId());
//        System.out.println(jobTwo.getId());
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
        assertFalse(jobTester.equals(jobTesterTwo));
    }

}
