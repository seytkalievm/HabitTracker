package com.example.habittracker.authorization

import android.os.Bundle
import android.security.NetworkSecurityPolicy
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.habittracker.databinding.FragmentRegisterBinding
import com.example.habittracker.network.AuthorizeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private var _response = MutableLiveData<String>()
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    val response: LiveData<String>
        get() = _response

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    fun init() {
        getRegisterResponse()
        binding.fragmentRegisterTw.text = response.value

    }

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private fun getRegisterResponse() {

//        AuthorizeApi.retrofitService.getAuthorization(
//            RegistrationForm(
//                "1111",
//                "1111",
//                "11",
//                "111",
//                "111111"
//            )
//        )

        AuthorizeApi.retrofitService.loginUser(
            "1111", "111111"
        ).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                response.body()?.let { Log.e("Succ", it) }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure" + t.message
                Log.e("Error", t.message!!)
                Log.e(
                    "Error",
                    NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted.toString()
                )
            }

        })

    }


}