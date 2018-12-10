package zo.den.testtask3.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideAppContext(application: Application) : Context = application.applicationContext

}