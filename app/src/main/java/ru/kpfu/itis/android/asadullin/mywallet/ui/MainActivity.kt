package ru.kpfu.itis.android.asadullin.mywallet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.managers.SharedPreferencesManager

//import ru.kpfu.itis.android.asadullin.mywallet.di.ServiceLocator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)

        initInstances()
    }

    private fun initInstances() {
        FirebaseApp.initializeApp(this)
        SharedPreferencesManager.init(this)
//        ServiceLocator.createDatabase(context = this)
    }
}