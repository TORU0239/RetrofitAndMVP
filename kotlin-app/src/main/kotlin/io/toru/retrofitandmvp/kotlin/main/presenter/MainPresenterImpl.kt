package io.toru.retrofitandmvp.kotlin.main.presenter

import io.toru.retrofitandmvp.kotlin.main.MainPresenter
import io.toru.retrofitandmvp.kotlin.main.MainView
import io.toru.retrofitandmvp.kotlin.repository.StackOverFlowApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject


class MainPresenterImpl @Inject constructor(val view: MainView,
                                            val stackOverFlowApi: StackOverFlowApi) : MainPresenter {
    override fun onClick() {
        stackOverFlowApi.loadQuestioniOS("android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setText()
                }, { it.printStackTrace() })
    }
}