package com.example.todoapp.presentation.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todoapp.data.ItemStructure
import com.example.todoapp.presentation.theme.BackgroundColor
import com.example.todoapp.presentation.theme.BadgeColor
import com.example.todoapp.presentation.theme.PrimaryRed
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {


            ConstraintLayout(
//                        modifier = Modifier.padding(16.dp)
            ) {


                        val (titleRef, totalRef, lazyRowRef, fabItem, bottomSheet) = createRefs()
                        val itemList = mutableListOf<ItemStructure>()
                        itemList.add(ItemStructure(price = 200, name = "Food"))
                        itemList.add(ItemStructure(price = 400, name = "Data"))
                        itemList.add(ItemStructure(price = 2070, name = "Flenjo"))
//                        itemList.add(ItemStructure(price = 200, name = "Food"))
//                        itemList.add(ItemStructure(price = 400, name = "Data"))
//                        itemList.add(ItemStructure(price = 2070, name = "Flenjo"))
//                        itemList.add(ItemStructure(price = 200, name = "Food"))
//                        itemList.add(ItemStructure(price = 400, name = "Data"))
//                        itemList.add(ItemStructure(price = 2070, name = "Flenjo"))
//                        itemList.add(ItemStructure(price = 200, name = "Food"))
//                        itemList.add(ItemStructure(price = 400, name = "Data"))
//                        itemList.add(ItemStructure(price = 2070, name = "Flenjo"))
//                        itemList.add(ItemStructure(price = 200, name = "Food"))
//                        itemList.add(ItemStructure(price = 400, name = "Data"))
//                        itemList.add(ItemStructure(price = 2070, name = "Flenjo"))
//                        itemList.add(ItemStructure(price = 200, name = "Food"))
//                        itemList.add(ItemStructure(price = 400, name = "Data"))
//                        itemList.add(ItemStructure(price = 2070, name = "Flenjo"))
                        val total by remember {
                                    mutableStateOf(
                                                itemList.sumOf { it.price }
                                    )
                        }

                        val coroutineScope = rememberCoroutineScope()
                        val sheetState =
                                    rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)




                        Text(text = "coinTracer",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp,
                                    color = Color.Gray,
                                    modifier = Modifier.constrainAs(titleRef) {
                                                top.linkTo(parent.top)
                                                bottom.linkTo(titleRef.top)

                                    }
                        )
                        Text(text = "$$total",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp,
                                    color = Color.White,
                                    modifier = Modifier.constrainAs(totalRef) {
                                                top.linkTo(titleRef.bottom, margin = 10.dp)
                                                bottom.linkTo(lazyRowRef.top)

                                    })
                        LazyColumn(
                                    modifier = Modifier
                                                .constrainAs(lazyRowRef) {
                                                            top.linkTo(
                                                                        totalRef.bottom,
                                                                        margin = 5.dp
                                                            )
//                                                bottom.linkTo(fabItem.top)
                                                }
                        ) {
                                    items(itemList) { item ->
                                                SingleBudgetItem(item)

                                    }
                        }
                        Row(modifier = Modifier
                                    .constrainAs(fabItem) {
                                                bottom.linkTo(parent.bottom)
//                                                top.linkTo(lazyRowRef.bottom)
                                    }
                                    .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                        ) {
                                    FloatingActionButton(
                                                onClick = {
                                                          coroutineScope.launch {
                                                                      sheetState.show()
                                                          }
                                                },
                                                modifier = Modifier.clip(CircleShape),
                                                backgroundColor = PrimaryRed

                                    )
                                    {
                                                Icon(
                                                            imageVector = Icons.Filled.Add,
                                                            contentDescription = "Add an item",
                                                            tint = Color.White,
                                                            modifier = Modifier
                                                                        .size(30.dp)
                                                )
                                    }
                        }


//                        BottomSheet(sheetState)
                        var name by  remember {
                                    mutableStateOf("")
                        }
                        var  amount by  remember {
                                    mutableStateOf("")
                        }

                        ModalBottomSheetLayout(
                                    sheetState = sheetState,
                                    sheetContent = {
                                                Column(
                                                            modifier = Modifier
                                                                        .padding(10.dp)
                                                ) {
                                                            OutlinedTextField(
                                                                        value =name ,
                                                                        onValueChange = {
                                                                                    name = it
                                                                        },
                                                                        placeholder = { Text(text = "Input item")},
                                                                        modifier = Modifier
                                                                                    .fillMaxWidth()
                                                            )

                                                            OutlinedTextField(
                                                                        value =amount ,
                                                                        onValueChange = {
                                                                                    amount = it
                                                                        },
                                                                        placeholder = { Text(text = "Input amount")},
                                                                        modifier = Modifier
                                                                                    .fillMaxWidth()
                                                            )
                                                }
                                    },
                        ) {

                        }
            }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(sheetState:ModalBottomSheetState){
            var name by  remember {
                        mutableStateOf("")
            }
            var  amount by  remember {
                        mutableStateOf("")
            }

            ModalBottomSheetLayout(
                        sheetState = sheetState,
                        sheetContent = {
                                    Column() {
                                                OutlinedTextField(
                                                            value =name ,
                                                            onValueChange = {
                                                                        name = it
                                                            },
                                                            placeholder = { Text(text = "Input item")}
                                                )

                                                OutlinedTextField(
                                                            value =amount ,
                                                            onValueChange = {
                                                                        amount = it
                                                            },
                                                            placeholder = { Text(text = "Input amount")}
                                                )
                                    }
                        },
                        modifier = Modifier
//                                                .height(80.dp)
                                    .padding(10.dp)
            ) {

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