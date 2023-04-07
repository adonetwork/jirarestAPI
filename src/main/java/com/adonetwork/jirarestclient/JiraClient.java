package com.adonetwork.jirarestclient;

import java.net.URI;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JiraClient {
    /**
     * Client JIRA
     * @author adonorio
     */

     private final static String URLJIRASERVER = "https://adonetwork.atlassian.net/";
     private final static String TOKEN = "ATATT3xFfGF08Eyfgty6ZRnUNS1bgWFKUGxJOjFzDis1IcGpsJKUryBVCJmwcFPZ6hV7097IiSxBG0U2K2S_KFhdLaTDEn2yraZjthfzKtsmE4IngIueIr_m7TK30-o9sVVBR2Cp_Ug6KIIQ-HYTB6osgsL0EOHSQFlnymsoAM4NvqbuVig29SA=A2A31DA4";

     // Membres
     private String username;
     private JiraRestClient client;

     // Constructeurs
     public JiraClient (String name) {
        this.username = name;

        // Création du client JIRA 
        this.client = this.getJiraRestClient();

     }

     // Methodes
     private JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory()
        .createWithBasicHttpAuthentication(getJiraUri(), this.username, TOKEN);

   
        
        

      
    }

    private URI getJiraUri() {
        return URI.create(URLJIRASERVER);
    }
}
