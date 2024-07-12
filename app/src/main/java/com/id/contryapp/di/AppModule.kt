package com.id.contryapp.di

import com.id.contryapp.data.CountryRepository
import com.id.contryapp.domain.ICountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideCountryRepository(countryRepository: CountryRepository): ICountryRepository
}