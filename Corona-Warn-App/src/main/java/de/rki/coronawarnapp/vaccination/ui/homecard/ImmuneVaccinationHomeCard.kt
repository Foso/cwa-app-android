package de.rki.coronawarnapp.vaccination.ui.homecard

import android.view.ViewGroup
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.databinding.VaccinationHomeImmuneCardBinding
import de.rki.coronawarnapp.ui.main.home.HomeAdapter
import de.rki.coronawarnapp.util.lists.diffutil.HasPayloadDiffer
import de.rki.coronawarnapp.vaccination.core.VaccinatedPerson

class ImmuneVaccinationHomeCard(parent: ViewGroup) :
    HomeAdapter.HomeItemVH<ImmuneVaccinationHomeCard.Item, VaccinationHomeImmuneCardBinding>(
        R.layout.home_card_container_layout,
        parent
    ) {

    override val viewBinding = lazy {
        VaccinationHomeImmuneCardBinding.inflate(layoutInflater, itemView.findViewById(R.id.card_container), true)
    }

    override val onBindData: VaccinationHomeImmuneCardBinding.(
        item: Item,
        payloads: List<Any>
    ) -> Unit = { item, payloads ->
        val curItem = payloads.filterIsInstance<Item>().singleOrNull() ?: item

        personName.text = curItem.vaccinatedPerson.fullName

        itemView.setOnClickListener { curItem.onClickAction(item) }
    }

    data class Item(
        override val vaccinatedPerson: VaccinatedPerson,
        val onClickAction: (Item) -> Unit,
    ) : VaccinationStatusItem, HasPayloadDiffer {

        override fun diffPayload(old: Any, new: Any): Any? = if (old::class == new::class) new else null
    }
}
