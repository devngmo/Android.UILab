package tml.lab.androiduilab

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tml.lab.androiduilab.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.botnav_workflows -> {
                showWorkflows()
                return@OnNavigationItemSelectedListener true
            }
            R.id.botnav_browsers -> {
                showBrowsers()
                return@OnNavigationItemSelectedListener true
            }
            R.id.botnav_editors -> {
                showEditors()
                return@OnNavigationItemSelectedListener true
            }
            R.id.botnav_dialogs-> {
                showDialogs()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun showWorkflows() {
        lv.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listWorkflows)
    }

    private fun showBrowsers() {
        lv.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listBrowsers)
    }

    private fun showEditors() {
        lv.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listEditors)
    }
    private fun showDialogs() {
        lv.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDialogs)
    }

    val listWorkflows = arrayListOf<String>("TapTarget", "SpotLight", "Login")
    val listBrowsers = arrayListOf<String>(
        "Tabs & Pages",
        "Navigation Drawer",
        "Master & Detail",
        "Scrolling",
        "Bottom Navigation",
        "Google Map"
        )
    val listEditors = arrayListOf<String>(
        "Settings",
        "View Model"
    )
    val listDialogs = arrayListOf(
        "Message Box",
        "Message Box, OK & Cancel",
        "Message Box, OK & Cancel & Apply",
        "List single selection",
        "Single Option",
        "Single Option need Confirm",
        "Multiple Option",
        "Checkbox Prompt",
        "Wifi Connect"
    )

    val lvItems = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        lv.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            when {
                navView.selectedItemId == R.id.botnav_workflows -> {
                    when {
                        position < 2 -> {
                            val i = Intent(this@MainActivity, GuideLineDemoActivity::class.java)
                            i.putExtra(GuideLineDemoActivity.ARG_ENGINE_ID, position)
                            startActivity(i)
                        }
                        position == 2 -> {
                            val i = Intent(this@MainActivity, LoginActivity::class.java)
                            i.putExtra(GuideLineDemoActivity.ARG_ENGINE_ID, position)
                            startActivity(i)
                        }
                    }
                }
                navView.selectedItemId == R.id.botnav_browsers -> {
                    when {
                        position == 0 -> {
                            val i = Intent(this@MainActivity, AndroidXTabPagerActivity::class.java)
                            startActivity(i)
                        }
                        position == 1 -> {
                            val i = Intent(this@MainActivity, NavigationDrawerActivity::class.java)
                            startActivity(i)
                        }
                        position == 2 -> {
                            val i = Intent(this@MainActivity, ItemListActivity::class.java)
                            startActivity(i)
                        }
                        position == 3 -> {
                            val i = Intent(this@MainActivity, ScrollingActivity::class.java)
                            startActivity(i)
                        }
                        position == 4 -> {
                            val i = Intent(this@MainActivity, BottomNavigationActivity::class.java)
                            startActivity(i)
                        }
                        position == 5 -> {
                            val i = Intent(this@MainActivity, DemoMapsActivity::class.java)
                            startActivity(i)
                        }
                    }
                }
                navView.selectedItemId == R.id.botnav_editors -> {
                    when {
                        position == 0 -> {
                            val i = Intent(this@MainActivity, SettingsActivity::class.java)
                            startActivity(i)
                        }
                        position == 1 -> {
                            val i = Intent(this@MainActivity, ViewModelDemoActivity::class.java)
                            startActivity(i)
                        }
                    }
                }
                navView.selectedItemId == R.id.botnav_dialogs -> {
                    when {
                        position == 0 -> DialogDemoFactory.messageBox(this@MainActivity)
                        position == 1 -> DialogDemoFactory.messageBoxYesNo(this@MainActivity)
                        position == 2 -> DialogDemoFactory.messageBoxYesNoApply(this@MainActivity)
                        position == 3 -> DialogDemoFactory.listSingleSelection(this@MainActivity)
                        position == 4 -> DialogDemoFactory.singleOption(this@MainActivity)
                        position == 5 -> DialogDemoFactory.singleOptionNeedConfirm(this@MainActivity)
                        position == 6 -> DialogDemoFactory.multipleOptions(this@MainActivity)
                        position == 7 -> DialogDemoFactory.checkboxPrompt(this@MainActivity)
                        position == 8 -> DialogDemoFactory.wifiConnect(this@MainActivity)
                    }
                }
            }
        }

        showWorkflows()
    }
}
