/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.rest.model.area.request.AreaTypeCreateRequest;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class AreaTypeRestTests extends AbstractCRUDRestClientTests<AreaType, AreaTypeCreateRequest> {

    private String areaTypeName = "Test Area Type Name";

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------
    
    @Override
    protected AreaTypeCreateRequest buildCreateRequest(String token) {
	AreaTypeCreateRequest.Builder builder = new  AreaTypeCreateRequest.Builder(token, areaTypeName);
	
	builder.withDescription("Some description");
	
	return builder.build();
    }

    @Override
    protected AreaType createEntity(AreaTypeCreateRequest createRequest) throws SiteWhereException {
	return getClient().createAreaType(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected AreaType findEntityByToken(String token) throws SiteWhereException {
	return getClient().getAreaTypeByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected AreaTypeCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	AreaTypeCreateRequest.Builder builder = new  AreaTypeCreateRequest.Builder(token, areaTypeName);
	
	builder.withDescription("Some updated description");
	
	return builder.build();
    }

    @Override
    protected AreaType updateEntity(String token, AreaTypeCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateAreaType(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected AreaType deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteAreaType(getTenatAuthentication(), token);
    }

}
