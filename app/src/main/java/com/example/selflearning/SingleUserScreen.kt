package com.example.selflearning

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.selflearning.model.ListUserModel
import com.example.selflearning.model.SingleUserDataModel
import com.example.selflearning.retrofit.RetrofitInstance
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_single_user_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SingleUserScreen : AppCompatActivity() {

    private var itemIdTextView : TextView? =null
    private var itemNameTextView : TextView? =null
    private var itemLastTextView : TextView? =null
    private var itemEmailTextView : TextView? =null
    private var itemImageView : ImageView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_user_screen)

        itemIdTextView = findViewById(R.id.itemIdText)
        itemImageView = findViewById(R.id.singleUserImage)
        itemNameTextView = findViewById(R.id.ItemNameText)
        itemLastTextView = findViewById(R.id.ItemLastNameText)
        itemEmailTextView = findViewById(R.id.ItemEmailText)

        val intent = intent
        if (intent != null) {
            val receivedData = intent.getStringExtra("itemId")

            Log.e(receivedData, "Data checked")
            if (receivedData != null) {
                itemIdTextView?.text = receivedData.toString()
                getSingleUserData(receivedData)
            }
        }

    }

    fun getSingleUserData(itemId : String){
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please Wait while Data is fetch")
        progressDialog.show()

        RetrofitInstance.apiInterface.getSingleUserData(itemId).enqueue(object :
            Callback<SingleUserDataModel?> {
            override fun onResponse(
                call: Call<SingleUserDataModel?>,
                response: Response<SingleUserDataModel?>
            ) {
                progressDialog.dismiss()
                Picasso.get().load(response.body()?.data?.avatar).into(itemImageView)
                itemIdText.text = response.body()?.data?.id.toString()
                itemNameTextView?.text = response.body()?.data?.first_name.toString()
                itemLastTextView?.text = response.body()?.data?.last_name.toString()
                itemEmailTextView?.text = response.body()?.data?.email.toString()
            }

            override fun onFailure(call: Call<SingleUserDataModel?>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(this@SingleUserScreen, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}



