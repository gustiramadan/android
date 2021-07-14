package com.example.databarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.example.databarang.model.ResponseActionBarang
import com.example.databarang.network.koneksi
import com.example.databarang.service.SessionPreferences
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import javax.security.auth.callback.Callback

class RegisterActivity : AppCompatActivity() {
  //  private lateinit var sessionPreferences: SessionPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_register)
     //   btn_submit.setOnClickListener {
     //       val userName = et_username.text.toString()
     //       val password = et_password.text.toString()
     //       if (userName.isEmpty())||(password.isEmpty()){
     //          Toast.makeText(this, "from tidak boleh kosong!", Toast.LENGTH_LONG).show()
     //       } else{
     //       actionData(userName, password)
     //       }
     //   }
     //   btn_clean.setOnClickListener {
     //       formClear()
     //   }
     //   tv_disini.setOnClickListener{
     //       startActivity(Intent(this, LoginActivity::class.java))
     //       finish()
     //   }
    }
  //  fun actionData(username : String, password : String){
    //    koneksi.service.
      //  koneksi.service.register(username, password).enqueue(object : Callback<ResponseAdmin>){
     //       override fun onFailure(call: Call<ResponseAdmin>, t: Throwable){
     //           Log.d("pesan1", t.localizedMessage)
     //       }
     //       override fun onResponse(call:)
     //       }
     //   }
   // }
}