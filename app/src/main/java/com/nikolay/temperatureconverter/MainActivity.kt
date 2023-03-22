package com.nikolay.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikolay.temperatureconverter.ui.theme.TemperatureConverterTheme
import com.nikolay.temperatureconverter.ui.theme.jetBlack
import com.nikolay.temperatureconverter.ui.theme.openSans
import com.nikolay.temperatureconverter.ui.theme.whiteSmoke

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = whiteSmoke,
                ) {
                    ConverterUI()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ConverterUI() {
    var celsiusInput by rememberSaveable { mutableStateOf("") }
    var fahrenheitInput by rememberSaveable { mutableStateOf("") }
    var round by rememberSaveable { mutableStateOf(false) }
//    var backgroundColor by remember { mutableStateOf(whiteSmoke) }

    val celsiusValue = celsiusInput.toDoubleOrNull() ?: 0.0
    val fahrenheitValue = fahrenheitInput.toDoubleOrNull() ?: 0.0

    val focusManager = LocalFocusManager.current

    val celsiusToFahrenheit = celsiusToFahrenheit(celsiusValue, round)
    val fahrenheitToCelsius = fahrenheitToCelsius(fahrenheitValue, round)

    Column(
        Modifier
            .padding(22.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ice),
            contentDescription = null,
            Modifier
                .height(225.dp),
        )
        Text(
            text = stringResource(R.string.main_title),
            fontSize = 20.sp,
            color = jetBlack,
            fontFamily = openSans,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp,
        )
        NumberField(
            label = R.string.celsius,
            value = celsiusInput,
            onChangeValue = { celsiusInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
        )
        NumberField(
            label = R.string.fahrenheit,
            value = fahrenheitInput,
            onChangeValue = { fahrenheitInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        Text(
            text = stringResource(
                R.string.from_celsius_to_fahrenheit,
                celsiusInput,
                celsiusToFahrenheit,
            ),
            fontSize = 20.sp,
            fontFamily = openSans,
            fontWeight = FontWeight.Normal,
        )
        Text(
            text = stringResource(
                R.string.from_fahrenheit_to_celsius,
                fahrenheitInput,
                fahrenheitToCelsius,
            ),
            fontSize = 20.sp,
            fontFamily = openSans,
            fontWeight = FontWeight.Normal,
        )
        Round(
            checked = round,
            onCheckedChange = { round = !round },
            text = R.string.round,
        )
    }
}

@Composable
fun Round(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RoundText(text = text)
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                uncheckedTrackColor = jetBlack,
                uncheckedThumbColor = Color.LightGray,
                checkedTrackColor = Color.LightGray,
                checkedThumbColor = jetBlack,
            ),
        )
    }
}

@Composable
fun RoundText(@StringRes text: Int) {
    Text(
        text = stringResource(text),
        fontSize = 20.sp,
        color = jetBlack
    )
}

@Composable
fun NumberField(
    @StringRes label: Int,
    value: String,
    onChangeValue: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
) {
    TextField(
        value = value,
        onValueChange = onChangeValue,
        label = {
            Text(
                text = stringResource(label),
                color = whiteSmoke,
                fontFamily = openSans,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.DarkGray,
            backgroundColor = jetBlack,
            textColor = whiteSmoke,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(15.dp),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}