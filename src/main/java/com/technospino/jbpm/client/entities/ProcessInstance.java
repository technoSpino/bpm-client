package com.technospino.jbpm.client.entities;

public class ProcessInstance {
	private String id;
	private String definitionId;
	private String startDate;
	private boolean suspended;
	private Token rootToken;
	
	public ProcessInstance(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public Token getRootToken() {
		return rootToken;
	}

	public void setRootToken(Token rootToken) {
		this.rootToken = rootToken;
	}
	
	
}
