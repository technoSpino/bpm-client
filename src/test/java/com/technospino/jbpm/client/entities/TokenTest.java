package com.technospino.jbpm.client.entities;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TokenTest {
	private Token token1,token2;
	
	@Before
	public void setUp(){
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
	}
	@After
	public void tearDown(){
		token1 = null;
		token2 = null;
	}
	
	@Test
	public void testHashCode() {
		assertEquals(token1.hashCode(),token2.hashCode()); 
	}


	@Test
	public void testGetId() {
		assertEquals("1", token1.getId());
	}

	@Test
	public void testSetId() {
		assertEquals("1", token1.getId());
		token1.setId("2");
		assertEquals("2", token1.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("Token1", token1.getName());
	}

	@Test
	public void testSetName() {
		assertEquals("Token1", token1.getName());
		token1.setName("New Name");
		assertEquals("New Name", token1.getName());
	}

	@Test
	public void testGetCurrentNodeName() {
		assertEquals("1", token1.getId());
	}

	@Test
	public void testSetCurrentNodeName() {
		assertEquals("1", token1.getId());
		token1.setId("2");
		assertEquals("2", token1.getId());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetChildren() {
		assertEquals(new String[] {}, token1.getChildren());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetChildren() {
		assertEquals(new String[] {}, token1.getChildren());
		token1.setChildren(new String[] {"child1","child2"});
		assertEquals(new String[] {"child1","child2"}, token1.getChildren());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetAvailableSignals() {
		assertEquals(new String[] {}, token1.getAvailableSignals());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetAvailableSignals() {
		assertEquals(new String[] {}, token1.getAvailableSignals());
		token1.setAvailableSignals(new String[] {"2","3"});
		assertEquals(new String[] {"2","3"}, token1.getAvailableSignals());
	}

	@Test
	public void testIsCanBeSignaled() {
		assertEquals(false, token1.isCanBeSignaled());
	}

	@Test
	public void testSetCanBeSignaled() {
		assertEquals(false, token1.isCanBeSignaled());
		token1.setCanBeSignaled(true);
		assertEquals(true, token1.isCanBeSignaled());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, token1.equals(token2));
	}

}
