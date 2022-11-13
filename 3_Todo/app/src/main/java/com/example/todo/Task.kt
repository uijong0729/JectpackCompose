package com.example.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // Room의 엔티티 클래스
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,        // 나중에 별도로 값을 대입하지 못하도록 미리 0으로 초기화
    var title: String,      // 유저 입력에 따라 변경가능
    var description: String // 유저 입력에 따라 변경가능
)
