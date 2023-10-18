package com.example.muidam2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.muidam2.model.SchoolOpsItemModel


@Composable
fun SchoolCard(){

    val viewModel = hiltViewModel<SchoolScreenViewModel>()
    val schoolCount by viewModel.schoolCount.collectAsState()

//    val navigateToDetails: (String) -> Unit = {beerId ->
//        navController.navigate("${Screens.Detail.route}/$beerId")
//    }

    LazyColumn{
        items(schoolCount){ school ->
            SchoolItem(school)
        }
    }


}


@Composable
fun SchoolItem(school: SchoolOpsItemModel){
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .height(99.dp)
                    .background(color = Color(0xFFD1D1D1))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "${school.dbn}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp),
                    fontSize = 20.sp
                )
//                Text(
//                    text = "${school.totalStudents}",
//                    color = Color.Black,
//                    modifier = Modifier
//                        .padding(end = 5.dp),
//                    textAlign = TextAlign.End
//                )
            }
        }

/**        Row(modifier = Modifier.padding(all = 8.dp)) {
//            Image(
//                painter = painterResource(R.drawable.schoolicon),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//
//            // We keep track if the message is expanded or not in this
//            // variable
//            var isExpanded by remember { mutableStateOf(false) }
//
//            // We toggle the isExpanded variable when we click on this Column
//            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
//                Text(
//                    text = "${school.schoolName}",
//                    color = MaterialTheme.colorScheme.secondary,
//                    style = MaterialTheme.typography.titleSmall,
//
//                )
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Surface(
//                    shape = MaterialTheme.shapes.medium,
//                    shadowElevation = 1.dp,
//                ) {
//                    Text(
//                        text = "${school.totalStudents}",
//                        modifier = Modifier.padding(all = 4.dp),
//                        // If the message is expanded, we display all its content
//                        // otherwise we only display the first line
//                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//            }
**/       }
