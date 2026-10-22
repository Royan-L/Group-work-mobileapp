# Project Plan

Lab 6 Navigation Practical 2 — Lifecycle, State Preservation, Fragments, Navigation Graph & Safe Args using Android XML, Fragments, and Navigation Component.

## Project Brief

# Project Brief: Lab 6 Navigation Practical 2

## Features
- **Multi-Fragment Navigation Flow**: Seamless navigation between app screens (e.g., Welcome, Main Content/Quiz, and Result screens) managed via an Android Navigation Graph.
- **Type-Safe Data Passing (Safe Args)**: Strongly-typed argument passing between fragment destinations using the Navigation Safe Args plugin.
- **Lifecycle Awareness & State Preservation**: Preservation of UI and application state across configuration changes (e.g., device rotation) and screen lifecycle transitions using ViewModel and SavedStateHandle.
- **Interactive XML Layouts**: Responsive user interfaces constructed with ConstraintLayout and driven by View Binding and Data Binding for clean UI-logic separation.

## High-Level Tech Stack
- **Language**: Kotlin
- **UI & Layouts**: Android XML Layouts, `ConstraintLayout`, Fragments, Single-Activity pattern (`MainActivity`)
- **UI Binding**: View Binding & Data Binding
- **Navigation**: Jetpack Navigation Component (`androidx.navigation`) with Safe Args
- **Lifecycle & State Management**: Android Lifecycle, `ViewModel`, `SavedStateHandle`
- **Concurrency**: Kotlin Coroutines

## Implementation Steps
**Total Duration:** 73h 16m 55s

### Task_1_SetupBindingAndDataModel: Enable View Binding and Data Binding in build.gradle.kts, sync project, and create the Tenant data model class (Tenant.kt) with name, phone, rent fields and summary() method.
- **Status:** COMPLETED
- **Updates:** Enabled viewBinding and dataBinding in build.gradle.kts. Created Tenant.kt model class in package com.example.mobileappassignment with name, phone, rent properties and summary() returning 'Rent paid: KSh $rent'. Debug build succeeded.
- **Acceptance Criteria:**
  - viewBinding and dataBinding enabled in build.gradle.kts
  - Tenant data model created with summary method returning 'Rent paid: KSh $rent'
  - build pass
- **Duration:** 10m 16s

### Task_2_ImplementDataBindingLayout: Create activity_main.xml layout using ConstraintLayout wrapped in layout and data tags with Tenant variable. Include input fields for Name, Phone, Rent, SAVE button, bold Name display, and Summary display TextView.
- **Status:** COMPLETED
- **Updates:** Created activity_main.xml layout wrapped in <layout> and <data> tags with Tenant variable, ConstraintLayout, input fields, SAVE button, tenantDisplayNameTextView showing tenant.name in large bold text, and tenantResultTextView showing tenant.summary(). assembleDebug build passed.
- **Acceptance Criteria:**
  - activity_main.xml implemented with Data Binding layout and ConstraintLayout
  - UI includes Name, Phone, Rent fields, SAVE button, bold name display, and summary display
  - build pass
- **Duration:** 5m 34s

### Task_3_ImplementMainActivityLogic: Implement MainActivity interactivity: set up ActivityMainBinding, handle SAVE button click, validate required tenant name field, create Tenant instance, update binding data, and clear input fields.
- **Status:** COMPLETED
- **Updates:** Implemented MainActivity.kt with ActivityMainBinding inflation, SAVE button listener, name validation with error message, Tenant model instantiation, binding variable updates, and input clearing. Verified assembleDebug and unit tests passed.
- **Acceptance Criteria:**
  - SAVE button click validates non-empty tenant name
  - Tenant instance created and assigned to layout binding
  - Input fields cleared upon saving
  - make sure all existing tests pass
  - build pass
- **Duration:** 4m 20s

