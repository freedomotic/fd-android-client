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

package com.freedomotic.freedomotic.network;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * RoboSpice service to access the Rest api
 */
public class FDSpiceService extends RetrofitGsonSpiceService {

    //TODO: To be moved to configuration
    private final static String BASE_URL = "http://192.168.1.245:9111/v3";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(IFreedomoticApi.class);
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        //TODO: use configuration data
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Authorization", "admin:admin");
            }
        };
        //OkHttpClient okHttpClient = new OkHttpClient();
        //okHttpClient.setSslSocketFactory(getPinnedCertSslSocketFactory(context));

        return new RestAdapter.Builder().setEndpoint(getServerUrl())
                .setRequestInterceptor(requestInterceptor);

    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }
}
