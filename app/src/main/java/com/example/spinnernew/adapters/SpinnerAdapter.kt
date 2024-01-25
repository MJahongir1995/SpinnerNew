package com.example.spinnernew.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.spinnernew.databinding.ItemSpinnerBinding
import com.example.spinnernew.models.Fruits

class SpinnerAdapter(private val list: List<Fruits>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Fruits {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val itemSpinnerBinding: ItemSpinnerBinding

        if (p1 == null) {
            itemSpinnerBinding = ItemSpinnerBinding.inflate(LayoutInflater.from(p2?.context), p2, false)
            itemSpinnerBinding.root.tag = itemSpinnerBinding
        }else{
            itemSpinnerBinding = p1.tag as ItemSpinnerBinding
        }

        itemSpinnerBinding.name.text = getItem(p0).name
        itemSpinnerBinding.image.setImageResource(getItem(p0).image)

        return itemSpinnerBinding.root

    }
}