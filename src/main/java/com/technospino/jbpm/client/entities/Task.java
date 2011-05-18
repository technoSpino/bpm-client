package com.technospino.jbpm.client.entities;

public class Task {

	private int id;
	private String processInstanceId;
	private String processId;
	private String name;
	private String assignee;
	private boolean isBlocking;
	private boolean isSignaling;
	private String[] outcomes;
	private String currantState;
	private String[] participantUsers;
	private String[] participantGroups;
	private String url;
	private int priority;
	
	public Task(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public boolean isBlocking() {
		return isBlocking;
	}

	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}

	public boolean isSignaling() {
		return isSignaling;
	}

	public void setSignaling(boolean isSignaling) {
		this.isSignaling = isSignaling;
	}

	public String[] getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(String[] outcomes) {
		this.outcomes = outcomes;
	}

	public String getCurrantState() {
		return currantState;
	}

	public void setCurrantState(String currantState) {
		this.currantState = currantState;
	}

	public String[] getParticipantUsers() {
		return participantUsers;
	}

	public void setParticipantUsers(String[] participantUsers) {
		this.participantUsers = participantUsers;
	}

	public String[] getParticipantGroups() {
		return participantGroups;
	}

	public void setParticipantGroups(String[] participantGroups) {
		this.participantGroups = participantGroups;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
