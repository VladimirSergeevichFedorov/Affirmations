package com.bignerdranch.android.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.affirmations.R
import com.bignerdranch.android.affirmations.model.Affirmation


// Адаптер для [RecyclerView] в [MainActivity]. Отображает объект данных [Affirmation].
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Предоставляем ссылку на представления для каждого элемента данных
    // Для сложных элементов данных может потребоваться более одного представления для каждого элемента, и
    // вы предоставляете доступ ко всем представлениям для элемента данных в держателе представления.
    // Каждый элемент данных - это просто объект подтверждения.

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    //Создавать новые представления (вызываемые менеджером по расположению)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            // создание новой позиции(строки) на экране
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
            return ItemViewHolder(adapterLayout)
        }
//Заменить содержимое представления (вызываемого диспетчером компоновки)
        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = dataset[position]
            holder.textView.text = context.resources.getString(item.stringResourceId)
            holder.imageView.setImageResource(item.imageResourceId)
        }

        override fun getItemCount() = dataset.size

}