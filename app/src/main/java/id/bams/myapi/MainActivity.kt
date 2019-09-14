package id.bams.myapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import id.bams.myapi.data.GithubService
import id.bams.myapi.data.apiRequest
import id.bams.myapi.data.httpClient
import id.bams.myapi.util.dissmisloading
import id.bams.myapi.util.showloading
import id.bams.myapi.util.tampilToast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callApiGetGihubUser()
    }

    private fun callApiGetGihubUser() {
        showloading(applicationContext, swiperefreshlayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<GithubService>(httpClient)

        val call = apiRequest.getUsers()
        call.enqueue(object : Callback<List<DataUser>> {

            override fun onFailure(call: Call<List<DataUser>>, t: Throwable) {
                dissmisloading(swiperefreshlayout)
            }

            override fun onResponse(call: Call<List<DataUser>>, response: Response<List<DataUser>>) {
                dissmisloading(swiperefreshlayout)

                when {
                    response.isSuccessful ->

                        when {
                            response.body()?.size != 0 ->
                                tampilGithub(response.body()!!)

                            else -> {
                                tampilToast(applicationContext, "Berhasil")
                            }
                        }

                    else -> {
                        tampilToast(applicationContext, "Gagal")
                    }

                }
            }

        })
    }

    private fun tampilGithub(body: List<DataUser>){
        listGithubUser.layoutManager = LinearLayoutManager( this)
        listGithubUser.adapter = GithubUserAdapter( this, body){

            val dataUser = it
            tampilToast(applicationContext, dataUser.login)
        }
    }
}
