package kr.co.ajsoft.ex55recyclerview2;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAnimator extends DefaultItemAnimator {

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {

        //TranslateAnimation ani=new TranslateAnimation();
        Animation ani= AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.appear_item);
        holder.itemView.startAnimation(ani);

        return super.animateAdd(holder);
    }
}
