package com.example.selflearning

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.selflearning.model.ListUserModel
import com.example.selflearning.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewScreen : AppCompatActivity(), RVAdaptor.ItemClickListener {

    private var adaptor: RVAdaptor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_screen)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        //set layout of our recyclerView as linear
        recyclerView.layoutManager = LinearLayoutManager(this)

        //below code is for gridView
        //recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Set the click listener for the adapter
        adaptor = RVAdaptor()
        adaptor?.setItemClickListener(this)

        //we need adapter and viewHolder for Recycler View
        getDataList()

        //set Adaptor
        recyclerView.adapter = adaptor
    }

    //we will fetch data in Array<String>


    fun getDataList() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please Wait while Data is fetch")
        progressDialog.show()

        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<ListUserModel?> {
            override fun onResponse(
                call: Call<ListUserModel?>,
                response: Response<ListUserModel?>
            ) {
                progressDialog.dismiss()

                adaptor?.setItems(response.body()!!)
            }

            override fun onFailure(call: Call<ListUserModel?>, t: Throwable) {
                Toast.makeText(this@RecyclerViewScreen, t.localizedMessage, Toast.LENGTH_SHORT)
                    .show()

                progressDialog.dismiss()
            }
        })

    }

    override fun onItemClick(itemId: String) {

        Log.e(itemId, "test Id")
        // Navigate to the next screen and pass the clicked item ID as an extra
        val intent = Intent(this, SingleUserScreen::class.java)
        intent.putExtra("itemId", itemId)
        startActivity(intent)
    }
}