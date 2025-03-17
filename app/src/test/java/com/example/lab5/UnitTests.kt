package com.example.lab5

import com.example.lab5.model.database.entities.Statistic
import com.example.lab5.model.database.entities.StatisticDbEntity
import org.junit.*
import org.junit.Assert.*

class UnitTests {

    @Test
    fun statToEntity(){
        val a=StatisticDbEntity(0,1,2,3,4)
        val st=Statistic(1,2,3,4)
        val stEntity=st.toStatisticDbEntity()
        assertEquals(stEntity,a)
    }

}