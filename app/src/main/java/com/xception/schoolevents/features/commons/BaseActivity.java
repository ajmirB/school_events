package com.xception.schoolevents.features.commons;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.xception.schoolevents.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView mToolbarTitleTextView;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        // Default title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setTitle(R.string.app_name);
        setNavigationBackButton(false);
    }

    // region Toolbar

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mToolbarTitleTextView.setText(title);
    }

    /**
     * Enable the navigation back button
     * @param enabled
     */
    protected void setNavigationBackButton(boolean enabled) {
        Drawable backIconDrawable = ContextCompat.getDrawable(this, R.drawable.btn_navigation_back);
        mToolbar.setNavigationIcon(enabled ? backIconDrawable : null);
        mToolbar.setNavigationOnClickListener(enabled ? v -> onBackPressed() : null);
    }

    // endregion
}
