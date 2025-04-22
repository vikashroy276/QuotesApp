package com.example.tutorail1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    val quotesList = listOf(
        QuoteDetails(
            name = "The only true wisdom is in knowing you know nothing",
            address = "Socrates"
        ),
        QuoteDetails(
            name = "I would never die for my beliefs because I might be wrong",
            address = "Bertrand Russell"
        ),
        QuoteDetails(
            name = "Happiness is the meaning and the purpose of life",
            address = "Aristotle"
        ),
        QuoteDetails(name = "We live in the best of all possible worlds", address = "Leibniz"),
        QuoteDetails(name = "The unexamined life is not worth living", address = "Socrates"),
        QuoteDetails(name = "I am, I exist", address = "René Descartes"),
        QuoteDetails(name = "Time is a flat circle", address = "Friedrich Nietzsche"),
        QuoteDetails(
            name = "Liberty is obedience to the law which one has laid down for oneself",
            address = "Jean-Jacques Rousseau"
        ),
        QuoteDetails(
            name = "All that is necessary for the triumph of evil is that good men do nothing",
            address = "Edmund Burke"
        ),
        QuoteDetails(
            name = "A wise man proportions his belief to the evidence",
            address = "David Hume"
        ),
        QuoteDetails(
            name = "The function of prayer is not to influence God, but rather to change the nature of the one who prays",
            address = "Søren Kierkegaard"
        ),
        QuoteDetails(name = "Happiness is a warm gun", address = "John Lennon"),
        QuoteDetails(
            name = "To enjoy the things we ought and to hate the things we ought has the greatest bearing on excellence of character",
            address = "Aristotle"
        ),
        QuoteDetails(
            name = "We are too weak to discover the truth by reason alone",
            address = "Blaise Pascal"
        ),
        QuoteDetails(
            name = "Morality is not the doctrine of how we may make ourselves happy, but how we may make ourselves worthy of happiness",
            address = "Immanuel Kant"
        ),
        QuoteDetails(
            name = "The most important kind of freedom is to be what you really are",
            address = "Jim Morrison"
        ),
        QuoteDetails(name = "Existence precedes essence", address = "Jean-Paul Sartre"),
        QuoteDetails(name = "To fear love is to fear life", address = "Bertrand Russell"),
        QuoteDetails(
            name = "It is undesirable to believe a proposition when there is no ground whatever for supposing it true",
            address = "Bertrand Russell"
        ),
        QuoteDetails(
            name = "No great mind has ever existed without a touch of madness",
            address = "Aristotle"
        ),
        QuoteDetails(
            name = "You only live once, but if you do it right, once is enough",
            address = "Mae West"
        ),
        QuoteDetails(
            name = "The limits of my language mean the limits of my world",
            address = "Ludwig Wittgenstein"
        ),
        QuoteDetails(
            name = "Without music, life would be a mistake",
            address = "Friedrich Nietzsche"
        ),
        QuoteDetails(name = "Man is the measure of all things", address = "Protagoras"),
        QuoteDetails(
            name = "The heart has its reasons which reason knows not",
            address = "Blaise Pascal"
        ),
        QuoteDetails(
            name = "It is not what we do, but also what we do not do, for which we are accountable",
            address = "Molière"
        ),
        QuoteDetails(name = "Even while they teach, men learn", address = "Seneca"),
        QuoteDetails(
            name = "The first and greatest victory is to conquer yourself",
            address = "Plato"
        ),
        QuoteDetails(
            name = "There is but one truly serious philosophical problem, and that is suicide",
            address = "Albert Camus"
        ),
        QuoteDetails(
            name = "What is rational is actual and what is actual is rational",
            address = "Georg Wilhelm Friedrich Hegel"
        ),
        QuoteDetails(name = "History is philosophy teaching by examples", address = "Thucydides"),
        QuoteDetails(name = "All men by nature desire to know", address = "Aristotle"),
        QuoteDetails(name = "Only the educated are free", address = "Epictetus"),
        QuoteDetails(name = "Hell is truth seen too late", address = "Thomas Hobbes"),
        QuoteDetails(
            name = "You can discover more about a person in an hour of play than in a year of conversation",
            address = "Plato"
        ),
        QuoteDetails(name = "He who opens a school door, closes a prison", address = "Victor Hugo"),
        QuoteDetails(
            name = "Act only according to that maxim whereby you can, at the same time, will that it should become a universal law",
            address = "Immanuel Kant"
        ),
        QuoteDetails(
            name = "Man is born free, and everywhere he is in chains",
            address = "Jean-Jacques Rousseau"
        ),
        QuoteDetails(
            name = "A life without cause is a life without effect",
            address = "Barbarella"
        ),
        QuoteDetails(
            name = "The reading of all good books is like conversation with the finest men of past centuries",
            address = "René Descartes"
        ),
        QuoteDetails(
            name = "Freedom is nothing but a chance to be better",
            address = "Albert Camus"
        ),
        QuoteDetails(name = "I do not think therefore I am", address = "Gilles Deleuze"),
        QuoteDetails(
            name = "I would rather be an unsatisfied Socrates than a satisfied pig",
            address = "John Stuart Mill"
        ),
        QuoteDetails(name = "Leisure is the basis of culture", address = "Josef Pieper"),
        QuoteDetails(name = "A man with courage makes a majority", address = "Andrew Jackson"),
        QuoteDetails(
            name = "The price of anything is the amount of life you exchange for it",
            address = "Henry David Thoreau"
        ),
        QuoteDetails(name = "He who opens a school, closes a jail", address = "Victor Hugo"),
        QuoteDetails(
            name = "Science is what you know, philosophy is what you don't know",
            address = "Bertrand Russell"
        ),
        QuoteDetails(
            name = "Not life, but good life, is to be chiefly valued",
            address = "Socrates"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotesScreen(quotesList)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotesScreen(quotesList: List<QuoteDetails>) {
    val quotes = remember { quotesList }
    var showDialog by remember { mutableStateOf(false) }
    var selectedQuotes by remember { mutableStateOf<QuoteDetails?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = { Text(" Quotes App") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(quotes) { quote ->
                Surface(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            selectedQuotes = quote
                            showDialog = true
                        },
                    tonalElevation = 4.dp,
                    shadowElevation = 4.dp,
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = painterResource(R.drawable.format_quote),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(40.dp)
                                .rotate(180f)
                                .background(Color.Black),
                            alignment = Alignment.TopStart,
                            colorFilter = ColorFilter.tint(Color.White)
                        )

                        Spacer(Modifier.width(8.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = quote.name,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )

                            Box(
                                Modifier
                                    .background(Color(0xFFEEEEEE))
                                    .fillMaxWidth(.4f)
                                    .height(1.dp)
                            )

                            Text(
                                text = quote.address,
                                color = Color.Black,
                                fontWeight = FontWeight.Thin,
                                modifier = Modifier.padding(top = 4.dp),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }

        if (showDialog && selectedQuotes != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x88000000))
                    .clickable { showDialog = false }
            ) {
                QuoteScreen(quote = selectedQuotes)
            }
        }
    }
}

@Composable
fun QuoteScreen(quote: QuoteDetails?) {
    if (quote == null) return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFF3F3F3)
                    )
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "\"${quote.name}\"",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    lineHeight = 32.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "— ${quote.address}",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    MaterialTheme {
        QuoteScreen(
            quote = QuoteDetails(
                name = "The unexamined life is not worth living",
                address = "Socrates"
            )
        )
    }
}

data class QuoteDetails(
    val name: String, val address: String
)
