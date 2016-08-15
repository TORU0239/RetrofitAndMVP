package io.toru.retrofitandmvp.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import io.toru.retrofitandmvp.R;
import io.toru.retrofitandmvp.base.ui.activity.BaseActivity;
import io.toru.retrofitandmvp.presenter.MainPresenter;
import io.toru.retrofitandmvp.presenter.MainPresenterImp;
import io.toru.retrofitandmvp.ui.fragment.MainFragment;
import io.toru.retrofitandmvp.view.MainView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_container)
    RelativeLayout containerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setInitFragment();
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void setPresenter() {}

//    @OnClick(R.id.main_button)
//    public void click(View view){
//        ((MainPresenterImp)basePresenter).onClick();
//    }
//
//    @Override
//    public void setPresenter() {
//        basePresenter = new MainPresenterImp(this);
//        basePresenter.onInitView();
//    }
//
//    @Override
//    public void onInitView() {
//        // view 의 initialization. 아직은 아무것도 하지 않는다
//    }

    @Override
    public void setInitFragment() {
        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
    }

//    @Override
//    public void onWriteTextView() {
//    }
}