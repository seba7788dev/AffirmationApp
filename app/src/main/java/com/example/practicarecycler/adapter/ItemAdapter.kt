package com.example.practicarecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicarecycler.R
import com.example.practicarecycler.data.DataSource
import com.example.practicarecycler.model.Affirmation

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
// Los contenedores de vistas también agregan información que RecyclerView usa para mover las vistas de manera eficiente por la pantalla.

class ItemAdapter(private val context:Context
                    ,private val dataset:List<Affirmation>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        val textView:TextView=view.findViewById(R.id.item_title)
        val imageView:ImageView=view.findViewById(R.id.item_image)
    }
    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(adapterLayout)
    }
    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount()=dataset.size

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=dataset[position]
        holder.textView.text=context.resources.getString(item.stringResourceID)
        holder.imageView.setImageResource(item.imageResourceID)
    }

}