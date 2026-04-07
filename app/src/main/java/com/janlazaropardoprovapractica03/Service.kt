package com.gilded.janlazaropardoprovapractica03

import com.janlazaropardoprovapractica03.Reserva
import com.janlazaropardoprovapractica03.Usuari
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Service {
    @POST("/login/")
    suspend fun login(@Body user: Usuari): Response<Usuari?>

    @GET("reserves/usuari/{idusuari}")
    suspend fun getReservations(@Path("idusuari") idusuari: Int): Response<List<Reserva>>
}