A Client for jbpm-server

Example:

BPMClient bpmClient = new BPMClient(JBOSS_HOST,JBOSS_PORT,JBPM_USER,JBPM_PASSWORD);
bpmClient.login();
ProcessDefinition processDefinition = bpmClient.getProcessDefinition("com.sample.evaluation");

