package com.example.todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 *  DAO는 비동기 처리가 필수
 *      1.비동기 원샷 쿼리 :  한번만 실행되어 데이터베이스의 스냅샷을 반환 (coroutines)
 *      2.옵저버블 쿼리   :   테이블에 변화가 있을때 마다 새로운 데이터를 취득하는 쿼리 (Flow)
 */
@Dao // Data Acess Object
interface TaskDao {
    /** suspend
     * - 유예하다, 유보하다
     * - suspend를 붙인다고 무조건 백그라운드 스레드가 되는건 아니다.
     * - coroutines : 코루틴들은 서로가 서로를 호출하는 루틴이며 기본적으로 일시중단 가능하다.
     * - suspend fun : 일시중단 가능 함수이며, 해당 함수 내에는 일시 중단이 가능한 작업이 있다는 것을 뜻한다.
     */
    @Insert
    suspend fun insertTask(task: Task)          // 비동기 원샷 쿼리

    // FROM에는 Entity에 정의된 클래스 이름
    @Query("SELECT * FROM Task")
    fun loadAllTasks(): Flow<List<Task>>      // 옵저저블 쿼리 (Flow는 kotlinx.coroutines 패키지에 주의)

    @Update
    suspend fun updateTask(task: Task)          // 비동기 원샷 쿼리

    @Delete
    suspend fun deleteTask(task: Task)          // 비동기 원샷 쿼리
}