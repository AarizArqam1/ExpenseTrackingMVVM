package com.alnafay.expensetrackingmvvm.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.alnafay.expensetrackingmvvm.R
import com.alnafay.expensetrackingmvvm.ui.theme.zinc

@Composable
fun HomeScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val(nameRow,list,card,topBar)=createRefs()
            Image(painter = painterResource(id = R.drawable.ic_topbar), contentDescription = "",
            modifier = Modifier.constrainAs(topBar){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp, start = 16.dp, end = 16.dp)
                    .constrainAs(nameRow) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column {
                    Text(text = "Good Morning",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(text = "Aariz Arqam",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Image(painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "",
                modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            CardItem(modifier = Modifier.constrainAs(card){
                top.linkTo(nameRow.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            )
            TransactionList(modifier = Modifier.constrainAs(list) {
                top.linkTo(card.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height= Dimension.fillToConstraints
            })
        }

    }
}

@Composable
fun CardItem(modifier: Modifier){
    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxWidth()
        .height(200.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(zinc)
        .padding(16.dp)) {
        Box(modifier= Modifier
            .fillMaxWidth()
            .weight(1F)) {
            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                Text(text = "Total Balance",
                    fontSize = 16.sp,
                    color = Color.White)

                Text(text = "PKR 100,000",
                    fontSize = 20.sp,
                    fontWeight=FontWeight.Bold,
                    color = Color.White)

            }
            Image(painter = painterResource(id = R.drawable.dots_menu), contentDescription = "",
            modifier=Modifier.align(Alignment.CenterEnd))
        }
        Box(modifier= Modifier
            .fillMaxWidth()
            .weight(1F)) {
            CardRowItem(modifier = Modifier.align(Alignment.CenterStart), title = "Income", amount = "300,000", image = R.drawable.ic_income)
            CardRowItem(modifier = Modifier.align(Alignment.CenterEnd), title = "Expense", amount = "200,000", image = R.drawable.ic_expense)

        }
    }
    
}

@Composable
fun TransactionList(modifier: Modifier){
    Column(modifier.padding(horizontal = 16.dp)) {
        Box(modifier = Modifier.fillMaxWidth()){
            Text(text = "Recent Transactions", fontSize = 20.sp)
            Text(text = "See All",
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterEnd))
        }
        TransactionItem(title = "Upword", amount = "$2,000", icon = R.drawable.ic_upwork, date = "incoming", color = Color.Green)

        TransactionItem(title = "Netflix", amount = "$2,000", icon = R.drawable.ic_netflix, date = "incoming", color = Color.Green)

        TransactionItem(title = "PayPal", amount = "$2,000", icon = R.drawable.ic_paypal, date = "incoming", color = Color.Green)

        TransactionItem(title = "Starbuck", amount = "$2,000", icon = R.drawable.ic_starbucks, date = "incoming", color = Color.Green)

        TransactionItem(title = "Youtube", amount = "$2,000", icon = R.drawable.ic_youtube, date = "incoming", color = Color.Green)
    }
}

@Composable
fun  TransactionItem(title: String,amount: String,icon:Int,date:String,color: Color){
    Box(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)){
        Row{
            Image(painter = painterResource(id = icon), contentDescription = "",
            modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Text(text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold)
                Text(text = date,
                    fontSize = 12.sp)
            }
            //Spacer(modifier = Modifier.weight(1F))
        }
        Text(text = amount,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.CenterEnd),
            color = color)
    }

}

@Composable
fun CardRowItem(modifier: Modifier,title:String,amount:String,image:Int){
    Column(modifier = modifier) {
        Row(){
            Image(painter = painterResource(id = image), contentDescription = "")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = title,
                fontSize = 16.sp,
                color = Color.White)
        }
        Text(text = "PKR "+amount,
            fontSize = 20.sp,
            color = Color.White)

    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
