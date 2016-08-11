package io.toru.retrofitandmvp.presenter;

import io.toru.retrofitandmvp.view.MainView;

/**
 * Created by toru on 2016. 8. 11..
 */
public class MainPresenterImp implements MainPresenter {
    private MainView mainView;

    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
    }

    // click action 의 핸들링
    @Override
    public void onClick() {
        mainView.onWriteTextView();
    }

    // view initializing.
    @Override
    public void onInitView() {
        mainView.onInitView();
    }
}