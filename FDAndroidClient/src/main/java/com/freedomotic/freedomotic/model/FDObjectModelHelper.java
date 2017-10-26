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

import com.freedomotic.freedomotic.bus.FDObjectsLoadedEvent;
import com.freedomotic.freedomotic.bus.FDObjectsRequestLoad;
import com.freedomotic.freedomotic.network.request.ObjectsRequest;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import de.greenrobot.event.EventBus;

/**
 * Class that provide the mechanism to maintain updated the local instance of the FD Objects list
 */
public class FDObjectModelHelper extends ModelHelper {

    private static FDObjectModelHelper INSTANCE = null;
    ObjectsRequest objectRequest;
    private FDObject.List fbObjectsList;

    private FDObjectModelHelper() {
        super();
        objectRequest = new ObjectsRequest();
    }

    public static FDObjectModelHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FDObjectModelHelper();
        }
        return INSTANCE;
    }

    public void onEvent(FDObjectsRequestLoad event) {
        spiceManager.getFromCacheAndLoadFromNetworkIfExpired(objectRequest, "objects", DurationInMillis.ONE_MINUTE, new ListObjectRequestListener());
    }

    public FDObject.List getFDObjectsList() {
        return fbObjectsList;
    }


    private final class ListObjectRequestListener implements RequestListener<FDObject.List> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
        }

        @Override
        public void onRequestSuccess(final FDObject.List result) {
            fbObjectsList = result;
            EventBus.getDefault().postSticky(new FDObjectsLoadedEvent(fbObjectsList));

        }
    }

}
