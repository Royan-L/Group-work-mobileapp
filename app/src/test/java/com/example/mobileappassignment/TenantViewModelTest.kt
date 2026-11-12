package com.example.mobileappassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mobileappassignment.data.model.Tenant
import com.example.mobileappassignment.data.repository.TenantRepository
import com.example.mobileappassignment.ui.viewmodel.TenantViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TenantViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TenantViewModel

    @Before
    fun setUp() {
        TenantRepository.tenants.clear()
        viewModel = TenantViewModel()

        // Observe LiveData transformations so they remain active and evaluate during test execution
        viewModel.tenantCountText.observeForever { }
        viewModel.totalRentText.observeForever { }
        viewModel.allTenantsText.observeForever { }
    }

    @Test
    fun testInitialEmptyState() {
        assertEquals("Tenants\n0", viewModel.tenantCountText.value)
        assertEquals("Total rent\nKSh 0", viewModel.totalRentText.value)
        assertEquals("No tenants yet. Add one from the Dashboard.", viewModel.allTenantsText.value)
    }

    @Test
    fun testAddTenantUpdatesLiveDataTransformations() {
        val tenant1 = Tenant("John Doe", "0712345678", "15000")
        viewModel.addTenant(tenant1)

        assertEquals("Tenants\n1", viewModel.tenantCountText.value)
        assertEquals("Total rent\nKSh 15,000", viewModel.totalRentText.value)
        assertEquals("Tenant: John Doe\nPhone: 0712345678\nRent paid: KSh 15000", viewModel.allTenantsText.value)
    }

    @Test
    fun testMultipleTenantsTotalRent() {
        viewModel.addTenant(Tenant("John Doe", "0712345678", "15000"))
        viewModel.addTenant(Tenant("Jane Smith", "0787654321", "25000"))

        assertEquals("Tenants\n2", viewModel.tenantCountText.value)
        assertEquals("Total rent\nKSh 40,000", viewModel.totalRentText.value)
    }
}
