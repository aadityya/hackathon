package com.delta.hackathon.skill;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.delta.hackathon.constants.Conversation;
import com.delta.hackathon.external.RestCommunicator;

import static java.lang.String.format;

public class ResponseHelper {

    public SpeechletResponse getInitMessage() {


        String speechText = Conversation.INIT_RESPONSE;

        // Create the Simple card content.

        SimpleCard card = new SimpleCard();
        card.setTitle(Conversation.INIT_RESPONSE);
        card.setContent(speechText);

        // Create the plain text output.

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);

    }

    public SpeechletResponse getPinRequestMessage() {


        String speechText = Conversation.PIN_REQUEST;

        // Create the Simple card content.

        SimpleCard card = new SimpleCard();
        card.setTitle(Conversation.PIN_REQUEST);
        card.setContent(speechText);

        // Create the plain text output.

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);

    }

    public SpeechletResponse getEnrolleeInformation(com.delta.hackathon.model.EnrolleeInfo enrolleeInfo) {

        String speechText = format(Conversation.WELCOME_RESPONSE, enrolleeInfo.getEnrollees().get(0).getEnrolleeName());

        // Create the Simple card content.

        SimpleCard card = new SimpleCard();
        card.setTitle(Conversation.WELCOME_RESPONSE);
        card.setContent(speechText);

        // Create the plain text output.

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);

    }

    public com.delta.hackathon.model.EnrolleeInfo getEnrolleeInformation(String enrolleeId) {
        com.delta.hackathon.external.RestCommunicator communicator = new RestCommunicator();
        com.delta.hackathon.model.EnrolleeInfo info = communicator.getEnrolleeInfo(enrolleeId);
        return info;
    }

    public SpeechletResponse getDeductibleInfo(com.delta.hackathon.model.Enrollee info) {

        String speechText = format(Conversation.DEDUCTIBLE_RESPONSE,
                info.getDeductible(), info.getMet());

        // Create the Simple card content.

        SimpleCard card = new SimpleCard();
        card.setTitle(Conversation.DEDUCTIBLE_RESPONSE);
        card.setContent(speechText);

        // Create the plain text output.

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }

    public SpeechletResponse getTicketDetails(com.delta.hackathon.model.Enrollee info) {

        String speechText = format(Conversation.CALLBACK_RESPONSE,
                info.getServiceTicketInfoList().get(0).getTicketNumber());

        // Create the Simple card content.

        SimpleCard card = new SimpleCard();
        card.setTitle(Conversation.CALLBACK_RESPONSE);
        card.setContent(speechText);

        // Create the plain text output.

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }

    public SpeechletResponse getExitMessage(com.delta.hackathon.model.Enrollee info) {

        String speechText = format(Conversation.EXIT_RESPONSE, info.getEnrolleeName());
        System.out.println("1");

        // Create the Simple card content.

        SimpleCard card = new SimpleCard();
        card.setTitle(Conversation.EXIT_RESPONSE);
        card.setContent(speechText);
        System.out.println("2");

        // Create the plain text output.

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        System.out.println("3");

        // Create reprompt

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        System.out.println("4");

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }
}
