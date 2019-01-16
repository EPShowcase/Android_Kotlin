package info.megahard.epshowcase.bio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import info.megahard.epshowcase.R
import info.megahard.epshowcase.databinding.ItemBioBinding


class BioAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<BioAdapter.ViewHolder>() {
    private val myDataSet: ArrayList<BioModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemBioBinding>(
            LayoutInflater.from(parent.context), R.layout.item_bio, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding.viewModel = getItemViewModel(position)
        binding.executePendingBindings()
    }

    private fun getItemViewModel(position: Int): BioItemViewModel {
        return BioItemViewModel(myDataSet[position])
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }

    fun setData(data: List<BioModel>) {
        myDataSet.clear()
        myDataSet.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemBioBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)
}