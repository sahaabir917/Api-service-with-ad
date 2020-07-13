package com.example.marsapi

import android.os.Bundle
import android.os.Handler


import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiservice3.FootballAdapter
import com.example.apiservice3.R
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.fragment_type.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class FootballFragment : Fragment() {

    var handler: Handler = Handler()
    //list for holding data
    lateinit var list : MutableList<FootballList>
    lateinit var adapter : FootballAdapter
    //Variable for checking progressbar loading or not
    private var isLoading: Boolean = false
    lateinit var layoutManager : LinearLayoutManager



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_type, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://128.199.183.164:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Football::class.java)

        api.getdata().enqueue(object : Callback<FootballList>{
            override fun onFailure(call: Call<FootballList>, t: Throwable) {
                d("Abir","Failed to retrive")
            }

            override fun onResponse(call: Call<FootballList>, response: Response<FootballList>) {
              d("Abir","succcess")
               showAllData(response.body()!!)

            }

        })

    }



    private fun showAllData (footballList: FootballList){
        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = FootballAdapter(footballList)

        }

//
//
//        layoutManager = LinearLayoutManager(activity)
//        //attaches LinearLayoutManager with RecyclerView
//        recyclerview.layoutManager = layoutManager
//
//
//        load()
//        adapter = FootballAdapter(footballList)
//        recyclerview.adapter = adapter
//        addScrollerListener()
//
//
//    }
//
//
//
//
//    private fun addScrollerListener()
//    {
//        //attaches scrollListener with RecyclerView
//        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener()
//        {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int)
//            {
//                super.onScrolled(recyclerView, dx, dy)
//                if (!isLoading)
//                {
//                    //findLastCompletelyVisibleItemPostition() returns position of last fully visible view.
//                    ////It checks, fully visible view is the last one.
//                    if (layoutManager.findLastCompletelyVisibleItemPosition() == list.size - 1)
//                    {
//                        loadMore()
//                        isLoading = true
//                    }
//                }
//            }
//        })
//    }
//    private fun loadMore()
//    {
//        //notify adapter using Handler.post() or RecyclerView.post()
//        handler.post(Runnable
//        {
//
//            adapter.notifyItemInserted(list.size - 1)
//        })
//        handler.postDelayed(Runnable {
//            //removes "load".
//            list.removeAt(list.size - 1)
//            var listSize = list.size
//            adapter.notifyItemRemoved(listSize)
//            //sets next limit
//            var nextLimit = listSize + 10
//            for(i in listSize until nextLimit)
//            {
//
//            }
//            adapter.notifyDataSetChanged()
//            isLoading = false
//        },2500)
//    }
//    private fun load()
//    {
//        for(i in 0..9)
//        {
//
//        }
//    }
}}



