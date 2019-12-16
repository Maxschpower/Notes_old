package com.nnnshei.notes.presenter

import moxy.MvpPresenter
import moxy.MvpView

class BasePresenter<T : MvpView> : MvpPresenter<T>() {

}