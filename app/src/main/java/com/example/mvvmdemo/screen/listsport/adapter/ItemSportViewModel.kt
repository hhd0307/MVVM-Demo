package com.example.mvvmdemo.screen.listsport.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.data.model.Sport

class ItemSportViewModel() : BaseObservable() {

    @Bindable
    var sport: Sport? = null
        set(value) {
            field = value
            notifyChange()
        }
}
