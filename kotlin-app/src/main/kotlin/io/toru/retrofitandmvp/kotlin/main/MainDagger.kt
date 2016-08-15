package io.toru.retrofitandmvp.kotlin.main

import dagger.Component
import dagger.Module
import dagger.Provides
import io.toru.retrofitandmvp.kotlin.main.presenter.MainPresenterImpl
import io.toru.retrofitandmvp.kotlin.repository.ApiModule


@Component(modules = arrayOf(MainModule::class, ApiModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}


@Module
class MainModule(val view: MainView) {

    @Provides
    fun view() = view

    @Provides
    fun mainPresenter(presenter: MainPresenterImpl): MainPresenter = presenter
}