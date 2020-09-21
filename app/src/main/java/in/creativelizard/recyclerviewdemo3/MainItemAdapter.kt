package `in`.creativelizard.recyclerviewdemo3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_cell.view.*

class MainItemAdapter (
    private val arrayList: List<Item>,
    private val context: Context,
    private val layout: Int) : RecyclerView.Adapter<MainItemAdapter.ViewHolder>() {
    private val checkedItems = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun getCheckedItemCount():Int {
        checkedItems.clear()
        for(itm in arrayList){
            if (itm.isChecked){
                checkedItems.add(itm)
            }
        }
        return checkedItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Item) {

            with(itemView){
                tvTitle.text = item.name
                tvDesc.text = item.desc

                chkItem.isChecked = item.isChecked

                setOnClickListener {
                    item.isChecked = !item.isChecked
                    notifyItemChanged(layoutPosition)

                    val count = getCheckedItemCount()
                    (context as MainActivity).updateCheckedItemCount(count)
                }

            }


        }
    }
}