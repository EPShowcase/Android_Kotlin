package info.megahard.epshowcase.bio

import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import info.megahard.epshowcase.base.BaseItemViewModel

class BioItemViewModel(model: BioModel) : BaseItemViewModel<BioModel>(model) {

    fun displayName(): String {
        return "${model.firstName} ${model.lastName}"
    }

    fun curriculumVitae(): Spanned? {
        return HtmlCompat.fromHtml(model.curriculumVitae, FROM_HTML_MODE_LEGACY)
    }
}