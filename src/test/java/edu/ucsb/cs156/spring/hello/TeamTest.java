package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returnsEqual(){
        //Case 1: same object
        Object teamObject = new Object(); 
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals(null));
        //Case 2: different class
        assertEquals(false, team.equals(teamObject));
        //Case 3: name and members
        Team team2 = new Team("test-team");
        team2.setName(team.getName());
        team2.setMembers(team.getMembers());
        assertEquals(true, team.equals(team2));
        Team team3 = new Team("test-team");
        team3.setName("random");
        team3.setMembers(team.getMembers());
        assertEquals(false, team.equals(team3));
        Team team4 = new Team("test-team");
        team4.setName(team.getName());
        team4.addMember("random");
        assertEquals(false, team.equals(team4)); 
    }

    @Test
    public void getHashCode_returns_correct_hash(){
        int result = team.hashCode();
        int expectedResult = -1226298695;
        Team team2 = new Team("test-team");
        team2.setName("hi");
        assertEquals(expectedResult, result);
        assertEquals(false, team.hashCode() == team2.hashCode());
        assertEquals(true, team.hashCode() == team.hashCode());
    }

}
