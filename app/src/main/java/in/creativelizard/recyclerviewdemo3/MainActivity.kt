package `in`.creativelizard.recyclerviewdemo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     lateinit var mainItemAdapter: MainItemAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var items:ArrayList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        loadItems()
    }

    private fun loadItems() {
        for (i in 0 until 50){
            items.add(Item("Name - $i", "Sample Desc - $i",false,i))
        }

       // mainItemAdapter.notifyDataSetChanged()
    }

    private fun initialize() {
        items = ArrayList()
        layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        mainItemAdapter = MainItemAdapter(items,this,R.layout.item_list_cell)

        rlItems.layoutManager = layoutManager
        rlItems.adapter = mainItemAdapter
    }

    fun updateCheckedItemCount(i:Int) {
        getCheckedItemCount.text = "Selected Item $i"
    }
}