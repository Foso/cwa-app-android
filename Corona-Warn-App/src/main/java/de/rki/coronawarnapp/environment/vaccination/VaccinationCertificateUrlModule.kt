package de.rki.coronawarnapp.environment.vaccination

import dagger.Module
import dagger.Provides
import dagger.Reusable
import de.rki.coronawarnapp.environment.BaseEnvironmentModule
import de.rki.coronawarnapp.environment.EnvironmentSetup

@Module
class VaccinationCertificateUrlModule : BaseEnvironmentModule() {

    @Reusable
    @VaccinationCertificateCDNUrl
    @Provides
    fun provideVaccinationValueSetUrl(environmentSetup: EnvironmentSetup): String =
        requireValidUrl(environmentSetup.vaccinationCdnUrl)
}
