package eg.ead.haoyue

import android.os.Bundle
import android.widget.ArrayAdapter
import eg.ead.haoyue.databinding.ActivitySettingsBinding

class SettingsActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private val item = listOf("Developer", "Version")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item)
        binding.listviewSettings.adapter = adapter

    }
}