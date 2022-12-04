package com.example.mvparch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvparch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(MainActivityButtonsEnum.FIRST)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(MainActivityButtonsEnum.SECOND)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(MainActivityButtonsEnum.THIRD)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: MainActivityButtonsEnum) {
        with(binding) {
            when (position) {
                MainActivityButtonsEnum.FIRST -> tvText1.text = counter
                MainActivityButtonsEnum.SECOND -> tvText2.text = counter
                MainActivityButtonsEnum.THIRD -> tvText3.text = counter
                else -> {
                    //do nothing
                }
            }
        }
    }
}