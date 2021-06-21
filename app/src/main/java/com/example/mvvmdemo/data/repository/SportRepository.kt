package com.example.mvvmdemo.data.repository

import com.example.mvvmdemo.data.model.Sport
import com.example.mvvmdemo.utils.DataResult

interface SportRepository {
    /**
     * Local
     */

    /**
     * Remote
     */
    suspend fun getListSport(): DataResult<MutableList<Sport>>
}
