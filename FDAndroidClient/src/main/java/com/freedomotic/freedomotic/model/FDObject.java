/*
 * Copyright (c) 2009-2014 Freedomotic team http://freedomotic.com
 *
 * This file is part of Freedomotic
 *
 * This Program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2, or (at your option) any later version.
 *
 * This Program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Freedomotic; see the file COPYING. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.freedomotic.freedomotic.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO that represent a FD Object
 */
public class FDObject {

    private String name;
    private String description;
    private String uuid;
    private String protocol;
    private String phisicalAddress;
    private String type;
    private String actAs;
    private Integer currentRepresentation;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPhisicalAddress() {
        return phisicalAddress;
    }

    public void setPhisicalAddress(String phisicalAddress) {
        this.phisicalAddress = phisicalAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActAs() {
        return actAs;
    }

    public void setActAs(String actAs) {
        this.actAs = actAs;
    }

    public Integer getCurrentRepresentation() {
        return currentRepresentation;
    }

    public void setCurrentRepresentation(Integer currentRepresentation) {
        this.currentRepresentation = currentRepresentation;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof FDObject)) return false;
        FDObject otherFDObject = (FDObject) other;
        return this.getUuid().equals(otherFDObject.getUuid());
    }

    @SuppressWarnings("serial")
    public static class List extends ArrayList<FDObject> {

        public FDObject findByUUID(String uuid) {

            for (FDObject fdobject : this) {
                if (fdobject.getUuid().equals(uuid))
                    return fdobject;
            }
            return null;
        }
    }


}