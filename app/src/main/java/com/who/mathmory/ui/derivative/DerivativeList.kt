package com.who.mathmory.ui.derivative

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.who.mathmory.R

@Composable
fun DerivativeList() {
    //formula1
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula1_question), contentDescription = "derivative_formula1_question", modifier = Modifier.height(22.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula1_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula1_answer), contentDescription = "derivative_formula1_answer", modifier = Modifier.height(24.dp).padding(top = 3.dp))
    }
    //formula2
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula2_question), contentDescription = "derivative_formula2_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula2_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula2_answer), contentDescription = "derivative_formula2_answer", modifier = Modifier.height(28.dp).padding(bottom = 5.dp))
    }
    //formula3
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula3_question), contentDescription = "derivative_formula3_question", modifier = Modifier.height(30.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula3_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula3_answer), contentDescription = "derivative_formula3_answer", modifier = Modifier.height(65.dp).padding(top = 5.dp))
    }
    //formula4
    Spacer(modifier = Modifier.height(0.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula4_question), contentDescription = "derivative_formula4_question", modifier = Modifier.height(50.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula4_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula4_answer), contentDescription = "derivative_formula4_answer", modifier = Modifier.height(60.dp).padding(bottom = 5.dp))
    }
    //formula5
    Spacer(modifier = Modifier.height(10.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula5_question), contentDescription = "derivative_formula5_question", modifier = Modifier.height(30.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula5_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula5_answer), contentDescription = "derivative_formula5_answer", modifier = Modifier.height(26.dp).padding(bottom = 3.dp))
    }
    //formula6
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula6_question), contentDescription = "derivative_formula6_question", modifier = Modifier.height(30.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula6_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula6_answer), contentDescription = "derivative_formula6_answer", modifier = Modifier.height(25.dp).padding(bottom = 3.dp))
    }
    //formula7
    Spacer(modifier = Modifier.height(5.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula7_question), contentDescription = "derivative_formula7_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula7_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula7_answer), contentDescription = "derivative_formula7_answer", modifier = Modifier.height(60.dp).padding(bottom = 10.dp))
    }
    //formula8
    Spacer(modifier = Modifier.height(0.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula8_question), contentDescription = "derivative_formula8_question", modifier = Modifier.height(30.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula8_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula8_answer), contentDescription = "derivative_formula8_answer", modifier = Modifier.height(60.dp).padding(bottom = 3.dp))
    }
    //formula9
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula9_question), contentDescription = "derivative_formula9_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula9_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula9_answer), contentDescription = "derivative_formula9_answer", modifier = Modifier.height(22.dp))
    }
    //formula10
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula10_question), contentDescription = "derivative_formula10_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula10_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula10_answer), contentDescription = "derivative_formula10_answer", modifier = Modifier.height(22.dp))
    }
    //formula11
    Spacer(modifier = Modifier.height(7.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula11_question), contentDescription = "derivative_formula11_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula11_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula11_answer), contentDescription = "derivative_formula11_answer", modifier = Modifier.height(58.dp).padding(bottom = 3.dp))
    }
    //formula12
    Spacer(modifier = Modifier.height(7.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula12_question), contentDescription = "derivative_formula12_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula12_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula12_answer), contentDescription = "derivative_formula12_answer", modifier = Modifier.height(58.dp).padding(bottom = 3.dp))
    }
    //formula13
    Spacer(modifier = Modifier.height(5.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula13_question), contentDescription = "derivative_formula13_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula13_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula13_answer), contentDescription = "derivative_formula13_answer", modifier = Modifier.height(58.dp))
    }
    //formula14
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula14_question), contentDescription = "derivative_formula146_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula14_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula14_answer), contentDescription = "derivative_formula14_answer", modifier = Modifier.height(60.dp).padding(top = 3.dp))
    }
    //formula15
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula15_question), contentDescription = "derivative_formula15_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula15_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula15_answer), contentDescription = "derivative_formula15_answer", modifier = Modifier.height(55.dp))
    }
    //formula16
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula16_question), contentDescription = "derivative_formula16_question", modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_equal), contentDescription = "derivative_formula16_equal", modifier = Modifier.height(10.dp).width(15.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Image(painter = rememberAsyncImagePainter(model = R.drawable.derivative_formula16_answer), contentDescription = "derivative_formula16_answer", modifier = Modifier.height(55.dp))
    }
    Spacer(modifier = Modifier.height(16.dp))
}