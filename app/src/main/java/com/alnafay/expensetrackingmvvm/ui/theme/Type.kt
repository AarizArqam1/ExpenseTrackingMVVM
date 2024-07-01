package com.alnafay.expensetrackingmvvm.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alnafay.expensetrackingmvvm.R

val InterFont= FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_medium,FontWeight.Medium),
    Font(R.font.inter_semi_bold,FontWeight.SemiBold),
    Font(R.font.inter_bold,FontWeight.Bold),
    Font(R.font.inter_extra_bold,FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)