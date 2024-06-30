package com.alnafay.expensetrackingmvvm.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alnafay.expensetrackingmvvm.R

@Composable
fun AddExpense(){
    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val(titleRow,topBar,Card)=createRefs()
            Image(painter = painterResource(id = R.drawable.ic_topbar), contentDescription = "",
            modifier = Modifier.constrainAs(topBar){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
//            TitleBar(modifier = Modifier.constrainAs(titleRow) {
//                top.linkTo(parent.top)
//                start.linkTo(parent.start)
//                end.linkTo(parent.end)
//            })

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 16.dp, end = 16.dp)
                .constrainAs(titleRow) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ){
                Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "", modifier = Modifier.align(
                    Alignment.CenterStart))
                Text(text = "Add Expense",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color= Color.White,
                    modifier = Modifier.align(Alignment.Center))
                Image(painter = painterResource(id = R.drawable.dots_menu), contentDescription = "", modifier = Modifier.align(
                    Alignment.CenterEnd)
                )
            }
            DataForm(modifier = Modifier
                .padding(top = 50.dp)
                .constrainAs(Card) {
                    top.linkTo(titleRow.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }
    }
}

@Composable
fun TitleBar(modifier: Modifier){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 64.dp, start = 16.dp, end = 16.dp)
    ){
        Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "", modifier = Modifier.align(
            Alignment.CenterStart))
        Text(text = "Add Expense",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color= Color.White,
            modifier = Modifier.align(Alignment.Center))
        Image(painter = painterResource(id = R.drawable.dots_menu), contentDescription = "", modifier = Modifier.align(
            Alignment.CenterEnd))

    }
}

@Composable
fun DataForm(modifier: Modifier){
    Column(
        modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
            .wrapContentHeight()) {
        Text(text = "Name",
        fontSize = 14.sp,
        color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Amount",
            fontSize = 14.sp,
            color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Date",
            fontSize = 14.sp,
            color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .fillMaxWidth()) {
            Text(text = "Add Expense",
            color = Color.White,
            fontSize = 14.sp)
        }
    }



}


@Preview(showBackground = true)
@Composable
fun AddExpensePreview(){
    AddExpense()
}