package com.talfinder.learning.javadwmongodb.api.impl;

import com.talfinder.learning.javadwmongodb.api.WelcomeApi;
import com.talfinder.learning.javadwmongodb.resources.Message;

import javax.ws.rs.core.Response;

public class WelcomeApiImpl implements WelcomeApi {

    private String template;

    public WelcomeApiImpl(String template) {
        this.template = template;
    }


    @Override
    public Response getWelcomeMessage(String firstName, String lastName) {
        Message message = new Message();
        message.setCode("0000");
        String welcomeMessage = String.format(this.template, firstName + " " + lastName);
        message.setContent(welcomeMessage);
        return Response.ok(message).build();
    }
}
