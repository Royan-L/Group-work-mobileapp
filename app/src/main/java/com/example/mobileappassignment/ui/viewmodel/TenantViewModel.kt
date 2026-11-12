package com.example.mobileappassignment.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.mobileappassignment.data.model.Tenant
import com.example.mobileappassignment.data.repository.TenantRepository

/**
 * TenantViewModel manages tenant UI state and business logic for the app.
 * It serves as a bridge between the data layer (TenantRepository) and the UI layer (Fragments).
 * 
 * NOTE: This ViewModel contains NO Android View, Toast, or Binding references,
 * keeping it strictly decoupled from the UI framework and testable.
 */
class TenantViewModel : ViewModel() {

    // Private backing MutableLiveData containing the current list of tenants from the repository
    private val _tenants = MutableLiveData<List<Tenant>>(TenantRepository.tenants.toList())

    // Public immutable LiveData exposing the tenant list to observers
    val tenants: LiveData<List<Tenant>> = _tenants

    // Transformation for formatted tenant count display (used by DashboardFragment)
    val tenantCountText: LiveData<String> = _tenants.map { list ->
        "Tenants\n${list.size}"
    }

    // Transformation for formatted total rent display (used by DashboardFragment)
    val totalRentText: LiveData<String> = _tenants.map { list ->
        val total = list.sumOf { tenant -> tenant.rent.toDoubleOrNull() ?: 0.0 }
        "Total rent\nKSh %,.0f".format(total)
    }

    // Transformation for formatted all tenants summary display (used by ViewTenantsFragment)
    val allTenantsText: LiveData<String> = _tenants.map { list ->
        if (list.isEmpty()) {
            "No tenants yet. Add one from the Dashboard."
        } else {
            list.joinToString("\n\n") { it.summary() }
        }
    }

    /**
     * Adds a new tenant to the repository and updates the LiveData state.
     * Log message records the action for lifecycle/debug tracking.
     */
    fun addTenant(tenant: Tenant) {
        Log.d("TenantViewModel", "Adding tenant: ${tenant.name}")
        TenantRepository.addTenant(tenant)
        // Refresh LiveData with updated snapshot from repository
        _tenants.value = TenantRepository.tenants.toList()
    }
}
