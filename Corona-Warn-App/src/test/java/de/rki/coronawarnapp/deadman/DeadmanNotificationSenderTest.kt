package de.rki.coronawarnapp.deadman

import android.content.Context
import de.rki.coronawarnapp.notification.GeneralNotifications
import de.rki.coronawarnapp.util.device.ForegroundState
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import testhelpers.BaseTest

class DeadmanNotificationSenderTest : BaseTest() {

    @MockK lateinit var context: Context
    @MockK lateinit var foregroundState: ForegroundState
    @MockK lateinit var notificationHelper: GeneralNotifications

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

    private fun createSender() = DeadmanNotificationSender(
        context = context,
        foregroundState = foregroundState,
        notificationHelper = notificationHelper
    )

    @Test
    fun `sender creation`() {
        shouldNotThrowAny {
            createSender()
        }
    }
}
