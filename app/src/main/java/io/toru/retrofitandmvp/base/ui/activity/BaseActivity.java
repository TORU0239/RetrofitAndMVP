package io.toru.retrofitandmvp.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.toru.retrofitandmvp.base.presenter.BasePresenter;

/**
 * Created by toru on 2016. 8. 11..
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected BasePresenter basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
    }

    public abstract int getLayoutID();
    public abstract void setPresenter();
    public abstract void setInitFragment();
}
