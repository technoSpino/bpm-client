package com.technospino.jbpm.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.technospino.jbpm.client.entities.ProcessDefinition;
import com.technospino.jbpm.client.entities.ProcessInstance;
import com.technospino.jbpm.client.entities.Task;
import com.technospino.jbpm.client.entities.Token;

/**
 * This class acts as a gateway to the bpm gwt server
 * @author technospino
 *
 */
public class BPMClient {

	private static final String DEFINITIONS_URL = "http://localhost:8080/gwt-console-server/rs/process/definitions";
	private static final String SID_INVALIDATE_URL = "http://localhost:8080/gwt-console-server/rs/identity/sid/invalidate";
	private static final String J_SECURITY_CHECK_URL = "http://localhost:8080/gwt-console-server/rs/identity/secure/j_security_check";
	private static final String SID_URL = "http://localhost:8080/gwt-console-server/rs/identity/secure/sid/";
	private static final String USER_FIELD = "j_username";
	private static final String PASS_FIELD = "j_password";
	
	private String host;
	private String userName;
	private String password;
	private int port;
	
	private HttpClient httpClient = new DefaultHttpClient();
	
	/**
	 * Creates an instance of the BPMClient
	 * @param host
	 * @param username
	 * @param password
	 * @param port
	 */
	public BPMClient(String host, String port,String userName, String password ){
		this.host = host;
		this.userName = userName;
		this.password = password;
		this.port = Integer.parseInt(port);
	}
	
	
	/**
	 * Creates an instance of the BPMClient with the port set to default 8080
	 * @param host
	 * @param username
	 * @param password
	 */
	public BPMClient(String host, String userName, String password){
		this.host = host;
		this.userName = userName;
		this.password = password;
		this.port = 8080;
	}
	
	
	/**
	 * Creates an instance with default port 8080 and assumes userName
	 * and password will be set manually
	 */
	public BPMClient(String host){
		this.host = host;
	}
	
	/**
	 * Creates an instance and assumes userName
	 * and password will be set manually
	 */
	public BPMClient(String host,String port){
		this.host = host;
		this.port = Integer.parseInt(port);
	}
	
	
	public boolean login() {
		HttpGet  httpGet = new HttpGet(SID_URL);
		HttpPost httpPost = new HttpPost(J_SECURITY_CHECK_URL);
		HttpResponse response = null;
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair(USER_FIELD, userName));
		nvps.add(new BasicNameValuePair(PASS_FIELD, password));
		
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			
			response = httpClient.execute(httpGet);
			EntityUtils.consume(response.getEntity());
			
			response = httpClient.execute(httpPost);
			EntityUtils.consume(response.getEntity());
			
			response = httpClient.execute(httpGet);
			String sessionId =EntityUtils.toString(response.getEntity());
			
			String cookieId =""; 
			List<Cookie> cookies = ((AbstractHttpClient) httpClient).getCookieStore().getCookies();
			for (Cookie cookie: cookies){
				if (cookie.getName().equals("JSESSIONID")){
					cookieId = cookie.getValue();
				}
			}
			
			if(sessionId!= null && sessionId.equals(cookieId) ){
				return true;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
	
	public boolean login(String userName, String password){
		setUserName(userName);
		setPassword(password);
		return login();
	}
	
	public boolean logout(){
		HttpPost httpPost = new HttpPost(SID_INVALIDATE_URL);
		HttpResponse response = null;
		
		try {
			response = httpClient.execute(httpPost);
			EntityUtils.consume(response.getEntity());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() == 200){
			return true;
		}
		return false;
	}
	
	//****************
	// Token Actions
	//****************
	public Token getToken(String id){
		//TODO Implement
		return null;
	}
	
	public boolean transitionToken(String tokenId){
		return false;
	}
	
	public boolean transitionDefault(){
		return false;
	}
	
	//**************************
	// ProcessDefinition Actions
	//**************************
	public ProcessDefinition getProcessDefinition(String processDefinitionId){
		for (ProcessDefinition processDefinition : getProcessDefinitions()){
			if (processDefinition.getId().equals(processDefinitionId))
				return processDefinition;
		}
		return null;
	}
	
	public List<ProcessDefinition> getProcessDefinitions(){
		HttpGet  httpGet = new HttpGet(DEFINITIONS_URL);
		HttpResponse response = null;
		JSONObject responseBody = null;
		List<ProcessDefinition> processDefinitions = new ArrayList<ProcessDefinition>();
		try {
			response = httpClient.execute(httpGet);
			responseBody = new JSONObject(EntityUtils.toString(response.getEntity()));
			JSONArray jsonArray = responseBody.getJSONArray("definitions");
			
			for (int i = 0; i< jsonArray.length(); i++){
				processDefinitions.add(parseProcessDefinitionJSON(jsonArray.getJSONObject(i)));
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processDefinitions;
	}
	

	public boolean newProcessInstance(String processDefinitionId){
		//TODO Implement
		return false;
	}
	
	public List<ProcessInstance> getProcessInstances(String processDefinitionId){
		//TODO Implement
		return null;
	}
	
	public boolean removeProcessDefinition(String processDefinitionId){
		//TODO Implement
		return false;
		
	}
	
	//**************************
	// ProcessInstance Actions
	//**************************
	public ProcessInstance getProcessInstance(String processInstanceId){
		//TODO Implement
		return null;
	}
	
	public boolean deleteProcessInstance(String processInstanceId){
		
		return false;
	} 
	
	public Map<String,Object> getProcessInstanceDataSet(String processInstanceId){
		//TODO Implement
		return null;
	}
	
	
	
	//**************************
	// Task Actions
	//**************************
	public Task getTask(String userID){
		//TODO Implement
		return null;
	}
	
	public boolean releaseTask(String taskId){
		
		return false;
	}
	
	public boolean assignTask(String taskId, String userId){
		
		return false;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public HttpClient getHttpClient() {
		return httpClient;
	}


	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}
	
	
	//***************************
	// Form Actions
	//***************************
//	public Form assignTaskForm(String taskId){
//		
//		return false;
//	}
	
	private ProcessDefinition parseProcessDefinitionJSON(JSONObject jsonObject) throws JSONException {
		ProcessDefinition processDefinition = new ProcessDefinition();
		processDefinition.setDeploymentId(jsonObject.getString("deploymentId"));
		processDefinition.setDiagramURL(jsonObject.getString("diagramUrl"));
		processDefinition.setFormURL(jsonObject.getString("formUrl"));
		processDefinition.setId(jsonObject.getString("id"));
		processDefinition.setName(jsonObject.getString("name"));
		processDefinition.setPackageName(jsonObject.getString("packageName"));
		processDefinition.setVersion(jsonObject.getString("version"));
		return processDefinition;
	}
}
