package com.example.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    // Reference of Adapter Class
    private lateinit var adapter: RickRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initializing recycler view
        adapter = RickRecycler()
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter
        RetrofitInstance.api.getDetails().enqueue(object :Callback<RickMorty>{
            override fun onResponse(call: Call<RickMorty>, response: Response<RickMorty>) {
                if (response.body()!=null){
                    adapter.setData(response.body()!!.results)
                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<RickMorty>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }

        })
    }
}