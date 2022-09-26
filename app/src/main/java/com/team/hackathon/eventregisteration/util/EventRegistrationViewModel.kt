package com.team.hackathon.eventregisteration.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.hackathon.eventregisteration.data.EventDetailsModalClass
import com.team.hackathon.home.data.EventDataModel

class EventRegistrationViewModel:  ViewModel() {
    private val _userState = MutableLiveData<Int>()
    val userState : LiveData<Int>
        get() = _userState
    fun setUserState(state:Int){
        _userState.value=state
    }

    private val _eventId = MutableLiveData<String>()
    val userId : LiveData<String>
        get() = _eventId
    fun setUserId(state:String){
        _eventId.value=state
    }

    private val _userDataEventsDetail = MutableLiveData<EventDetailsModalClass>()
    val userDataEventsDetail: MutableLiveData<EventDetailsModalClass>
        get() = _userDataEventsDetail

    fun fetchUserDataDetail(data :EventDetailsModalClass) {
        _userDataEventsDetail.value=data
    }

    private val _registerDone = MutableLiveData<Int>()
    val registerDone : LiveData<Int>
        get() = _registerDone
    fun setUserExists(state:Int){
        _registerDone.value=state
    }

    private val _userDataEvents = MutableLiveData<EventDataModel>()
    val userDataEvents: MutableLiveData<EventDataModel>
        get() = _userDataEvents

    fun fetchUserData(data :EventDataModel) {
        _userDataEvents.value=data
    }

    private val _paymentRupees = MutableLiveData<String>()
    val paymentRupees : LiveData<String>
        get() = _paymentRupees
    fun setPayment(state:String){
        _paymentRupees.value=state
    }



}