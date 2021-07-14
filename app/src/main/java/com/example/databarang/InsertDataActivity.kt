package com.example.databarang

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databarang.adapter.ListContent
import com.example.databarang.model.ResponseActionBarang
import com.example.databarang.model.ResponseBarang
import com.example.databarang.network.koneksi
import kotlinx.android.synthetic.main.activity_insert_data.*
import kotlinx.android.synthetic.main.activity_insert_data.btn_clean
import kotlinx.android.synthetic.main.activity_insert_data.btn_submit
import kotlinx.android.synthetic.main.activity_insert_data.et_nama_barang
import kotlinx.android.synthetic.main.activity_insert_data.rv_data_barang
import kotlinx.android.synthetic.main.activity_insert_data.toolbar
import kotlinx.android.synthetic.main.activity_update_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InsertDataActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)
        toolbar.title = "INSERT DATA"
        toolbar.setTitleTextColor(Color.WHITE)

        btn_submit.setOnClickListener {
            val etnameBarang = et_nama_barang.text
            val etjumlahBarang = et_jumlah_barang.text
            if (etjumlahBarang.isEmpty()) {
                Toast.makeText(
                    this@InsertDataActivity,
                    "Jumlah Barang Tidak Boleh Kosong",
                    Toast.LENGTH_LONG
                ).show()
            } else if (etnameBarang.isEmpty()) {
                Toast.makeText(
                    this@InsertDataActivity,
                    "Nama Barang Tidak Boleh Kosong",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                actionData(etnameBarang.toString(), etjumlahBarang.toString())
            }
        }
        btn_clean.setOnClickListener{
            formClear()
        }
        getData()
    }
    fun formClear(){
        et_nama_barang.text.clear()
        et_jumlah_barang.text.clear()
    }
    fun actionData(namaBarang :String, jumlahBarang : String){
        koneksi.service.insertBarang(namaBarang, jumlahBarang).enqueue(object : retrofit2.Callback<ResponseActionBarang>{
            override fun onFailure(call: Call<ResponseActionBarang>, t: Throwable){
                Log.d("pesan1", t.localizedMessage)
            }
            override fun onResponse(
                call: Call<ResponseActionBarang>,
                response: Response<ResponseActionBarang>
            ){
                if (response.isSuccessful){
                    Toast.makeText(this@InsertDataActivity, "data berhasil disimpan", Toast.LENGTH_LONG).show()
                    formClear()
                    getData()
                }
            }
        })
    }
    fun getData(){
        koneksi.service.getBarang().enqueue(object :retrofit2.Callback<ResponseBarang>{
            override fun onFailure(call: Call<ResponseBarang>, t: Throwable) {
                Log.d("pesan1", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<ResponseBarang>,
                response: Response<ResponseBarang>
            ) {
                if(response.isSuccessful){
                    val dataBody = response.body()
                    val dataContent = dataBody!!.data
                    val rvAdapter = ListContent(dataContent, this@InsertDataActivity)

                    rv_data_barang.apply{
                        adapter = rvAdapter
                        layoutManager = LinearLayoutManager(this@InsertDataActivity)
                    }
                }
            }
        })
    }
}