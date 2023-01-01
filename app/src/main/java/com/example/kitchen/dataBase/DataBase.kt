package com.example.kitchen.dataBase

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.kitchen.dataBase.info_db.dbName
import com.example.kitchen.dataBase.info_db.packageDate
import com.example.kitchen.dataBase.info_db.source
import com.example.kitchen.model.Food
import java.io.File
import java.io.FileOutputStream
import kotlin.math.log

class DataBase(val context: Context) :
    SQLiteOpenHelper(context, info_db.dbName, null, info_db.dbVersion) {


    override fun onCreate(p0: SQLiteDatabase?) {
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }


    init {
        initDataBase()
    }

    @SuppressLint("SuspiciousIndentation")
    fun initDataBase() {
        var file = File(info_db.packageDate)
        if (file.exists()) {

        } else {
            file.mkdir()
        }
        file = context.getDatabasePath(info_db.dbName)
        if (file.exists()) {

        } else {
            copyDataBase()
        }


    }


    fun copyDataBase() {
        val inputStream = context.assets.open(source)
        val outFile = packageDate + dbName
        val uotPutStream = FileOutputStream(outFile)
        val buffer = ByteArray(1024)
        var lenght = 0
        while (inputStream.read(buffer).also({ lenght = it }) > 0)
            uotPutStream.write(buffer, 0, lenght)
        uotPutStream.flush()
        uotPutStream.close()
        inputStream.close()
    }

    @SuppressLint("Range")
    fun getAll(): ArrayList<Food> {
        val db = readableDatabase
        val query = "SELECT * FROM zine"
        val list: ArrayList<Food> = ArrayList()
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val food = Food()
                food.nameFood = cursor.getString(cursor.getColumnIndex(info_db.dbNameFood))
                food.typeRawMat = cursor.getString(cursor.getColumnIndex(info_db.dbTypeRawMat))
                food.rawMat = cursor.getString(cursor.getColumnIndex(info_db.dbRawMat))
                food.category = cursor.getString(cursor.getColumnIndex(info_db.dbCategory))
                food.image = cursor.getString(cursor.getColumnIndex(info_db.dbImage))
                food.description = cursor.getString(cursor.getColumnIndex(info_db.dbDescription))
                food.id = cursor.getInt(cursor.getColumnIndex(info_db.dbId))
                food.fav = cursor.getInt(cursor.getColumnIndex(info_db.fav))
                list.add(food)
                Log.d("message", "food name${food.nameFood}")

            } while (cursor.moveToNext())

        }
        cursor.close()
        db.close()
        return list

    }


    @SuppressLint("Range")
    fun getFav(): ArrayList<Food> {
        val db = readableDatabase
        val query = "SELECT * FROM zine WHERE fav = 1 "
        val list: ArrayList<Food> = ArrayList()
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val food = Food()
                food.nameFood = cursor.getString(cursor.getColumnIndex(info_db.dbNameFood))
                food.typeRawMat = cursor.getString(cursor.getColumnIndex(info_db.dbTypeRawMat))
                food.rawMat = cursor.getString(cursor.getColumnIndex(info_db.dbRawMat))
                food.category = cursor.getString(cursor.getColumnIndex(info_db.dbCategory))
                food.image = cursor.getString(cursor.getColumnIndex(info_db.dbImage))
                food.description = cursor.getString(cursor.getColumnIndex(info_db.dbDescription))
                food.id = cursor.getInt(cursor.getColumnIndex(info_db.dbId))
                food.fav = cursor.getInt(cursor.getColumnIndex(info_db.fav))
                list.add(food)
                Log.d("message", "food name${food.nameFood}")

            } while (cursor.moveToNext())

        }
        cursor.close()
        db.close()
        return list

    }

    @SuppressLint("Range")
    fun getValue(id: Int): Int {
        val db = readableDatabase
        val query = "SELECT ${info_db.fav} FROM zine WHERE ${info_db.dbId}=$id "
        var value = 0
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            value = cursor.getInt(cursor.getColumnIndex(info_db.fav))
            do {

            } while (cursor.moveToNext())
        }
        db.close()
        cursor.close()
        return value

    }

    fun getStatus(status: Int, id: Int) {
        val db = readableDatabase
        val query = "UPDATE zine SET ${info_db.fav}=$status WHERE ${info_db.dbId}=$id"
        db.execSQL(query)
        db.close()


    }

    @SuppressLint("Range")
    fun getCategory(category: String): ArrayList<Food> {
        val db = readableDatabase
        val query = "SELECT * FROM zine WHERE category = '$category'"
        val list: ArrayList<Food> = ArrayList()
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val food = Food()
                food.nameFood = cursor.getString(cursor.getColumnIndex(info_db.dbNameFood))
                food.typeRawMat = cursor.getString(cursor.getColumnIndex(info_db.dbTypeRawMat))
                food.rawMat = cursor.getString(cursor.getColumnIndex(info_db.dbRawMat))
                food.category = cursor.getString(cursor.getColumnIndex(info_db.dbCategory))
                food.image = cursor.getString(cursor.getColumnIndex(info_db.dbImage))
                food.description = cursor.getString(cursor.getColumnIndex(info_db.dbDescription))
                food.id = cursor.getInt(cursor.getColumnIndex(info_db.dbId))
                food.fav = cursor.getInt(cursor.getColumnIndex(info_db.fav))
                list.add(food)
                Log.d("message", "food name${food.nameFood}")

            } while (cursor.moveToNext())

        }
        cursor.close()
        db.close()
        return list

    }

}