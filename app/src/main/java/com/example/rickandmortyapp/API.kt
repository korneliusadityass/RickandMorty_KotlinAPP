package com.example.rickandmortyapp

import retrofit2.Call
import retrofit2.http.GET

interface API {
    interface RickApi  {
        // HTTP GET request to the character endpoint
        // https://rickandmortyapi.com/api/character
        @GET("character")
        fun getDetails() : Call<RickMorty>
        @GET("location")
        fun getLocation() : Call<Location>
    }
}