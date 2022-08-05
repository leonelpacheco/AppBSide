package com.leonel.appbside.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.leonel.appbside.databinding.FragmentHomeBinding
import com.leonel.appbside.model.Contacto
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

       binding.btnGuardar.setOnClickListener(View.OnClickListener {
           if(  binding.txtNombre.text.isNullOrEmpty()
               || binding.txtApellidos.text.isNullOrEmpty()
               || binding.txtTelefono.text.isNullOrEmpty()
               ||binding.txtEmail.text.isNullOrEmpty()
               ||binding.txtDireccion.text.isNullOrEmpty()
           )
               Toast.makeText(activity, "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show()
           else {
               val contactosave = Contacto(-1,binding.txtNombre.text.toString(),binding.txtApellidos.text.toString(),binding.txtTelefono.text.toString(),
                   binding.txtEmail.text.toString(),binding.txtDireccion.text.toString())
               homeViewModel.insertarContacto(contactosave)

               binding.txtNombre.setText("")
               binding.txtApellidos.setText("")
               binding.txtTelefono.setText("")
               binding.txtEmail.setText("")
               binding.txtDireccion.setText("")

           }
       })


        homeViewModel.listcontactoModel.observe(viewLifecycleOwner){
            Toast.makeText(activity, "Usuario insertado con exito", Toast.LENGTH_SHORT).show()
        }


        //******************EDIT******************
        var contactoeditrecived =arguments
        if(contactoeditrecived!=null) {
            val contactoedit= contactoeditrecived.get("Idcontacto").toString() ?:"-1"
            homeViewModel.consultarContacto(contactoedit)
        }
        homeViewModel.listcontactoeditModel.observe(viewLifecycleOwner){
            binding.txtNombre.setText(homeViewModel.listcontactoeditModel.value?.get(0)?.nombre ?: "")
            binding.txtApellidos.setText(homeViewModel.listcontactoeditModel.value?.get(0)?.apellidos ?: "")
            binding.txtTelefono.setText(homeViewModel.listcontactoeditModel.value?.get(0)?.telefono ?: "")
            binding.txtEmail.setText(homeViewModel.listcontactoeditModel.value?.get(0)?.email ?: "")
            binding.txtDireccion.setText(homeViewModel.listcontactoeditModel.value?.get(0)?.direccion ?: "")
        }
        //****************************************

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}