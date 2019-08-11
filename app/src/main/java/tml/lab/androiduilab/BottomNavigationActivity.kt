package tml.lab.androiduilab

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    @SuppressLint("SetTextI18n")
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.demo_botnav_hot -> {
                textMessage.text = "Hot news"
                return@OnNavigationItemSelectedListener true
            }
            R.id.demo_botnav_latest -> {
                textMessage.text = "Latest News"
                return@OnNavigationItemSelectedListener true
            }
            R.id.demo_botnav_favorite -> {
                textMessage.text = "Favorite List"
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
