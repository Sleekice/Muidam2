
package com.example.muidam2.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.muidam2.R
import com.example.muidam2.ui.theme.BackgroundColorLogin
import com.example.muidam2.ui.theme.BgColor
import com.example.muidam2.ui.theme.GrayColor
import com.example.muidam2.ui.theme.Purple80
import com.example.muidam2.ui.theme.TextColor
import com.example.muidam2.ui.theme.TextLogin

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LoginPage() {
    val localFocusManager = LocalFocusManager.current

    val textValue = remember { mutableStateOf("") }

    val password = remember { mutableStateOf("") }

    val passwordVisible = remember { mutableStateOf(false) }

    //Rainbow Border Color
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    val borderWidth = 4.dp



//    val annotatedString = buildAnnotatedString {
//        append(initialText)
//        withStyle(style = SpanStyle(color = Primary)) {
//            pushStringAnnotation(tag = loginText, annotation = loginText)
//            append("Login")
//        }
//    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = BackgroundColorLogin,
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColorLogin)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Resize Image
                //https://developer.android.com/jetpack/compose/graphics/images/customize

                Image(
                    painter = painterResource(id = R.drawable.school),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .border(
                            BorderStroke(borderWidth, rainbowColorsBrush),
                            CircleShape
                        )
                        .padding(borderWidth)
                        .clip(CircleShape)
                )

                Text(
                    text = stringResource(R.string.welcome_back),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn()
                        .padding(bottom = 10.dp),
                    style = TextStyle(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                    ),
                    color = TextLogin,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.login),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 40.dp)
                        .padding(bottom = 20.dp),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    ),
                    color = TextLogin,
                    textAlign = TextAlign.Center
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(BackgroundColorLogin),
                    label = { Text(text = stringResource(R.string.enter_email)) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Red,
                        focusedLabelColor = BgColor,
                        cursorColor = Color.Green,
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    singleLine = true,
                    maxLines = 1,
                    value = textValue.value,
                    onValueChange = {
                        textValue.value = it
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.message),
                            contentDescription = ""
                        )
                    },
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(BackgroundColorLogin),
                    label = { Text(text = "Password") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Red,
                        focusedLabelColor = BgColor,
                        cursorColor = Color.Green,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true,
                    keyboardActions = KeyboardActions {
                        localFocusManager.clearFocus()
                    },
                    maxLines = 1,
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock),
                            contentDescription = ""
                        )
                    },
                    trailingIcon = {

                        val iconImage = if (passwordVisible.value) {
                            Icons.Filled.Visibility
                        } else {
                            Icons.Filled.VisibilityOff
                        }

                        val description = if (passwordVisible.value) {
                            stringResource(id = R.string.forgot_password)
                        } else {
                            stringResource(id = R.string.show_password)
                        }

                        IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                            Icon(imageVector = iconImage, contentDescription = description)
                        }
                    },
                    visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                )

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(48.dp),
                    onClick = {

                    },
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    shape = RoundedCornerShape(50.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(48.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Purple80,
                                        TextLogin
                                    )
                                ),
                                shape = RoundedCornerShape(50.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        color = GrayColor,
                        thickness = 1.dp
                    )

                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = stringResource(R.string.or),
                        fontSize = 18.sp,
                        color = TextColor
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        color = GrayColor,
                        thickness = 1.dp
                    )
                }


                Spacer(modifier = Modifier.height(40.dp))

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                    .fillMaxWidth()
                        .heightIn(48.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .absolutePadding(top = 5.dp)
                ) {
                    Text(
                        text = stringResource(R.string.no_account_yet_msg),
                        color = Color(red = 255, green = 125, blue = 0)
                    )

                }
            }
            }

                }
            }


