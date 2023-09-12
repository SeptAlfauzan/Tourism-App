package com.septalfauzan.core.di

import com.dicoding.mysimplelogin.SessionManager
import com.septalfauzan.core.UserRepository
import org.koin.dsl.module

val storageModule = module {
    factory {
        SessionManager(get())
    }
    factory {
        com.septalfauzan.core.UserRepository(get())
    }
}