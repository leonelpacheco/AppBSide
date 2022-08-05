package com.leonel.appbside.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.leonel.appbside.R
import com.leonel.appbside.model.Contacto
import com.leonel.appbside.ui.home.HomeFragment
import com.leonel.appbside.utils.ChangeFragment

class contactoAdapter (private val mList: List<Contacto>, context: FragmentActivity): RecyclerView.Adapter<contactoAdapter.ViewHolder>() {
    val context= context
    val manager: FragmentManager = (context as AppCompatActivity).supportFragmentManager
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_contacto, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        // sets the text to the textview from our itemHolder class

        holder.txt_name.text = ItemsViewModel.nombre
        holder.txt_apellidosrow.text = ItemsViewModel.apellidos
        holder.txt_phone.text = ItemsViewModel.telefono
        holder.txt_email.text = ItemsViewModel.email
        holder.txt_address.text = ItemsViewModel.direccion

        holder.card_rowcontacto.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putString("Idcontacto", ItemsViewModel.id.toString())
            val fragmentapp: Fragment =
                HomeFragment()
            ChangeFragment.changewhitData(HomeFragment(), manager  , bundle)

        })


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txt_apellidosrow: TextView = itemView.findViewById(R.id.txt_apellidosrow)
        val txt_name: TextView = itemView.findViewById(R.id.txt_nombre)
        val txt_phone: TextView = itemView.findViewById(R.id.txt_telefono)
        val txt_email: TextView = itemView.findViewById(R.id.txt_email)
        val txt_address: TextView = itemView.findViewById(R.id.txt_direccion)
        val card_rowcontacto: CardView =itemView.findViewById(R.id.card_rowcontacto)
    }
}