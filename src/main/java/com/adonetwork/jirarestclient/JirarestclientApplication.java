package com.adonetwork.jirarestclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class JirarestclientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JirarestclientApplication.class, args);
	}

	@Override
    public void run(String... args) {
       log.info("Lancement Client JIRA API REST ....");

	   // Création du client JIRA
	   log.info("Création du client JIRA");
	   JiraClient myClient = new JiraClient("alain.donorio@icloud.com");
	

	   // Lecture du ticket JIRA
	   log.info("Lecture d'un ticket");
		Issue myTicket = myClient.getClient().getIssueClient().getIssue("TST-1").claim();
		System.out.println("Description : "+ myTicket.getDescription());
		System.out.println("Résumé : " + myTicket.getSummary());
		System.out.println("Statut : "+ myTicket.getStatus().getName());
 
		// Mise à jour d'un ticket JIRA
		IssueInput myInput = new IssueInputBuilder().setDescription("Nouvelle Description").build();
		myClient.getClient().getIssueClient().updateIssue("TST-1", myInput);

		// Création d'un ticket JIRA
		log.info("Création d'un ticket");
		IssueRestClient issueClient = myClient.getClient().getIssueClient();
		IssueInput newIssue = new IssueInputBuilder("TST",10001L,"Mon nouveau Ticket Suite").build();	  
		issueClient.createIssue(newIssue).claim();
    }

}
