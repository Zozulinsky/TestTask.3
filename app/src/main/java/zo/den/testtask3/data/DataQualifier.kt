package zo.den.testtask3.data

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DataQualifier (val name: String = "")