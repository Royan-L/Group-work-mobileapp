package com.example.mobileappassignment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileappassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null
    private var saveCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "MainActivity: onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("EMAIL")
        if (email != null) {
            Toast.makeText(this, "Logged in as $email", Toast.LENGTH_SHORT).show()
        }

        if (savedInstanceState != null) {
            val name = savedInstanceState.getString("tenant_name", "")
            val phone = savedInstanceState.getString("tenant_phone", "")
            val rent = savedInstanceState.getString("tenant_rent", "")
            saveCount = savedInstanceState.getInt("save_count", 0)

            if (name.isNotEmpty() || phone.isNotEmpty() || rent.isNotEmpty()) {
                val restoredTenant = Tenant(name, phone, rent)
                lastTenant = restoredTenant
                binding.tenant = restoredTenant
            }

            if (saveCount > 0) {
                Toast.makeText(this, "Restored save count: $saveCount", Toast.LENGTH_SHORT).show()
            }
        }

        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            var hasError = false
            if (name.isEmpty()) {
                binding.tenantNameEditText.error = "Required"
                hasError = true
            }
            if (phone.isEmpty()) {
                binding.phoneEditText.error = "Required"
                hasError = true
            }
            if (rent.isEmpty()) {
                binding.rentEditText.error = "Required"
                hasError = true
            }

            if (hasError) return@setOnClickListener

            saveCount++
            val tenant = Tenant(name, phone, rent)
            binding.tenant = tenant
            lastTenant = tenant

            binding.tenantNameEditText.text?.clear()
            binding.phoneEditText.text?.clear()
            binding.rentEditText.text?.clear()
        }

        binding.callButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}"))
            startActivity(intent)
        }

        binding.shareButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, tenant.summary())
            }
            startActivity(Intent.createChooser(intent, "Share tenant"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("tenant_name", lastTenant?.name ?: binding.tenantNameEditText.text.toString())
        outState.putString("tenant_phone", lastTenant?.phone ?: binding.phoneEditText.text.toString())
        outState.putString("tenant_rent", lastTenant?.rent ?: binding.rentEditText.text.toString())
        outState.putInt("save_count", saveCount)
        Log.d("TENANT_LIFECYCLE", "MainActivity: onSaveInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onDestroy")
    }
}
