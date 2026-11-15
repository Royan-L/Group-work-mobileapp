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
| 1 Lead | Royan L | — | [PR Link](https://github.com/Royan-L/Group-work-mobileapp/pulls) |
| 2 ViewModel | Team Member 2 | — | [PR Link](https://github.com/Royan-L/Group-work-mobileapp/pulls) |
| 3 Room | Team Member 3 | — | [PR Link](https://github.com/Royan-L/Group-work-mobileapp/pulls) |
| 4 Screens | Team Member 4 | — | [PR Link](https://github.com/Royan-L/Group-work-mobileapp/pulls) |
| 5 Data integration | Team Member 5 | — | [PR Link](https://github.com/Royan-L/Group-work-mobileapp/pulls) |
| 6 Release | Royan L | — | [PR Link](https://github.com/Royan-L/Group-work-mobileapp/pulls) |
