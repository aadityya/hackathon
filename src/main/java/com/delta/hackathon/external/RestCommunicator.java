package com.delta.hackathon.external;

import com.delta.hackathon.model.EnrolleeInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RestCommunicator {
    public EnrolleeInfo getEnrolleeInfo(String enrolleeId) {
        RestTemplate restTemplate = new RestTemplate();
        String enroleeEndpoint = "https://run.mocky.io/v3/352470ba-96a0-4af5-aed0-a38451f0a443";
        ResponseEntity<EnrolleeInfo> response = restTemplate.getForEntity(enroleeEndpoint, EnrolleeInfo.class);
        System.out.println(response.getBody().getEnrollees().get(0).getEnrolleeName());
        return response.getBody();
    }

    public static void main(String [] args) {
        RestCommunicator communicator = new RestCommunicator();
        communicator.getEnrolleeInfo("1234");
    }
}
