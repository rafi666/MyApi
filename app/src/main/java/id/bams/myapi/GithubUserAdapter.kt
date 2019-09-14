package id.bams.myapi

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.user_item.view.*

class GithubUserAdapter(
    private val context: Context,
    private val items: List<DataUser>,
    private val listener: (DataUser) -> Unit
) :

    RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.user_item, parent, false))

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)

    }

    class ViewHolder(val context: Context, override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item: DataUser, listener: (DataUser) -> Unit) {
            containerView.txtUsername.text = item.login
            containerView.txtUserRepo.text = item.reposUrl

            Glide.with(context).load(item.avatarUrl).into(containerView.imgUser)

            containerView.setOnClickListener{listener(item)}


        }

    }
}