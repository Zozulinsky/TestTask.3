package zo.den.testtask3.presentation.ui.map

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MapQualifier (val name: String = "")