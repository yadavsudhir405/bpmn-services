package com.musigma.esp.bpmn.interfaces;

import java.util.Map;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:2:37 PM
 *         Project:bpmn
 */
public interface BpmnRuntimeService {

    void activateProcessInstanceById(String processInstanceId);

    String  startProcessInstanceByKey(String processDefinationId, Map<String,Object> variables);

}
