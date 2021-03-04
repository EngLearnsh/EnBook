package eg.ead.haoyue

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import eg.ead.haoyue.databinding.ActivityMainBinding
import eg.ead.haoyue.util.HWInfoUtil
import java.io.FileReader

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // databinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // toolbar
        setSupportActionBar(binding.toolbar)

        // drawer
        initActionBarDrawer()

        // navview
        initNavItemListener()

        var item = listOf(HWInfoUtil.getHardwareInformationUtil(this).boardName)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item)
        binding.listviewHome.adapter = adapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    private fun initActionBarDrawer() {
        val toggle = ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun initNavItemListener() {
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.setting -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                }
                R.id.exit -> finish()
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

}