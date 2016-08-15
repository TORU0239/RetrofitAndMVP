package io.toru.retrofitandmvp.kotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.toru.retrofitandmvp.kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView {

    @JvmField
    @Inject
    var mainPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainComponent.builder()
                .mainModule(MainModule(this@MainActivity))
                .build()
                .inject(this)

        main_button.setOnClickListener { mainPresenter?.onClick() }
    }

    override fun setText() {
        main_textview.apply {
            text = "$text.Test!!!"
        }
    }
}