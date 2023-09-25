package com.example.selflearning

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import com.example.selflearning.model.ListUserModel
import com.example.selflearning.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GridViewActivity : AppCompatActivity() {

    private var adapter: GridAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        val gridView : GridView = findViewById(R.id.gridView)
        adapter = GridAdapter(this)

        //we need adapter and viewHolder for Recycler View
        getDataList()

        gridView.adapter = adapter
    }


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

                adapter?.setItems(response.body()!!)
            }

            override fun onFailure(call: Call<ListUserModel?>, t: Throwable) {
                Toast.makeText(this@GridViewActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()

                progressDialog.dismiss()
            }
        })

    }
}