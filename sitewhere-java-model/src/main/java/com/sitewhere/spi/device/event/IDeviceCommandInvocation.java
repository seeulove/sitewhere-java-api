/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event;

import java.util.Map;
import java.util.UUID;

/**
 * Captures information about the invocation of a command.
 */
public interface IDeviceCommandInvocation extends IDeviceEvent {

    /**
     * Get actor type that initiated the command.
     * 
     * @return
     */
    public CommandInitiator getInitiator();

    /**
     * Get unique id of command initiated.
     * 
     * @return
     */
    public String getInitiatorId();

    /**
     * Get actor type that received command.
     * 
     * @return
     */
    public CommandTarget getTarget();

    /**
     * Get unique id of command target.
     * 
     * @return
     */
    public String getTargetId();

    /**
     * Get unique id of device command being invoked.
     * 
     * @return
     */
    public UUID getDeviceCommandId();

    /**
     * Get the list of parameter names mapped to values.
     * 
     * @return
     */
    public Map<String, String> getParameterValues();
}