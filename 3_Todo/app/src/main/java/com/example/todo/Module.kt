package com.example.todo

import android.content.Context
import androidx.room.Room
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_ActivityRetainedComponentBuilder
import javax.inject.Singleton

// Hilt 모듈
// https://developer.android.com/training/dependency-injection/hilt-android#hilt-modules
@dagger.Module
// InstallIn에 구성요소로 오는 클래스들
// https://developer.android.com/training/dependency-injection/hilt-android#generated-components
@InstallIn(SingletonComponent::class)
object Module {

    // 인스턴스 생성방법 정의는 @Provides
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "task_database").build()

    // Single-expression functions
    // 함수가 single expression 을 리턴할 때에는 { } 는 생략될 수 있고 함수의 바디는 = 뒤에 위치한다.
    @Provides
    fun provideDao(database: AppDatabase) = database.taskDao()
}