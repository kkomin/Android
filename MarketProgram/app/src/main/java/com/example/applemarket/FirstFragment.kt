package com.example.applemarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val selectedProduct = arguments?.getParcelable<ItemData>("selectedProduct")
        if(selectedProduct != null) {
            val title = selectedProduct.name
            val seller = selectedProduct.seller
            val address = selectedProduct.address
            val description = selectedProduct.des
            val image = selectedProduct.image

            val detail_title = view.findViewById<TextView>(R.id.tv_title)
            val detail_seller = view.findViewById<TextView>(R.id.tv_seller)
            val detail_address = view.findViewById<TextView>(R.id.tv_address)
            val detail_des = view.findViewById<TextView>(R.id.tv_description)
            val detail_image = view.findViewById<ImageView>(R.id.detail_image)

            detail_title.text = title
            detail_seller.text = seller
            detail_address.text = address
            detail_des.text = description
            detail_image.setImageResource(image)

            // 뒤로가기 버튼 기능 구현
            view.findViewById<ImageButton>(R.id.backBtn).setOnClickListener {
                activity?.finish()
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(selectedProduct : ItemData) = FirstFragment().apply {
            arguments = Bundle().apply {
                putParcelable("selectedProduct", selectedProduct)
            }
        }
    }
}