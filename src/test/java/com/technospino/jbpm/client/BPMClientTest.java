package com.technospino.jbpm.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.technospino.jbpm.client.entities.ProcessDefinition;

public class BPMClientTest {

	private static final String JBOSS_HOST ="localhost"; 
	private static final String JBOSS_PORT ="8080";
	private static final String JBPM_USER ="krisv";
	private static final String JBPM_PASSWORD ="krisv";
	private static BPMClient bpmClient;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		bpmClient = new BPMClient(JBOSS_HOST,JBOSS_PORT,JBPM_USER,JBPM_PASSWORD);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bpmClient.login();
	}

	@After
	public void tearDown() throws Exception {
		bpmClient.logout();
		
	}

	@Test
	public void testLogin() {
		assertEquals(true, bpmClient.login());
		
	}

	@Test
	public void testLoginStringString() {
		assertEquals(true,bpmClient.login("admin","admin")); 
	}

	@Test
	public void testLogout() {
		assertEquals(true,bpmClient.logout());
	}

	@Test
	public void testGetToken() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testTransitionToken() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testTransitionDefault() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetProcessDefinition() {
		ProcessDefinition processDefinition = new ProcessDefinition();
		processDefinition.setDeploymentId("N/A");
		processDefinition.setDiagramURL("vfszip:/home/technospino/jbpm-installer/jboss-5.1.0.GA/server/default/deploy/"
			+"jbpm-gwt-console-server.war/WEB-INF/lib/jbpm-gwt-graph-5.1-SNAPSHOT.jar/com.sample.evaluation.png");
		processDefinition.setFormURL("http://localhost:8080/gwt-console-server/rs/form/process/com.sample.evaluation/render");
		processDefinition.setId("com.sample.evaluation");
		processDefinition.setName("Evaluation");
		processDefinition.setPackageName("defaultPackage");
		processDefinition.setVersion("0");
		
		assertEquals(processDefinition, bpmClient.getProcessDefinition("com.sample.evaluation")); // TODO
	}

	@Test
	public void testNewProcessInstance() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetProcessInstances() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveProcessDefinition() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetProcessInstance() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDeleteProcessInstance() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetProcessInstanceDataSet() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTask() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReleaseTask() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAssignTask() {
		fail("Not yet implemented"); // TODO
	}

}
