package zo.den.testtask3.presentation.ui.map
import kotlin.NoSuchElementException

fun <T> T?.throwIfNull(): T {
    return this ?: throw NoSuchElementException()
}