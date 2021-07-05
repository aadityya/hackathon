package com.delta.hackathon.skill;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class DDAssistantSpeechlet implements Speechlet {

    com.delta.hackathon.skill.ResponseHelper helper = new com.delta.hackathon.skill.ResponseHelper();

    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        return helper.getInitMessage();
    }

    public SpeechletResponse onIntent(final IntentRequest request, final Session session) throws SpeechletException {


        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        System.out.println("--------------->" + intentName);

        if ("PinIntent".equals(intentName)) {
            com.delta.hackathon.model.EnrolleeInfo info = helper.getEnrolleeInformation("1234");
            session.setAttribute("enrolleeInfo", info);
            return helper.getSmileResponse(info.getEnrollees().get(0));
        } else if ("DeductibleIntent".equals(intentName)) {
            System.out.println("----*---->" + session.getAttributes());
            Map<String, List<com.delta.hackathon.model.Enrollee>> info = (Map) session.getAttribute("enrolleeInfo");
            ObjectMapper mapper = new ObjectMapper();
            com.delta.hackathon.model.EnrolleeInfo eInfo = mapper.convertValue(info, com.delta.hackathon.model.EnrolleeInfo.class);
            System.out.println("----*;;---->" + session.getAttributes());
            System.out.println(";;;;;" + eInfo.getEnrollees().get(0).getDeductible());
            return helper.getDeductibleInfo(eInfo.getEnrollees().get(0));
        }  else if ("ExitIntent".equals(intentName)) {
            System.out.println("*********-----******" + session.getAttributes());
            Map<String, List<com.delta.hackathon.model.Enrollee>> info = (Map) session.getAttribute("enrolleeInfo");
            ObjectMapper mapper = new ObjectMapper();
            com.delta.hackathon.model.EnrolleeInfo eInfo = mapper.convertValue(info, com.delta.hackathon.model.EnrolleeInfo.class);
            System.out.println("----*;;---->" + session.getAttributes());
            System.out.println(";;;;;" + eInfo.getEnrollees().get(0).getEnrolleeName());
            return helper.getExitMessage(eInfo.getEnrollees().get(0));
        }

        return null;
    }





    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException
    {
        System.out.println("onSessionStarted requestId={}, sessionId={} " + request.getRequestId()
                + " - " + session.getSessionId());
    }



    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException
    {

    }
}