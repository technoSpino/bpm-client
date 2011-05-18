package com.technospino.jbpm.client.entities;

public class ProcessDefinition {

	private String id;
	private String name;
	private String version;
	private String packageName;
	private String deploymentId;
	private String formURL;
	private String diagramURL;

	public ProcessDefinition() {
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getFormURL() {
		return formURL;
	}

	public void setFormURL(String formURL) {
		this.formURL = formURL;
	}

	public String getDiagramURL() {
		return diagramURL;
	}

	public void setDiagramURL(String diagramURL) {
		this.diagramURL = diagramURL;
	}

	@Override
	public boolean equals(Object that) {
		//TODO make more robust
		
		if (this == that)
			return true;
		
		if (!(that instanceof ProcessDefinition))
			return false;
		
		ProcessDefinition thatProcessDefintion = (ProcessDefinition) that;
		if (this.id.equals(thatProcessDefintion.getId()) && this.version.equals(thatProcessDefintion.getVersion()))
			return true;
		
		return false;
	}

	@Override
	public int hashCode() {
		int seed = -149;
		int result = 0;
		
		result += this.id.hashCode() + seed;
		result += this.version.hashCode() + seed;
		
		return result;
	}
	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		
		result.append(this.getClass().getName() + " {");
		result.append(" ID: "+ this.id);
		result.append(" Version: "+ this.version);
		result.append(" Name: "+ this.name);
		result.append(" Package: "+ this.packageName);
		result.append("}");
		
		return result.toString();
		
	}
}
