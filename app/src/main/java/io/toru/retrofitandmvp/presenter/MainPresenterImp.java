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

    @Override
    public void onClick() {
        mainView.onWriteTextView();
    }
}