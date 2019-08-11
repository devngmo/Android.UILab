package tml.lab.androiduilab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tml.lab.androiduilab.ui.viewmodeldemo.ViewModelDemoFragment

class ViewModelDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_model_demo_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ViewModelDemoFragment.newInstance())
                .commitNow()
        }
    }

}
