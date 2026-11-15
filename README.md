# Tenant Management System

An Android app for landlords to record tenants, see total rent, and call tenants.

## Download
Latest APK: see **Releases** on the right of this page.

## Features
- Register and log in
- Dashboard with number of tenants and total rent
- Add tenants and view all tenants (saved with Room)
- Call a tenant, options menu and navigation drawer

## Architecture
`ui/` Activities, Fragments and TenantViewModel (UI layer)  
`data/` Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)  

Screens -> TenantViewModel (LiveData) -> TenantRepository -> Room

## Team
| Stage | Member | Admission No. | Pull request |
|---|---|---|---|
| 1 Lead | Royan Lumbasi | 174232 | [link](https://github.com/Royan-L/Group-work-mobileapp/commits/main) |
| 2 ViewModel | Jackson Mosera | 189575 | [link](https://github.com/Royan-L/Group-work-mobileapp/pull/1) |
| 3 Room | Kelsey Ayuya | 189938 | [link](https://github.com/Royan-L/Group-work-mobileapp/pull/2) |
| 4 Screens | Beryl Orutwa | 192044 | [link](https://github.com/Royan-L/Group-work-mobileapp/pull/3) |
| 5 Data integration | Sylvia Akinyi | 186650 | [link](https://github.com/Royan-L/Group-work-mobileapp/pull/4) |
| 6 Release | Royan Lumbasi | 174232 | [link](https://github.com/Royan-L/Group-work-mobileapp/pull/5) |
