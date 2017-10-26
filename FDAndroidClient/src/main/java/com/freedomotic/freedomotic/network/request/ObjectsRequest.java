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

package com.freedomotic.freedomotic.network.request;

import com.freedomotic.freedomotic.model.FDObject;
import com.freedomotic.freedomotic.network.service.ObjectService;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import roboguice.util.temp.Ln;

/**
 * Retrofit rest request to retrieve the FD objects data from the REST api
 */
public class ObjectsRequest extends RetrofitSpiceRequest<FDObject.List, ObjectService> {

    public ObjectsRequest() {
        super(FDObject.List.class, ObjectService.class);
    }

    @Override
    public FDObject.List loadDataFromNetwork() throws Exception {
        Ln.d("Retrieving Objects from Freedomotic Web Service...");
        return getService().FDObjects();
    }
}
