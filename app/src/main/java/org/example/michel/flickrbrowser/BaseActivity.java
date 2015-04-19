package org.example.michel.flickrbrowser;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by michel on 19/04/15.
 */
public class BaseActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    protected Toolbar activateToolbar() {

        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.app_bar);
            if (mToolbar != null) {
                setSupportActionBar(mToolbar);
            }
        }
        return mToolbar;
    }
}
