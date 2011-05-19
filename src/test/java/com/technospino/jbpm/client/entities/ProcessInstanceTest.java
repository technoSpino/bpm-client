package com.technospino.jbpm.client.entities;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProcessInstanceTest {
	
	private ProcessInstance processInstance1, processInstance2;
	private Token token1,token2;
	@Before
	public void setUp() throws Exception {
		
		token1 = new Token();
		token1.setId("1");
		token1.setCanBeSignaled(false);
		token1.setChildren(new String[]{});
		token1.setCurrentNodeName("nodeName");
		token1.setAvailableSignals(new String[]{});
		token1.setName("Token1");
		
		token2 = new Token();
		token2.setId("1");
		token2.setCanBeSignaled(false);
		token2.setChildren(new String[]{});
		token2.setCurrentNodeName("nodeName");
		token2.setName("Token1");
		token2.setAvailableSignals(new String[]{});
		
		processInstance1 = new ProcessInstance();
		processInstance1.setDefinitionId("1");
		processInstance1.setId("22");
		processInstance1.setRootToken(token1);
		processInstance1.setStartDate("2010-20-20");
		processInstance1.setSuspended(false);
		
		processInstance2 = new ProcessInstance();
		processInstance2.setDefinitionId("1");
		processInstance2.setId("22");
		processInstance2.setRootToken(token2);
		processInstance2.setStartDate("2010-20-20");
		processInstance2.setSuspended(false);
	}

	@After
	public void tearDown() throws Exception {
		processInstance1 = null;
		processInstance2 = null;
		token1 = null;
		token2 = null;
	}

	@Test
	public void testHashCode() {
		assertEquals(processInstance1.hashCode(), processInstance2.hashCode());
	}


	@Test
	public void testGetId() {
		assertEquals("22", processInstance1.getId()); 
	}

	@Test
	public void testSetId() {
		assertEquals("22", processInstance1.getId());
		processInstance1.setId("2");
		assertEquals("2", processInstance1.getId());
	}

	@Test
	public void testGetDefinitionId() {
		assertEquals("1", processInstance1.getDefinitionId());
	}

	@Test
	public void testSetDefinitionId() {
		assertEquals("1", processInstance1.getDefinitionId());
		processInstance1.setDefinitionId("2");
		assertEquals("2", processInstance1.getDefinitionId());
	}

	@Test
	public void testGetStartDate() {
		assertEquals("2010-20-20", processInstance1.getStartDate());
	}

	@Test
	public void testSetStartDate() {
		assertEquals("2010-20-20", processInstance1.getStartDate());
		processInstance1.setStartDate("2010-20-12");
		assertEquals("2010-20-12", processInstance1.getStartDate());
	}

	@Test
	public void testIsSuspended() {
		assertEquals(false, processInstance1.isSuspended());
	}

	@Test
	public void testSetSuspended() {
		assertEquals(false, processInstance1.isSuspended());
		processInstance1.setSuspended(true);
		assertEquals(true, processInstance1.isSuspended());
	}

	@Test
	public void testGetRootToken() {
		assertEquals(token1, processInstance1.getRootToken());
	}

	@Test
	public void testSetRootToken() {
		token2 = new Token();
		token2.setId("11");
		token2.setCanBeSignaled(false);
		token2.setChildren(new String[]{});
		token2.setCurrentNodeName("nodeName");
		token2.setName("Token1");
		token2.setAvailableSignals(new String[]{});
		
		assertEquals(token1, processInstance1.getRootToken());
		processInstance1.setRootToken(token2);
		assertEquals(token2, processInstance1.getRootToken());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, processInstance1.equals(processInstance2));
	}

}
