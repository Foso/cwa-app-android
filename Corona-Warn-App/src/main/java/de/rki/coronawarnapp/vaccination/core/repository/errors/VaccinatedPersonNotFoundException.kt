package de.rki.coronawarnapp.vaccination.core.repository.errors

import de.rki.coronawarnapp.vaccination.core.VaccinationException

class VaccinatedPersonNotFoundException(
    message: String
) : VaccinationException(
    message = message,
    cause = null
)
