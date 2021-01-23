package orihuel.vilaplana.angel.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Item> items;

    public MainAdapter(List<Item> items) {
        this.items = items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSubtitle;
        ImageView ivMain;
        TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivMain = itemView.findViewById(R.id.ivMain);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
            this.tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        public void bind(Item item) {
            ivMain.setImageResource(item.getIdImage());
            tvTitle.setText(item.getTitle());
            tvSubtitle.setText(item.getSubtitle());
            tvDescription.setText(item.getDescription());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
