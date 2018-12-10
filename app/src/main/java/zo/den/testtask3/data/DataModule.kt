package zo.den.testtask3.data

import dagger.Module

@Module(includes = [NetworkModule::class, DataBinder::class])
class DataModule {
}