package com.toyrobot.api;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToyrobotApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ToyRobotEndPointIntegrationTest {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    @Test
    public void test_1_AllMovementCommandsAreIgnoredInRobotNotBePlacedCase() throws Exception {

        String commands = String.join(System.getProperty("line.separator"),
                "MOVE",
                "RIGHT",
                "LEFT",
                "MOVE",
                "REPORT");

        String response = sendPostRequest(commands);
        String expected = "OutPut: Robot is Missing";
        assertEquals(expected, response);

    }

    @Test
    public void test_2_ToyRobotInitialPlacementIsIgnored() throws Exception {

        String commands = String.join(System.getProperty("line.separator"),
                "PLACE -1,-4,EAST",
                "PLACE -4,-4,NORTH",
                "PLACE 0,-4,SOUTH",
                "REPORT");

        String response = sendPostRequest(commands);
        String expected = "OutPut: Robot is Missing";
        assertEquals(expected, response);

    }


    @Test
    public void test_3_ToyRobotShouldMoveCorrectly() throws Exception {

        String commands = String.join(System.getProperty("line.separator"),
                "PLACE 1,2,EAST",
                "MOVE",
                "MOVE",
                "LEFT",
                "REPORT");

        String response = sendPostRequest(commands);
        String expected = "OutPut: 3,2,NORTH";
        assertEquals(expected, response);

    }

    @Test
    public void test_4_FurtherValidMovementCommandsStillBeAllowed() throws Exception {

        String commands = String.join(System.getProperty("line.separator"),
                "MOVE",
                "MOVE",
                "MOVE",
                "LEFT",
                "MOVE",
                "REPORT");

        String response = sendPostRequest(commands);
        String expected = "OutPut: 4,4,EAST";
        assertEquals(expected, response);

    }


    @Test
    public void test_5_MovementCommandsThatCouldMakesRobotFallOffTheTableAreIgnored() throws Exception {

        String commands = String.join(System.getProperty("line.separator"), "MOVE", "REPORT");

        String response = sendPostRequest(commands);
        String expected = "OutPut: 4,4,EAST";
        assertEquals(expected, response);

        String responseOfSecondRequest = sendPostRequest(commands);
        String expectedForSecondRequest = "OutPut: 4,4,EAST";
        assertEquals(expectedForSecondRequest, responseOfSecondRequest);

    }

    @Test
    public void test_6_FurtherValidMovementCommandsShouldStillAlwaysAllowed() throws Exception {

        String commands = String.join(System.getProperty("line.separator"),
                "RIGHT",
                "MOVE",
                "MOVE",
                "MOVE",
                "RIGHT",
                "MOVE",
                "MOVE",
                "MOVE",
                "LEFT",
                "REPORT");

        String response = sendPostRequest(commands);
        String expected = "OutPut: 1,1,SOUTH";
        assertEquals(expected, response);

    }

    @Test
    public void test_7_ReplacingToyRoboInTheTableStillAlwaysAllowed() throws Exception {

        String commands = String.join(System.getProperty("line.separator"),
                "PLACE 2,2,WEST",
                "REPORT");

        String response = sendPostRequest(commands);
        String expected = "OutPut: 2,2,WEST";
        assertEquals(expected, response);

        commands = String.join(System.getProperty("line.separator"),
                "PLACE 4,4,SOUTH",
                "REPORT");

        String responseOfSecondRequest = sendPostRequest(commands);
        String expectedForTheSecondRequest = "OutPut: 4,4,SOUTH";
        assertEquals(expectedForTheSecondRequest, responseOfSecondRequest);

    }


    private String sendPostRequest(String commands) {
        HttpEntity<String> entity = new HttpEntity<String>(commands, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/run"),
                HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
