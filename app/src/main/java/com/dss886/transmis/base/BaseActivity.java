package com.dss886.transmis.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dss886.transmis.R;
import com.dss886.transmis.utils.DisplayUtil;

/**
 * Created by dss886 on 2017/6/30.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            resolveIntentExtra(extra);
        }
        setContentView(getLayout());
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showToolbarBackIcon());
            getSupportActionBar().setTitle(getToolbarTitle());
        }
        ViewCompat.setElevation(mToolbar, DisplayUtil.dip2px(this, 4));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    protected abstract int getLayout();

    protected void resolveIntentExtra(@NonNull Bundle bundle) {}

    protected abstract int getToolbarTitle();

    protected abstract boolean showToolbarBackIcon();
}
