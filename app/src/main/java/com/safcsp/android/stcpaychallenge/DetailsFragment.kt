package com.safcsp.android.stcpaychallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide


class DetailsFragment : Fragment() {

    val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val image = view.findViewById<ImageView>(R.id.imageView2)
        val name = view.findViewById<TextView>(R.id.textView3)
        val admin = view.findViewById<TextView>(R.id.admin_tv)
        val team = view.findViewById<TextView>(R.id.team)
        val product = view.findViewById<TextView>(R.id.product)
        val  extra_address_tv = view.findViewById<TextView>(R.id.extra_address_tv)
        val  extra_office_tv = view.findViewById<TextView>(R.id.extra_office_tv)
        val person_name_tv = view.findViewById<TextView>(R.id.person_name_tv)

        val person_birthday_tv = view.findViewById<TextView>(R.id.person_birthday_tv)
        val enddate_tv = view.findViewById<TextView>(R.id.enddate_tv)
        val person_gender_tv = view.findViewById<TextView>(R.id.person_sortname_tv)
        val website_tv = view.findViewById<TextView>(R.id.website_tv)
        val phone_tv = view.findViewById<TextView>(R.id.phone_tv)

        name.text = "${args.contact.person.firstname} ${args.contact.person.lastname}"
        admin.text = args.contact.person.bioguideid
        product.text = args.contact.party
        extra_address_tv.text = args.contact.extra.address
        extra_office_tv.text = args.contact.extra.office
        person_name_tv.text = args.contact.person.name
        person_birthday_tv.text = args.contact.person.birthday
        enddate_tv.text = args.contact.enddate
        person_gender_tv.text = args.contact.person.gender
        website_tv.text = args.contact.website
        phone_tv.text = args.contact.phone

        if (args.contact.party.equals("Democrat")){
            Glide.with(image)
                .load(R.drawable.democrat)
                .circleCrop()
                .into(image)
        }else if (args.contact.party.equals("Republican")){
            Glide.with(image)
                .load(R.drawable.republican)
                .circleCrop()
                .into(image)
        }


        return view
    }

}