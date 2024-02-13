package com.ravimhzn.domainproperties.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ravimhzn.domainproperties.R
import com.ravimhzn.domainproperties.model.SearchResult
import com.ravimhzn.domainproperties.ui.theme.DomainPropertiesTheme
import com.ravimhzn.domainproperties.util.DimensionUtil.companyLogoHeight
import com.ravimhzn.domainproperties.util.DimensionUtil.contentSpacing
import com.ravimhzn.domainproperties.util.DimensionUtil.contentSpacingSmall
import com.ravimhzn.domainproperties.util.DimensionUtil.textSizeBody

@Composable
fun PropertyRowView(results: SearchResult) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        Card(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp,
                    end = 8.dp,
                    bottom = 4.dp
                )
                .fillMaxWidth()
                .height(220.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(colorResource(id = R.color.white))
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(results.media[0].image_url)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_launcher_background)
                        .build(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(start = contentSpacing, end = contentSpacingSmall)
                ) {
                    Text(
                        text = results.price ?: "0.00",
                        fontSize = textSizeBody,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(contentSpacingSmall))
                    Text(
                        text = "${results.bathroom_count} bath, ${results.bedroom_count} bed, ${results.carspace_count} car",
                        //text = "Test",
                        fontSize = textSizeBody, //Todo use themed text
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = results.address ?: "",
                        fontSize = textSizeBody
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(results.advertiser?.images?.logo_url)
                            .crossfade(true)
                            .placeholder(R.drawable.ic_launcher_background)
                            .build(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(companyLogoHeight),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }
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
