package id.bams.myapi.data

import id.bams.myapi.DataUser
import retrofit2.Call
import retrofit2.http.GET


interface GithubService {

@GET( "users")
fun getUsers(): Call<List<DataUser>>
}