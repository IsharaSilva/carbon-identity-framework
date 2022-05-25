package org.wso2.carbon.identity.workflow.mgt;

import org.wso2.carbon.identity.workflow.mgt.bean.WorkflowAssociation;
import org.wso2.carbon.identity.workflow.mgt.dto.WorkflowRequest;
import org.wso2.carbon.identity.workflow.mgt.exception.InternalWorkflowException;
import org.wso2.carbon.identity.workflow.mgt.exception.WorkflowException;

import java.util.List;

public interface WorkflowExecutorManagerService {

    /**
     * Add new workflow request.
     *
     * @param workflow    workflow object.
     * @param currentUser Currently logged-in user.
     * @param tenantId    TenantID.
     * @throws WorkflowException
     */
    void addWorkflowRequest(WorkflowRequest workflow, String currentUser, int tenantId) throws WorkflowException;

    /**
     * Adds new workflow-request relationship.
     *
     * @param relationshipId relationship id.
     * @param workflowId     workflow id.
     * @param requestId      workflow request id.
     * @param status         approval status EX: pending, approved.
     * @param tenantId       tenantID.
     * @throws InternalWorkflowException
     */
    void addNewRequestRelationship(String relationshipId, String workflowId, String requestId, String status,
                                   int tenantId) throws InternalWorkflowException;

    /**
     * Get association details related to eventID
     *
     * @param eventId  Event to associate.
     * @param tenantId TenantID.
     * @return
     * @throws InternalWorkflowException
     */
    List<WorkflowAssociation> getWorkflowAssociationsForRequest(String eventId, int tenantId)
            throws InternalWorkflowException;

    List<String> getWorkflowStatesOfRequest(String requestId) throws InternalWorkflowException;
}
