package com.example.evidencerecoder

import android.app.Activity
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun provideTopViewLogic() = TopViewLogic()
}