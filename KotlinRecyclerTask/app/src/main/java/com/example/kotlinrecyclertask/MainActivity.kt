package com.example.kotlinrecyclertask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

import android.app.PendingIntent.getActivity

import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
/*import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData*/
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
/*import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData*/
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.lifecycle.Observer
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
/*import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData*/
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {



  //val listViewModel: ListViewModel? = null


   // var listAdapter: ListAdapter? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewModel: ListViewModel = ViewModelProviders.of(this)[ListViewModel::class.java]




        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        listViewModel.getData(100,applicationContext).observe(this,
            Observer<List<DataModel>> { datamodel ->
                if (datamodel != null) {
                    val listAdapter  = ListAdapter(datamodel)
                   // listAdapter.onClickItemLatestProduct(this@MainActivity)
                        recyclerView.setLayoutManager(
                            LinearLayoutManager(
                               applicationContext
                            )
                        )
                        recyclerView.setAdapter(listAdapter)

                }
            })


    }

}
