package com.ravimhzn.domainproperties.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ravimhzn.domainproperties.R
import com.ravimhzn.domainproperties.model.SearchResult
import com.ravimhzn.domainproperties.ui.theme.DomainPropertiesTheme
import com.ravimhzn.domainproperties.util.DimensionUtil.companyLogoHeight
import com.ravimhzn.domainproperties.util.DimensionUtil.contentSpacing
import com.ravimhzn.domainproperties.util.DimensionUtil.contentSpacingSmall
import com.ravimhzn.domainproperties.util.DimensionUtil.propertyRowHeight
import com.ravimhzn.domainproperties.util.DimensionUtil.textSizeBody

@Composable
fun PropertyRowView(results: SearchResult) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(propertyRowHeight)
            .background(Color.White)
            .padding(contentSpacing)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(start = contentSpacing, end = contentSpacingSmall)
            ) {
                Text(
                    text = results.price,
                    fontSize = textSizeBody,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(contentSpacingSmall))
                Text(
                    text = "${results.bathroom_count} bath, ${results.bedroom_count} bed, ${results.carspace_count} car",
                    fontSize = textSizeBody, //Todo use themed text
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = results.address,
                    fontSize = textSizeBody
                )
                Spacer(modifier = Modifier.height(6.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(companyLogoHeight),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    DomainPropertiesTheme {
        //PropertyRowView()
    }
}