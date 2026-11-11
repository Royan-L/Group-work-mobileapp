package com.example.mobileappassignment

import com.example.mobileappassignment.data.model.Tenant
import com.example.mobileappassignment.data.repository.TenantRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TenantRepositoryTest {

    @Before
    fun setUp() {
        TenantRepository.tenants.clear()
    }

    @Test
    fun testAddTenantAndTotalRent() {
        val tenant1 = Tenant("John Doe", "0712345678", "15000")
        val tenant2 = Tenant("Jane Smith", "0787654321", "25000")

        TenantRepository.addTenant(tenant1)
        TenantRepository.addTenant(tenant2)

        assertEquals(2, TenantRepository.tenants.size)
        assertEquals(40000.0, TenantRepository.totalRent(), 0.001)
    }

    @Test
    fun testTenantSummary() {
        val tenant = Tenant("Alice", "0700000000", "10000")
        val expected = "Tenant: Alice\nPhone: 0700000000\nRent paid: KSh 10000"
        assertEquals(expected, tenant.summary())
    }
}