package com.safcsp.android.stcpaychallenge

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.io.IOException
import java.io.InputStream


class ContactListFragment : Fragment() {

    lateinit var adapter : ContactListAdapter

    var arr = arrayListOf<Object>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact_list, container, false)


        read_json()


        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_contact_list)
        adapter = ContactListAdapter(arr)
        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

        return view
    }

    private fun read_json() : dataClassJson? {
        var json2 : dataClassJson? = null


        try {
            val inputStream : InputStream = requireContext().assets.open("us_senators.json")
            val json = inputStream.bufferedReader().use { it.readText() }

            val moshi = Moshi.Builder().build()
            val personAdapter: JsonAdapter<dataClassJson> = moshi.adapter(dataClassJson::class.java)


            val person = personAdapter.fromJson(json)
            json2 = person
            if (person != null){
                Log.i("JsonResult",person.objects[0].description?:"null")
                    arr = person.objects as ArrayList<Object>

            }
        }catch (e : IOException){
            e.printStackTrace()
            return null
        }
        return json2

    }

    inner class ContactListAdapter(var contactList : List<Object>): RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder>() {

        inner class ContactListViewHolder(view: View):RecyclerView.ViewHolder(view){

            val profileImageView = view.findViewById<ImageView>(R.id.profile_photo)
            val nameOfSenator = view.findViewById<TextView>(R.id.name_of_senator)
            val party = view.findViewById<TextView>(R.id.party_tv)
            val description = view.findViewById<TextView>(R.id.description_tv)



            fun bind(contact : Object,holder : View){
                holder.setOnClickListener {
                    val action = ContactListFragmentDirections.actionContactListFragmentToDetailsFragment(contact)
                    findNavController().navigate(action)
                }
                if (contact.party.equals("Democrat")){
                    Glide.with(profileImageView)
                        .load(R.drawable.democrat)
                        .circleCrop()
                        .into(profileImageView)
                }else if (contact.party.equals("Republican")){
                    Glide.with(profileImageView)
                        .load(R.drawable.republican)
                        .circleCrop()
                        .into(profileImageView)
                }
                nameOfSenator.text = contact.person.firstname+" "+contact.person.lastname
                party.text = contact.party
                description.text = contact.description
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
            val view : View = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
            return ContactListViewHolder(view)


        }

        override fun getItemCount(): Int {
            return contactList.size
        }

        override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
            holder.bind(contactList[position],holder.itemView)

        }

    }




}