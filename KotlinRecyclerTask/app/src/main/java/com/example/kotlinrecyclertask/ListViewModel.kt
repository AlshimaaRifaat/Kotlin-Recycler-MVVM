package com.example.kotlinrecyclertask

import android.app.Service
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

//import javax.swing.UIManager.put


class ListViewModel : ViewModel() {


        public var listProductsMutableLiveData: MutableLiveData<List<DataModel>>? = null
        private lateinit var context: Context


        public fun getData(
            count: Int,

            context: Context
        ): LiveData<List<DataModel>> {
            listProductsMutableLiveData = MutableLiveData<List<DataModel>>()
            this.context = context
            getDataValues(count)


            //  return listProductsMutableLiveData
            return listProductsMutableLiveData as MutableLiveData<List<DataModel>>

        }

        private fun getDataValues(count: Int) {
            val apiInterface = ApiClient.getClient()?.create(service::class.java)
            val call = apiInterface?.getListCat(count)
//        call.enqueue(object : retrofit2.Callback<List<DataModel>>)


            call?.enqueue(object : Callback, retrofit2.Callback<List<DataModel>> {
                override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {

                    if (response.code() == 200) {
                        listProductsMutableLiveData?.setValue(response.body()!!)

                    } else {
                        listProductsMutableLiveData?.setValue(null)
                    }
                }

                override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                    listProductsMutableLiveData?.setValue(null)

                }
            })

//
//        call.enqueue(object : Callback<List<DataModel>>() {
//            fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
//
//                if (response.code() === 200) {
//                    listProductsMutableLiveData?.setValue(response.body())
//
//                } else {
//                    listProductsMutableLiveData?.setValue(null)
//                }
//            }
//
//            fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
//                listProductsMutableLiveData?.setValue(null)
//
//            }
//        })

        }
    }


