package de.rki.coronawarnapp.vaccination.core.server.valueset.internal

import de.rki.coronawarnapp.exception.reporting.ErrorCodes
import de.rki.coronawarnapp.util.security.InvalidSignatureException

class ValueSetInvalidSignatureException(msg: String) : InvalidSignatureException(
    code = ErrorCodes.APPLICATION_CONFIGURATION_INVALID.code,
    message = msg
)
