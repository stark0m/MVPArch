package com.example.mvparch

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onCounterClick(id: MainActivityButtonsEnum) {
        var newValue = 0
        when (id) {
            MainActivityButtonsEnum.FIRST -> {
                newValue = model.next(0)
            }
            MainActivityButtonsEnum.SECOND -> {
                newValue = model.next(1)
            }
            MainActivityButtonsEnum.THIRD -> {
                newValue = model.next(2)
            }
            else -> {
                //do nothing
            }
        }
        view.setText(newValue.toString(), id)
    }
}