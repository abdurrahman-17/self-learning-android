package com.example.selflearning

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.selflearning.databinding.ActivityPostDataScreenBinding
import com.example.selflearning.model.ListUserModel
import com.example.selflearning.model.postDataModel.PostDataModel
import com.example.selflearning.model.postDataModel.PostDataResponse
import com.example.selflearning.retrofit.RetrofitInstance
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostDataScreen : AppCompatActivity() {

    lateinit var binding: ActivityPostDataScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_data_screen)

        binding.postApiButton.setOnClickListener{
            postDataFunction(binding.nameEditInput.text.toString(), binding.jobEditInput.text.toString())
        }

    }


    private fun postDataFunction(name: String, job : String) {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please Wait while Data is fetch")
        progressDialog.show()

        RetrofitInstance.apiInterface.postData(PostDataModel(job,name)).enqueue(object : Callback<PostDataResponse?> {
            override fun onResponse(
                call: Call<PostDataResponse?>,
                response: Response<PostDataResponse?>
            ) {
                progressDialog.dismiss()

                Log.i(response.toString(), "Response")

                binding.postData = PostDataResponse(
                    response.body()?.createdAt.toString(),
                    response.body()?.id.toString(),
                    response.body()?.job.toString(),
                    response.body()?.name.toString()
                )

            }

            override fun onFailure(call: Call<PostDataResponse?>, t: Throwable) {
                Toast.makeText(this@PostDataScreen,t.localizedMessage, Toast.LENGTH_SHORT).show()

                progressDialog.dismiss()
            }
        })

    }
}