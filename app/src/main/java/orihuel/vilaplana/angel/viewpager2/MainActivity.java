package orihuel.vilaplana.angel.viewpager2;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;

    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.appbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        final List<Item> items = initializeItems();

        viewPager = findViewById(R.id.viewPager);
        viewPager.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                page.setRotationY(position * -30);
            }
        });
        mainAdapter = new MainAdapter(items);
        viewPager.setAdapter(mainAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (viewPager.getVisibility() != View.VISIBLE) {
                    viewPager.setVisibility(View.VISIBLE);
                }
            }
        });

        TabLayout tabLayoutHead = findViewById(R.id.tabLayoutHead);
        final int[] number = {1};
        new TabLayoutMediator(tabLayoutHead, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(items.get(position).getTitle());
                BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                badgeDrawable.setBackgroundColor(Color.rgb(220, 110, 200));
                badgeDrawable.setVisible(true);
                badgeDrawable.setNumber(number[0]++);
            }
        }).attach();

        TabLayout tabLayoutDown = findViewById(R.id.tabLayoutDown);
        new TabLayoutMediator(tabLayoutDown, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
            }
        }).attach();

        Button btSkip = findViewById(R.id.btSkip);
        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        Button btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() == viewPager.getScrollBarSize()) {
                    viewPager.setVisibility(View.GONE);
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });

        final LinearLayout bottomLayout = findViewById(R.id.bottomLayout);
        NestedScrollView nestedScrollView = findViewById(R.id.nestedScrollView);
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 10) {
                    bottomLayout.animate().translationY(v.getHeight());
                } else {
                    bottomLayout.animate().translationY(0);
                }
            }
        });
    }

    private List<Item> initializeItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.killer_queen, "Killer Queen", "Queen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis."));
        items.add(new Item(R.drawable.bohemia_rhapsody, "Bohemiam Rhapsody", "Queen", "Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa."));
        items.add(new Item(R.drawable.dont_stop_me_now, "Don't Stop Me Now", "Queen", "Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam."));
        items.add(new Item(R.drawable.i_want_to_break_free, "I Want to Break Free", "Queen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis."));
        items.add(new Item(R.drawable.radio_ga_ga, "Radio Ga Ga", "Queen", "Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa."));
        items.add(new Item(R.drawable.we_are_the_champions, "We Are the Champions", "Queen", "Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam."));
        items.add(new Item(R.drawable.invisible_man, "Invisible Man", "Queen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin felis eget dictum placerat. Curabitur porttitor iaculis arcu, lacinia maximus elit eleifend at. Donec eget nisi eget quam imperdiet lobortis."));
        items.add(new Item(R.drawable.play_the_game, "Play The Game", "Queen", "Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa. Morbi placerat massa in mi pellentesque iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam nulla ante, venenatis vitae arcu nec, varius eleifend massa."));
        items.add(new Item(R.drawable.we_will_rock_you, "We Will Rock You", "Queen", "Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam. Integer rutrum eleifend volutpat. Sed gravida auctor dolor, vel interdum mi accumsan a. In pretium interdum metus, ac varius quam lacinia at. Sed efficitur nulla at magna auctor, eget vulputate ex aliquam."));
        return items;
    }

}