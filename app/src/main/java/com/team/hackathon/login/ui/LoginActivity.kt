package com.team.hackathon

import android.os.Bundle
import androidx.activity.viewModels
import com.dietTracker.login.ui.FragmentLoginOtp
import com.dietTracker.login.ui.FragmentLoginPhoneNumber
import com.team.hackathon.login.util.LoginViewModel
import com.team.hackathon.baseActivity.BaseActivity
import com.team.hackathon.login.ui.FragmentSignInWithDetails
import com.team.hackathon.login.ui.FragmentStudentRegistration
import com.team.hackathon.login.ui.FragmentUserValidation

class LoginActivity : BaseActivity(){

    private val viewModel: LoginViewModel by viewModels()

    companion object {
        const val LOGIN_STATE_ENTER_NUMBER = 1
        const val LOGIN_STATE_USER_VALIDATION = 2
        const val LOGIN_STATE_REGISTER_USER = 3
        const val LOGIN_STATE_ENTER_OTP = 4
        const val LOGIN_STATE_SIGN_IN_WITH_DETAILS = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setLoginState(1)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.loginState.observe(this) {
            when (it) {
                LOGIN_STATE_ENTER_NUMBER -> {
                    loginNumber()
                }
                LOGIN_STATE_ENTER_OTP -> {
                    loginOtp()
                }
                LOGIN_STATE_REGISTER_USER -> {
                    loginRegister()
                }
                LOGIN_STATE_USER_VALIDATION -> {
                    loginUserValidation()
                }
                LOGIN_STATE_SIGN_IN_WITH_DETAILS->{
                    signInWithDetails()
                }

            }
        }
    }

//    override fun onBackPressed() {
//        if(backPressOverride())
//            return
//
//        super.onBackPressed()
//    }

//    private fun backPressOverride() : Boolean {
//        when(viewModel.loginState.value){
//            LOGIN_STATE_ENTER_OTP -> {
//                if(viewModel.isUserExist())
//                    viewModel.setLoginState(LOGIN_STATE_ENTER_NUMBER)
//                else
//                    viewModel.setLoginState(LOGIN_STATE_REGISTER_USER)
//                return true
//            }
//            LOGIN_STATE_REGISTER_USER -> {
//                viewModel.setLoginState(LOGIN_STATE_ENTER_NUMBER)
//                return true
//            }
//            LOGIN_STATE_USER_VALIDATION -> {
//                viewModel.setLoginState(LOGIN_STATE_ENTER_NUMBER)
//                return true
//            }
//        }
//        return false
//    }

    private fun loginNumber() {
        startFragment(FragmentLoginPhoneNumber.getInstance(), false)
    }

    private fun loginOtp() {
        startFragment(FragmentLoginOtp.getInstance(), false)
    }

    private fun loginRegister() {
        startFragment(FragmentStudentRegistration.getInstance(), false)
    }

    private fun loginUserValidation() {
        startFragment(FragmentUserValidation.getInstance(), false)
    }
    private fun signInWithDetails(){
        startFragment(FragmentSignInWithDetails.getInstance(),false)
    }

}


