package zo.den.testtask3.presentation.ui.product

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ProductQualifier (val name: String = "")