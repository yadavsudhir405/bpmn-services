package test.sudhir;

import java.io.Serializable;

/**
 * @author sudhir
 *         Date:4/12/16
 *         Time:5:48 PM
 *         Project:bpmn-service
 */
public interface BpmnUser extends Serializable {
    String getId();

    void setId(String var1);

    String getFirstName();

    void setFirstName(String var1);

    void setLastName(String var1);

    String getLastName();

    void setEmail(String var1);

    String getEmail();

    String getPassword();

    void setPassword(String var1);

    boolean isPictureSet();
}
