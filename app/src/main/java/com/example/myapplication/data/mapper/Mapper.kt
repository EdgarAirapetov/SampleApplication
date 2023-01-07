package com.example.myapplication.data.mapper

interface Mapper<D, A> {
    fun mapFromApp(type: A): D
    fun mapToApp(type: D): A
}