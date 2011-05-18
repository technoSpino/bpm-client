package com.technospino.jbpm.client.entities;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProcessDefintionTest {

	ProcessDefinition processDefinition1, processDefinition2, processDefinition3;
	@Before
	public void setUp(){
		processDefinition1 = new ProcessDefinition();
		processDefinition1.setDeploymentId("deploymentId");
		processDefinition1.setDiagramURL("diagramURL");
		processDefinition1.setFormURL("formURL");
		processDefinition1.setId("id");
		processDefinition1.setName("name");
		processDefinition1.setPackageName("packageName");
		processDefinition1.setVersion("version");
		
		processDefinition2 = new ProcessDefinition();
		processDefinition2.setDeploymentId("deploymentId");
		processDefinition2.setDiagramURL("diagramURL");
		processDefinition2.setFormURL("formURL");
		processDefinition2.setId("id");
		processDefinition2.setName("name");
		processDefinition2.setPackageName("packageName");
		processDefinition2.setVersion("version");
		
		processDefinition3 = new ProcessDefinition();
		processDefinition3.setDeploymentId("deploymentId2");
		processDefinition3.setDiagramURL("diagramURL2");
		processDefinition3.setFormURL("formURL2");
		processDefinition3.setId("id2");
		processDefinition3.setName("name2");
		processDefinition3.setPackageName("packageName2");
		processDefinition3.setVersion("version2");
	}
	
	@After
	public void tearDown(){
		processDefinition1 = null;
		processDefinition2 = null;
		processDefinition3 = null;
	}
	
	@Test
	public void testHashCode() {
		assertTrue(processDefinition2.hashCode() == processDefinition1.hashCode());
		assertTrue(processDefinition2.hashCode() == processDefinition2.hashCode());
		assertTrue(processDefinition2.hashCode() != processDefinition3.hashCode());
	}

	@Test
	public void testGetId() {
		assertEquals("id", processDefinition1.getId()); 
	}

	@Test
	public void testSetId() {
		assertEquals("id", processDefinition1.getId());  
		processDefinition1.setId("id33");
		assertEquals("id33", processDefinition1.getId());  
	}

	@Test
	public void testGetName() {
		assertEquals("name", processDefinition1.getName());  
	}

	@Test
	public void testSetName() {
		assertEquals("name", processDefinition1.getName());  
		processDefinition1.setName("name33");
		assertEquals("name33", processDefinition1.getName()); 
	}

	@Test
	public void testGetVersion() {
		assertEquals("version", processDefinition1.getVersion()); 
	}

	@Test
	public void testSetVersion() {
		assertEquals("version", processDefinition1.getVersion());  
		processDefinition1.setVersion("version33");
		assertEquals("version33", processDefinition1.getVersion()); 
	}

	@Test
	public void testGetPackageName() {
		assertEquals("packageName", processDefinition1.getPackageName());   
	}

	@Test
	public void testSetPackageName() {
		assertEquals("packageName", processDefinition1.getPackageName());  
		processDefinition1.setPackageName("packageName12");
		assertEquals("packageName12", processDefinition1.getPackageName()); 
		
	}

	@Test
	public void testGetDeploymentId() {
		assertEquals("deploymentId", processDefinition1.getDeploymentId());  
		processDefinition1.setDeploymentId("deploymentId33");
		assertEquals("deploymentId33", processDefinition1.getDeploymentId()); 
	}

	@Test
	public void testSetDeploymentId() {
		assertEquals("deploymentId", processDefinition1.getDeploymentId());  
		processDefinition1.setDeploymentId("deploymentId33");
		assertEquals("deploymentId33", processDefinition1.getDeploymentId()); 
	}

	@Test
	public void testGetFormURL() {
		assertEquals("formURL", processDefinition1.getFormURL()); 
	}

	@Test
	public void testSetFormURL() {
		assertEquals("formURL", processDefinition1.getFormURL());  
		processDefinition1.setFormURL("formURL33");
		assertEquals("formURL33", processDefinition1.getFormURL()); 
	}

	@Test
	public void testGetDiagramURL() {
		assertEquals("diagramURL", processDefinition1.getDiagramURL()); 
	}

	@Test
	public void testSetDiagramURL() {
		assertEquals("diagramURL", processDefinition1.getDiagramURL());  
		processDefinition1.setDiagramURL("diagramURL2");
		assertEquals("diagramURL2", processDefinition1.getDiagramURL()); 
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true,processDefinition1.equals(processDefinition2)); // TODO
	}

}
