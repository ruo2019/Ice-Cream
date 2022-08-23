package com.example.icecream.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private var _name = MutableLiveData("")
    val name: LiveData<String>
        get() = _name

    private var _scoops = MutableLiveData(0)
    val scoops: LiveData<Int>
        get() = _scoops

    private var _flavor = MutableLiveData<String>()
    val flavor: LiveData<String>
        get() = _flavor

    var iceCreamNum = 0

    fun setScoops(numScoops: Int) {
        _scoops.value = numScoops
    }

    fun setName(name: String) {
        _name.value = name
    }

    fun setFlavor(flavor: String) {
        if (iceCreamNum< _scoops.value!!) {
            iceCreamNum++
            _flavor.value = flavor
        }
    }

    fun noScoopsYet(): Boolean {
        return _scoops.value == 0
    }
}