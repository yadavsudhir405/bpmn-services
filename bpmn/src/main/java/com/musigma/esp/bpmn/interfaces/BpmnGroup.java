package com.musigma.esp.bpmn.interfaces;

import java.io.Serializable;

/**
 * @author sudhir
 *         Date:4/12/16
 *         Time:5:53 PM
 *         Project:bpmn-service
 */
public interface BpmnGroup extends Serializable{
    String getId();

    void setId(String var1);

    String getName();

    void setName(String var1);

    String getType();

    void setType(String var1);
}
