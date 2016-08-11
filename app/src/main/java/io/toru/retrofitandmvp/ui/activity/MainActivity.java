package io.toru.retrofitandmvp.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import io.toru.retrofitandmvp.R;
import io.toru.retrofitandmvp.base.ui.activity.BaseActivity;
import io.toru.retrofitandmvp.presenter.MainPresenter;
import io.toru.retrofitandmvp.presenter.MainPresenterImp;
import io.toru.retrofitandmvp.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.main_textview)
    TextView textView;

    @BindView(R.id.main_button)
    Button button;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.main_button)
    public void click(View view){
        ((MainPresenterImp)basePresenter).onClick();
    }

    @Override
    public void setPresenter() {
        basePresenter = new MainPresenterImp(this);
        basePresenter.onInitView();
    }

    @Override
    public void onInitView() {
        // view 의 initialization. 아직은 아무것도 하지 않는다
    }

    @Override
    public void onWriteTextView() {
        String prevStr = textView.getText().toString();
        textView.setText(prevStr.concat(".").concat("Test!!"));
    }
}