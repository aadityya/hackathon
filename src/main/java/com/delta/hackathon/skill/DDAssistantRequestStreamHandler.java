package com.delta.hackathon.skill;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

public class DDAssistantRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds;

    static {
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.ask.skill.20a673c4-0d9f-435e-8af4-0c8839fd0f5f");
        System.out.println("----->Supported app ids : " + supportedApplicationIds);
    }

    public DDAssistantRequestStreamHandler() {
        super(new com.delta.hackathon.skill.DDAssistantSpeechlet(), supportedApplicationIds);
    }

    public DDAssistantRequestStreamHandler(Speechlet speechlet, Set<String> supportedApplicationIds) {
        super(speechlet, supportedApplicationIds);
    }
}
