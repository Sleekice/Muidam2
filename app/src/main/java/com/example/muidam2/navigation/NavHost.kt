//package com.example.muidam2.navigation
//
//import android.annotation.SuppressLint
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarColors
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.graphics.Color
//import androidx.navigation.NavController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.muidam2.navigation.Screens.LoginScreen
//import com.example.muidam2.ui.screens.login.LoginPage
//
//
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppNavigation() {
//
//    val navController = rememberNavController()
//    val targetScreen = rememberSaveable { mutableStateOf(LoginScreen) }
//
//    // Nav host integrations
//    Scaffold(
//        topBar = { Toolbar(targetScreen = targetScreen.value, navController = navController)}
//    ) {
//        NavHost(
//            navController = navController,
//            startDestination = LoginScreen.route
//        ) {
//            composable(LoginScreen.route) {
//                targetScreen.value = LoginScreen
//                LoginPage(navController = navController)
//
//            }
//
//
//            }
//        }
//    }
//
//
//// Toolbar integration
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Toolbar(
//    targetScreen: Screens,
//    navController: NavController
//) = if (targetScreen != Screens.LoginScreen) {
//    TopAppBar(
//        title = { Text(text = targetScreen.header, color = LoginScreen) },
//        navigationIcon = { BackButton(navController = navController) },
//
//    )
//} else {
//    TopAppBar(
//        title = { Text(text = targetScreen.header, color = Color.White) },
////        backgroundColor = Color(0xFF6F7FF7)
//    )
//}
//
//// Back button integration
//@Composable
//fun BackButton(navController: NavController) {
//    IconButton(onClick = { navController.popBackStack() }) {
//        Icon(
//            imageVector = Icons.Filled.ArrowBack,
//            contentDescription = "Back",
//            tint = Color.Red
//
//        )
//    }
//}
//
