package example.learning.kotlin.gabriel.ztd3

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.ArrayList




class MyAdapterCardView(private val mContext: Context, private val mNotificationListModelArrayList: ArrayList<String>?) : RecyclerView.Adapter<MyAdapterCardView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(
                R.layout.cardviewnotification, parent, false)

// create ViewHolder
        val viewHolder = ViewHolder(itemLayoutView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        holder.tvTitle.text = mNotificationListModelArrayList?.get(position)

    }

    override fun getItemCount(): Int {
        return mNotificationListModelArrayList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView
        var tvDes: TextView
        var tvDate: TextView
        var tvTime: TextView

        init {
            tvTitle = itemView.findViewById<TextView>(R.id.tvTitle) as TextView
            tvDes = itemView.findViewById<TextView>(R.id.tvDes) as TextView
            tvDate = itemView.findViewById<TextView>(R.id.tvDate) as TextView
            tvTime = itemView.findViewById<TextView>(R.id.tvTime) as TextView
        }
    }
}
