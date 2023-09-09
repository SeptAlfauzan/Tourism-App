package com.dicoding.mysimplelogin

import com.dicoding.mysimplelogin.di.storageModule
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.android.ext.android.inject
import org.koin.test.KoinTest

class MainActivityTest: KoinTest {

    private val repository: UserRepository by inject()
    private val username = "dicoding"

    @Before
    fun setUp() {
        loadKoinModules(storageModule)
        repository.loginUser(username)
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun getUsernameFromRepository() {
        val requestedUsername = repository.getUser()
        assertEquals(username, requestedUsername)
    }
}