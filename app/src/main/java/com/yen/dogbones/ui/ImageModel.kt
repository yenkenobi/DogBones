package com.yen.dogbones.ui

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.squareup.picasso.Picasso
import com.yen.dogbones.R

@EpoxyModelClass(layout = R.layout.vh_image)
abstract class ImageModel : EpoxyModelWithHolder<ImageHolder>() {

    @EpoxyAttribute lateinit var imageUrl: Uri

    override fun bind(holder: ImageHolder) {
        super.bind(holder)
        Picasso.get().load(imageUrl).into(holder.imageView)
    }

}

class ImageHolder : EpoxyHolder() {

    lateinit var imageView: ImageView

    override fun bindView(itemView: View) {
        imageView = itemView.findViewById(R.id.ivImage)
    }

}