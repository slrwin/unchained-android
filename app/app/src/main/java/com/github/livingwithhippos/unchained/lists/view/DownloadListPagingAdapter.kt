package com.github.livingwithhippos.unchained.lists.view
import androidx.recyclerview.widget.DiffUtil
import com.github.livingwithhippos.unchained.R
import com.github.livingwithhippos.unchained.lists.model.DownloadItem
import com.github.livingwithhippos.unchained.utilities.DataBindingPagingAdapter

class DownloadListPagingAdapter(listener: DownloadListListener) : DataBindingPagingAdapter<DownloadItem, DownloadListListener>(DiffCallback(), listener) {

    class DiffCallback : DiffUtil.ItemCallback<DownloadItem>() {
        override fun areItemsTheSame(oldItem: DownloadItem, newItem: DownloadItem): Boolean =
            oldItem.id==newItem.id

        override fun areContentsTheSame(oldItem: DownloadItem, newItem: DownloadItem): Boolean {
            //todo: add progress if present
            return oldItem.link == newItem.link
        }
    }

    override fun getItemViewType(position: Int) = R.layout.item_list_download
}

interface DownloadListListener {
    fun onClick(item: DownloadItem)
}