/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.batch.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest;

/**
 * Request for invoking a device command for multiple devices.
 */
@JsonInclude(Include.NON_NULL)
public class BatchCommandInvocationRequest extends PersistentEntityCreateRequest
	implements IBatchCommandInvocationRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = -8215264923380389864L;

    /** Device type token for command */
    private String deviceTypeToken;

    /** Token for command to be executed */
    private String commandToken;

    /** Values for command parameters */
    private Map<String, String> parameterValues = new HashMap<String, String>();

    /** List of targeted device tokens */
    private List<String> deviceTokens;

    /*
     * @see
     * com.sitewhere.spi.batch.request.invocation.IBatchCommandInvocationRequest#
     * getDeviceTypeToken()
     */
    @Override
    public String getDeviceTypeToken() {
	return deviceTypeToken;
    }

    public void setDeviceTypeToken(String deviceTypeToken) {
	this.deviceTypeToken = deviceTypeToken;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest#
     * getCommandToken()
     */
    @Override
    public String getCommandToken() {
	return commandToken;
    }

    public void setCommandToken(String commandToken) {
	this.commandToken = commandToken;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest#
     * getParameterValues()
     */
    @Override
    public Map<String, String> getParameterValues() {
	return parameterValues;
    }

    public void setParameterValues(Map<String, String> parameterValues) {
	this.parameterValues = parameterValues;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest#
     * getDeviceTokens()
     */
    @Override
    public List<String> getDeviceTokens() {
	return deviceTokens;
    }

    public void setDeviceTokens(List<String> deviceTokens) {
	this.deviceTokens = deviceTokens;
    }

    /**
     * Get new builder class.
     * 
     * @return
     */
    public static Builder newBuilder() {
	return new Builder();
    }

    public static class Builder {

	/** Build object */
	private BatchCommandInvocationRequest build;

	private Builder() {
	    super();
	    this.build = new BatchCommandInvocationRequest();
	    withToken(UUID.randomUUID().toString());
	}

	public Builder withToken(String token) {
	    this.build.setToken(token);
	    return this;
	}

	public Builder withDeviceTypeToken(String deviceTypeToken) {
	    this.build.setDeviceTypeToken(deviceTypeToken);
	    return this;
	}

	public Builder withCommandToken(String commandToken) {
	    this.build.setCommandToken(commandToken);
	    return this;
	}

	public Builder withDeviceTokens(List<String> deviceTokens) {
	    if (this.build.getDeviceTokens() == null) {
		this.build.setDeviceTokens(new ArrayList<String>());
	    }
	    this.build.getDeviceTokens().addAll(deviceTokens);
	    return this;
	}

	public Builder withDeviceToken(String deviceToken) {
	    withDeviceTokens(Collections.singletonList(deviceToken));
	    return this;
	}

	public Builder withParameter(String name, String value) {
	    this.build.getParameterValues().put(name, value);
	    return this;
	}

	public BatchCommandInvocationRequest build() {
	    return this.build;
	}
    }
}