### Task_4_RunAndVerify: Run and verify the Tenant Management Screen app, instruct critic_agent to verify application stability (no crashes), confirm alignment with user requirements, and report critical UI issues.
- **Status:** COMPLETED
- **Updates:** All implementation steps and Try It Yourself requirements completed. App successfully built and ran on device/emulator without errors.
- **Acceptance Criteria:**
  - app does not crash
  - build pass
  - make sure all existing tests pass
  - all features verified
- **Duration:** 72h 36m 51s

### Task_5_ImplementAuthAndIntents: Implement LoginActivity and RegisterActivity with layouts (activity_login.xml, activity_register.xml), explicit intents for screen navigation, ACTION_VIEW for external link, and update AndroidManifest.xml launcher. Update MainActivity with login email Toast, full field validation, and CALL TENANT (ACTION_DIAL) / SHARE (ACTION_SEND) implicit intents.
- **Status:** COMPLETED
- **Updates:** Implemented LoginActivity, RegisterActivity, activity_login.xml, activity_register.xml, AndroidManifest.xml launcher updates, and MainActivity updates for Login Toast, full field validation, CALL TENANT (ACTION_DIAL), and SHARE (ACTION_SEND). Build passed cleanly.
- **Acceptance Criteria:**
  - LoginActivity and RegisterActivity created with XML layouts
  - LoginActivity set as launcher activity in AndroidManifest.xml
  - Explicit intents navigate between LoginActivity, RegisterActivity, and MainActivity passing email extra
  - ACTION_VIEW implicit intent opens website link from LoginActivity
  - MainActivity displays Toast on launch with logged in email and validates Name, Phone, Rent fields
  - CALL TENANT uses ACTION_DIAL and SHARE uses ACTION_SEND with fallback Toast if no tenant saved
  - build pass
- **Duration:** 4m 6s

### Task_6_RunAndVerify: Run and verify the full Tenant Management App with Authentication and Intents, instruct critic_agent to verify application stability (no crashes), confirm alignment with user requirements, and report critical UI issues.
- **Status:** COMPLETED
- **Updates:** Verified all flows on phone emulator: LoginActivity launcher, RegisterActivity account creation with email passing, Login to MainActivity navigation with email extra, login Toast, field validation errors, tenant saving, ACTION_DIAL call tenant dialer, and ACTION_SEND share chooser. Zero crashes, zero errors.
- **Acceptance Criteria:**
  - app does not crash
  - build pass
  - make sure all existing tests pass
- **Duration:** 15m 48s

### Task_7_ImplementLab6NavLifecycleState: Implement Lab 6 features: 1) Add TENANT_LIFECYCLE logging across MainActivity, LoginActivity, RegisterActivity. 2) Preserve/restore state in MainActivity (name, phone, rent, save_count). 3) Add Navigation Component and Safe Args setup in gradle files. 4) Make Tenant Serializable and create TenantRepository. 5) Create DashboardFragment, AddTenantFragment, ViewTenantsFragment with XML layouts. 6) Create nav_graph.xml with destinations, actions, and newTenant argument, host in MainActivity.
- **Status:** IN_PROGRESS
- **Acceptance Criteria:**
  - TENANT_LIFECYCLE log tag added to lifecycle methods of MainActivity, LoginActivity, RegisterActivity
  - onSaveInstanceState and onCreate state preservation implemented in MainActivity
  - Navigation dependencies and Safe Args plugin configured in build.gradle.kts
  - Tenant is Serializable and TenantRepository object manages tenants list, addTenant(), and totalRent()
  - DashboardFragment, AddTenantFragment, ViewTenantsFragment created with layouts and nav_graph.xml routing
  - build pass
- **StartTime:** 2026-10-20 20:31:35 EAT

### Task_8_RunAndVerify: Run and verify Lab 6 Navigation Practical 2 features including lifecycle logging, rotation state preservation, navigation graph with Safe Args between fragments, and tenant management via TenantRepository. Instruct critic_agent to verify application stability (no crashes) and confirm user requirements.
- **Status:** PENDING
- **Acceptance Criteria:**
  - app does not crash
  - build pass
  - make sure all existing tests pass
  - all features verified

