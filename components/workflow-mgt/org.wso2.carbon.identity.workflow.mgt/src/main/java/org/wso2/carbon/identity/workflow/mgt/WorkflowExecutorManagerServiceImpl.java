package org.wso2.carbon.identity.workflow.mgt;

import org.wso2.carbon.identity.workflow.mgt.bean.WorkflowAssociation;
import org.wso2.carbon.identity.workflow.mgt.dao.WorkflowRequestAssociationDAO;
import org.wso2.carbon.identity.workflow.mgt.dao.WorkflowRequestDAO;
import org.wso2.carbon.identity.workflow.mgt.dto.WorkflowRequest;
import org.wso2.carbon.identity.workflow.mgt.exception.InternalWorkflowException;
import org.wso2.carbon.identity.workflow.mgt.exception.WorkflowException;

import java.util.List;

public class WorkflowExecutorManagerServiceImpl implements WorkflowExecutorManagerService{

    public void addWorkflowRequest(WorkflowRequest workflow, String currentUser, int tenantId) throws WorkflowException {

        WorkflowRequestDAO workflowRequestDAO = new WorkflowRequestDAO();
        workflowRequestDAO.addWorkflowEntry(workflow, currentUser, tenantId);

    }

    public void addNewRequestRelationship(String relationshipId, String workflowId, String requestId, String status,
                                          int tenantId) throws InternalWorkflowException {

        WorkflowRequestAssociationDAO workflowRequestAssociationDAO = new WorkflowRequestAssociationDAO();
        workflowRequestAssociationDAO.addNewRelationship(relationshipId, workflowId, requestId, status, tenantId);
    }

    public List<WorkflowAssociation> getWorkflowAssociationsForRequest(String eventId, int tenantId)
            throws InternalWorkflowException {

        WorkflowRequestAssociationDAO workflowRequestAssociationDAO = new WorkflowRequestAssociationDAO();
        return workflowRequestAssociationDAO.getWorkflowAssociationsForRequest(eventId, tenantId);
    }

    @Override
    public List<String> getWorkflowStatesOfRequest(String requestId) throws InternalWorkflowException {

        WorkflowRequestAssociationDAO workflowRequestAssociationDAO = new WorkflowRequestAssociationDAO();
        return workflowRequestAssociationDAO.getWorkflowStatesOfRequest(requestId);
    }
}
