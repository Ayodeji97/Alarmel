package com.danzucker.alarmel.alarm.di

import com.danzucker.alarmel.alarm.alarmlist.presentation.AlarmListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::AlarmListViewModel)
}