package de.rki.coronawarnapp.vaccination.core

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.rki.coronawarnapp.task.Task
import de.rki.coronawarnapp.task.TaskFactory
import de.rki.coronawarnapp.task.TaskTypeKey
import de.rki.coronawarnapp.vaccination.core.execution.task.VaccinationUpdateTask
import de.rki.coronawarnapp.vaccination.core.server.VaccinationServerModule

@Module(
    includes = [
        VaccinationServerModule::class
    ]
)
abstract class VaccinationModule {
    @Binds
    @IntoMap
    @TaskTypeKey(VaccinationUpdateTask::class)
    abstract fun vaccinationUpdateTaskFactory(
        factory: VaccinationUpdateTask.Factory
    ): TaskFactory<out Task.Progress, out Task.Result>
}
