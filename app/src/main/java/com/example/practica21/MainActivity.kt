package com.example.practica21

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica21.ui.theme.Practica21Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica21Theme {
                ViewContainer()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    device = "spec:width=411dp,height=891dp,orientation=portrait",
    locale = "es-rMX",
    showBackground = true,
)
@Composable
fun ViewContainer(){
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.title)) },
                colors = TopAppBarColors(
                    titleContentColor = Color.White,
                    subtitleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    scrolledContainerColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_btn),
                            tint = Color.White
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.bottom_btn),
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        },
        floatingActionButton = {
            val context = LocalContext.current
            FloatingActionButton(onClick = {
                Toast.makeText(
                    context,
                    R.string.home_fab_text,
                    Toast.LENGTH_LONG
                ).show()
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = "I am a Snackbar! <3",
                        actionLabel = "Do something"
                    )
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.home_fab_text)
                )
            }
        }
        //modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        ContentView(modifier = Modifier.padding(innerPadding))
    }
}
@Composable
fun ContentView(modifier: Modifier = Modifier) {
    //var counter by remember { mutableStateOf(0) }
    var counter by rememberSaveable { mutableStateOf(0) }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Yellow)
    )
    {
        item {
            Image(
                painter = painterResource(id = R.drawable.fannybrasilena),
                contentDescription = "Ilustración de Android",
                modifier = Modifier.fillMaxWidth().height(400.dp)
            )
            Row(modifier = Modifier.padding(top=2.dp)){
                Image(
                    painter = painterResource(id= R.drawable.baseline_stars_24),
                    contentDescription = "Star",
                    modifier = Modifier.clickable{ counter++ }
                )
                Text(
                    text = counter.toString(),
                    fontSize = 20.sp,
                    color= Color.DarkGray,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Text(
                text = stringResource(R.string.image_description),
                fontSize = 24.sp,
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center

            )
            Text(
                text = stringResource(R.string.materia),
                fontSize = 24.sp,
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center

            )
            Text(
                text = stringResource(R.string.nombre),
                fontSize = 25.sp,
                color = Color.Magenta,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.apellido),
                fontSize = 24.sp,
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center

            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {
                item {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(id = R.drawable.gokupelon),
                        contentDescription = "mobileApps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(id = R.drawable.kuvin),
                        contentDescription = "mobileApps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(id = R.drawable.charlie),
                        contentDescription = "mobileApps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "mobileApps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(id = R.drawable.mobileapp),
                        contentDescription = "mobileApps"
                    )
                }
            }
        }
    }
}