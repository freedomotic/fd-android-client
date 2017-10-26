/*
 * Copyright (c) 2009-2017 Freedomotic team http://freedomotic.com
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

package com.freedomotic.freedomotic.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freedomotic.freedomotic.R;
import com.freedomotic.freedomotic.activity.ObjectDetailActivity;
import com.freedomotic.freedomotic.activity.ObjectListActivity;
import com.freedomotic.freedomotic.model.FDObject;

/**
 * A fragment representing a single object detail screen.
 * This fragment is either contained in a {@link ObjectListActivity}
 * in two-pane mode (on tablets) or a {@link ObjectDetailActivity}
 * on handsets.
 */
public class ObjectDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private FDObject fdObject;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ObjectDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            //fdObject = FDObjectModelHelper.getInstance().getFDObjectsList().findByUUID(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_object_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (fdObject != null) {
            ((TextView) rootView.findViewById(R.id.object_detail)).setText(fdObject.getDescription());
        }

        return rootView;
    }
}
