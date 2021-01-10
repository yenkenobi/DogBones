package com.yen.dogbones.ui

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.yen.dogbones.R

@EpoxyModelClass(layout = R.layout.vh_image)
abstract class ImageModel : EpoxyModelWithHolder<Holder>() {

    @EpoxyAttribute lateinit var imageUrl: Uri

    override fun bind(holder: Holder) {
        holder.imageView.setImageURI(imageUrl)
    }

}

class Holder : EpoxyHolder() {

    lateinit var imageView: ImageView

    override fun bindView(itemView: View) {
        imageView = itemView.findViewById(R.id.ivImage)
    }

}