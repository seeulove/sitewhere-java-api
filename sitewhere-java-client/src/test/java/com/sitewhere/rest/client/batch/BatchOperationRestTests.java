/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.batch;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractRestTest;
import com.sitewhere.rest.model.batch.BatchElement;
import com.sitewhere.rest.model.batch.BatchOperation;
import com.sitewhere.rest.model.batch.request.BatchCommandInvocationRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.batch.BatchOperationSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 * Batch Operations API Tests.
 * 
 * @author Jorge Villaverde
 */
public class BatchOperationRestTests extends AbstractRestTest {

    private String batchOperationToken = "someBatchOperationToken";

    @Test
    public void testListBatchOperations() throws SiteWhereException {
	BatchOperationSearchCriteria searchCriteria = new BatchOperationSearchCriteria(1, 1);
	SearchResults<BatchOperation> batchOperations = getClient().listBatchOperations(getTenatAuthentication(),
		searchCriteria);
	assertNotNull(batchOperations);
    }

    @Test
    public void testCreateBatchCommandInvocation() throws SiteWhereException {
	BatchCommandInvocationRequest request = BatchCommandInvocationRequest.newBuilder()
		.withToken(batchOperationToken).withCommandToken("ping").withDeviceToken("15737-UNO-7576364")
		.withParameter("host", "localhost").build();

	BatchOperation batchOperation = getClient().createBatchCommandInvocation(getTenatAuthentication(), request);
	assertNotNull(batchOperation);
    }

    @Test
    public void testGetBatchOperationInvocation() throws SiteWhereException {
	BatchOperation batchOperation = getClient().getBatchOperationByToken(getTenatAuthentication(),
		batchOperationToken);
	assertNotNull(batchOperation);
    }

    @Test
    public void testListBatchOperationElements() throws SiteWhereException {
	SearchResults<BatchElement> batchElements = getClient().listBatchOperationElements(getTenatAuthentication(),
		batchOperationToken);
	assertNotNull(batchElements);
    }

    // @Test
    // public void testCreateBatchCommandOperationForCriteria() throws
    // SiteWhereException {
    // BatchCommandForCriteriaRequest request = new
    // BatchCommandForCriteriaRequest();
    //
    // request.setCommandToken("ping");
    // request.setToken(batchOperationToken);
    //
    // Object command = getClient().createBatchCommandOperationForCriteria(
    // getTenatAuthentication(), request);
    // assertNotNull(command);
    // }
}
