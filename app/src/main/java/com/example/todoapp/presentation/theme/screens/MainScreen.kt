package com.example.todoapp.presentation.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todoapp.data.ItemStructure
import com.example.todoapp.presentation.theme.BackgroundColor
import com.example.todoapp.presentation.theme.BadgeColor

@Composable
fun MainScreen() {
            ConstraintLayout(
                        modifier = Modifier.padding(16.dp)
            ) {


                        val (titleRef, totalRef, lazyRowRef) = createRefs()
                        val itemList = mutableListOf<ItemStructure>()
                        itemList.add(ItemStructure(price = 200, name = "Food"))
                        itemList.add(ItemStructure(price = 400, name = "Data"))
                        itemList.add(ItemStructure(price = 2070, name = "Flenjo"))
                        val name by remember { mutableStateOf(
                                    itemList.sumOf { it.price }
                        ) }




                        Text(text = "coinTracer",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp,
                                    color = Color.Gray,
                                    modifier = Modifier.constrainAs(titleRef) {
                                                top.linkTo(parent.top)

                                    }
                        )
                        Text(text = "$$name",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp,
                                    color = Color.White,
                                    modifier = Modifier.constrainAs(totalRef) {
                                                top.linkTo(titleRef.bottom, margin = 10.dp)

                                    })
                        LazyColumn(
                                    modifier = Modifier.constrainAs(lazyRowRef) {
                                                top.linkTo(totalRef.bottom, margin = 5.dp)
                                    }
                        ) {
                                    items(itemList) { item ->
                                                SingleBudgetItem(item)

                                    }
                        }

            }
}

@Composable
fun SingleBudgetItem(item: ItemStructure) {
            Row(
                        modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
            ) {
                        Row(
                                    modifier = Modifier
                                                .clip(CircleShape)
                                                .background(
                                                            color = BadgeColor
                                                )
                                                .padding(vertical = 5.dp, horizontal = 8.dp)

                        ) {
                                    Text(
                                                text = "$${item.price}",
                                                fontSize = 16.sp,
                                                color = Color.White,
                                                fontWeight = FontWeight.Bold,

                                                )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                                    text = item.name,
                                    fontSize = 17.sp,
                                    color = Color.White,
                        )
            }
}