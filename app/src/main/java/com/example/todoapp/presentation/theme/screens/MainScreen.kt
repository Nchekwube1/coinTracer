package com.example.todoapp.presentation.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todoapp.presentation.theme.BackgroundColor

@Composable
fun MainScreen(){
ConstraintLayout(
            modifier = Modifier.padding(16.dp)
) {
val (titleRef) = createRefs()

                        Text(text = "coinTracer",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp,
                                    color = Color.White,
                        modifier = Modifier.constrainAs(titleRef){
                                    top.linkTo(parent.top)
                        }
                        )

}
}