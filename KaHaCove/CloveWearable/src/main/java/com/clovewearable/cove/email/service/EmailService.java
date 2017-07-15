package com.clovewearable.cove.email.service;

import javax.ws.rs.core.MediaType;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.clovewearable.cove.model.Email;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * @author Rajendaran
 *
 */

@Service
public class EmailService {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Value("${email.mailgun.apiKey}")
    private String mailgunApiKey;

    @Value("${email.mailgun.host}")
    private String mailgunHost;
    	
    @Value("${email.mailgun.baseurl}")
    private String baseUrl;
           
	public boolean send(Email email) {
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", mailgunApiKey));
		WebResource webResource = client.resource(baseUrl + mailgunHost + "/messages");

		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		formData.add("from", email.getFrom());
		formData.add("to", email.getTo());
		formData.add("subject", email.getSubject());
		formData.add("html", email.getMessage());

		ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, formData);
		String output = clientResponse.getEntity(String.class);

		logger.info("Email sent successfully : " + output);
		return true;
	}

}