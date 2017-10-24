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

package com.freedomotic.freedomotic;

import android.content.Intent;
import android.os.Bundle;

import com.freedomotic.freedomotic.model.FDObjectModelHelper;


/**
 * An activity representing a list of object. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ObjectDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ObjectListFragment} and the item details
 * (if present) is a {@link ObjectDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ObjectListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ObjectListActivity extends BaseActivity
        implements ObjectListFragment.Callbacks {


    //protected SpiceManager spiceManager = new SpiceManager(FDSpiceService.class);

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean isTwoPaneDevice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Change the theme to remove the splash screen as soon this is created.
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_list);

        if (findViewById(R.id.object_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.F
            isTwoPaneDevice = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ObjectListFragment) getFragmentManager()
                    .findFragmentById(R.id.object_list))
                    .setActivateOnItemClick(true);
        }
        // TODO: If exposing deep links into your app, handle intents here.
    }

    @Override
    protected void onStart() {
        super.onStart();
        FDObjectModelHelper.getInstance().Start(this);
    }

    @Override
    protected void onStop() {
        FDObjectModelHelper.getInstance().Stop();
        super.onStop();
    }

    /**
     * Callback method from {@link ObjectListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (isTwoPaneDevice) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ObjectDetailFragment.ARG_ITEM_ID, id);
            ObjectDetailFragment fragment = new ObjectDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.object_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ObjectDetailActivity.class);
            detailIntent.putExtra(ObjectDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
