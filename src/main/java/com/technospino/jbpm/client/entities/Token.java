package com.technospino.jbpm.client.entities;

public class Token {

	private String id;
	private String name;
	private String currentNodeName;
	private String[] children;
	private String[] availableSignals;
	private boolean canBeSignaled;
	
	public Token(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentNodeName() {
		return currentNodeName;
	}

	public void setCurrentNodeName(String currentNodeName) {
		this.currentNodeName = currentNodeName;
	}

	public String[] getChildren() {
		return children;
	}

	public void setChildren(String[] children) {
		this.children = children;
	}

	public String[] getAvailableSignals() {
		return availableSignals;
	}

	public void setAvailableSignals(String[] availableSignals) {
		this.availableSignals = availableSignals;
	}

	public boolean isCanBeSignaled() {
		return canBeSignaled;
	}

	public void setCanBeSignaled(boolean canBeSignaled) {
		this.canBeSignaled = canBeSignaled;
	}
	
	@Override
	public boolean equals(Object that) {
		//TODO make more robust
		
		if (this == that)
			return true;
		
		if (!(that instanceof Token))
			return false;
		
		Token thatToken = (Token) that;
		if (this.id.equals(thatToken.getId()))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int seed = 200394;
		int result = 0;
		
		result += this.id.hashCode()+seed;
		result += this.currentNodeName.hashCode()+seed;
		
		return result;
	}
}
