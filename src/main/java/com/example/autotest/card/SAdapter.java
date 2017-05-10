package com.example.autotest.card;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.widget.pagerecycleview.ada.Card;
import com.mdx.framework.widget.pagerecycleview.ada.CardIDS;
import com.mdx.framework.widget.pagerecycleview.ada.HAdapter;
import com.mdx.framework.widget.pagerecycleview.ada.MAdapter;
import com.mdx.framework.widget.pagerecycleview.animator.AnimatorUtil;
import com.mdx.framework.widget.pagerecycleview.animator.ViewAnimator;
import com.mdx.framework.widget.pagerecycleview.viewhold.MViewHold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.view.View.TRANSLATION_X;

/**
 * Created by ryan on 2017/4/26.
 */

public class SAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public HAdapter hAdapter;

    private LayoutInflater layoutInflater;

    public ArrayList<Card> overCard = new ArrayList<>();
    private ArrayList<Card> list = new ArrayList<Card>();
    private OnNotifyChangedListener onNotifyChangedListener;

    @Nullable
    private ViewAnimator mViewAnimator;


    public interface OnNotifyChangedListener {
        void onNotifyChanged(MAdapter adapter);
    }

    private RecyclerView recyclerView;

    public HashMap<Object, Object> params = new HashMap<Object, Object>();

    public SAdapter(Context context, Card[] list) {
        this.context = context;
        layoutInflater = LayoutInflater.from(this.context);
        for (Card item : list) {
            item.isanimation = false;
//            item.setAdapter(this);
            item.overViewHold = null;
            this.list.add(item);
        }
//        resetOverCard();
    }

    public SAdapter(Context context, List<Card> list) {
        this.context = context;
        layoutInflater = LayoutInflater.from(this.context);
        this.list.addAll(list);
        for (Card item : list) {
            item.isanimation = false;
//            item.setAdapter(this);
            item.overViewHold = null;
        }
//        resetOverCard();
    }

    public SAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getItemViewType(int position) {
        return ((Card) get(position)).getCardType();
    }

    public GridLayoutManager.SpanSizeLookup SpanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {
            return SAdapter.this.getSpanSize(position);
        }
    };

    public int getSpanSize(int position) {
        return getList().get(position).getSpan();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("test","onCreateViewHolder");
        if (viewType == -88) {
            return new MViewHold(new View(parent.getContext()));
        }
        return CardIDS.CreateViewHolde(viewType, parent.getContext(), parent);
    }

    private static final String ALPHA = "alpha";
    private void animateView(final View view, final int position,final Card card) {
        assert mViewAnimator != null;
        assert recyclerView != null;

        Animator[] animators = getAnimators(view);
        Animator alphaAnimator = ObjectAnimator.ofFloat(view, ALPHA, 0, 1);
        Animator[] concatAnimators = AnimatorUtil.concatAnimators(animators, alphaAnimator);
//        mViewAnimator.animateViewIfNecessary(position, view,card, concatAnimators);
    }


    public Animator[] getAnimators(@NonNull View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, TRANSLATION_X, 0 - recyclerView.getLayoutManager().getWidth(), 0),
                              ObjectAnimator.ofFloat(view, TRANSLATION_X, 0 - recyclerView.getLayoutManager().getWidth(), 0)};
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Card card = (Card) get(position);
        Log.d("test","onBindViewHolder"+card.item);
        card.dispbind(holder, position);
        if (card.getShowType() == 1) {
            return;
        }
        if(!card.useanimation){
            return;
        }
        if(mViewAnimator!=null) {
            mViewAnimator.cancelExistingAnimation(holder.itemView);
            animateView(holder.itemView, position,card);
        }

//        if (holder instanceof MViewHold) {
//            MViewHold mvh=((MViewHold) holder);
//            if(!card.isanimation){
//                mvh.animateShow();
//                if (!card.reanimation) {
//                    card.isanimation = true;
//                }
//            }else{
//                mvh.animateEnd();
//            }
//        }else{
//            if(!card.isanimation){
//                ViewCompat.setRotationX(holder.itemView, -10);
//                ViewCompat.setTranslationY(holder.itemView, 50);
//                ViewCompat.setScaleX(holder.itemView, 0.88f);
//                ViewCompat.setScaleY(holder.itemView, 0.88f);
//                ViewCompat.setAlpha(holder.itemView, 0.2f);
//                ViewCompat.animate(holder.itemView)
//                        .rotationX(0)
//                        .scaleX(1)
//                        .scaleY(1)
//                        .alpha(1)
//                        .translationY(0)
//                        .setDuration(200)
//                        .start();
//                if (!card.reanimation) {
//                    card.isanimation = true;
//                }
//            }else{
//                ViewCompat.setRotationX(holder.itemView, 0);
//                ViewCompat.setTranslationY(holder.itemView, 0);
//                ViewCompat.setScaleX(holder.itemView, 1);
//                ViewCompat.setScaleY(holder.itemView, 1);
//                ViewCompat.setAlpha(holder.itemView, 1);
//            }
//        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    public void AddAll(List<Card> list) {
        for (Card item : list) {
            item.isanimation = false;
//            item.setAdapter(this);
            item.overViewHold = null;
        }
        this.list.addAll(list);
        resetOverCard();
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
//            hAdapter.notifyItemRangeInserted(hAdapter.getiPosion(getItemCount() - 1), list.getItemCount());
        } else {
            mnotifyDataSetChanged();
//            this.notifyItemRangeInserted(getItemCount() - 1, list.getItemCount());
        }
    }

    public void AddAll(MAdapter list) {
        for (int i = 0; i < list.getItemCount(); i++) {
            Card item = (Card) list.get(i);
            item.isanimation = false;
//            item.setAdapter(this);
            item.overViewHold = null;
            this.list.add(item);
        }
        resetOverCard();
        if (list.params != null) {
            this.params.putAll(list.params);
        }
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
//            hAdapter.notifyItemRangeInserted(hAdapter.getiPosion(getItemCount() - 1), list.getItemCount());
        } else {
            mnotifyDataSetChanged();
//            this.notifyItemRangeInserted(getItemCount() - 1, list.getItemCount());
        }
    }

    public void AddAllOnBegin(MAdapter list) {
        for (int i = list.getItemCount() - 1; i >= 0; i--) {
            Card item = (Card) list.get(i);
            item.isanimation = false;
//            item.setAdapter(this);
            item.overViewHold = null;
            this.list.add(0, item);
        }
        if (list.params != null) {
            this.params.putAll(list.params);
        }
        resetOverCard();
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
//            hAdapter.notifyItemRangeInserted(hAdapter.getiPosion(0), list.getItemCount());
        } else {
            mnotifyDataSetChanged();
//            this.notifyItemRangeInserted(0, list.getItemCount());
        }
    }

    public void add(Object item) {
        if (item instanceof Card) {
            ((Card) item).isanimation = false;
//            ((Card) item).setAdapter(this);
            ((Card) item).overViewHold = null;
            this.getList().add((Card) item);
        }
        resetOverCard();
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
//            hAdapter.notifyItemInserted(hAdapter.getiPosion(this.getItemCount() - 1));
        } else {
            mnotifyDataSetChanged();
            ;
//            this.notifyItemInserted(this.getItemCount() - 1);
        }
    }

    public void add(int ind, Object item) {
        if (item instanceof Card) {
            ((Card) item).isanimation = false;
//            ((Card) item).setAdapter(this);
            ((Card) item).overViewHold = null;
            this.getList().add(ind, (Card) item);
        }
        resetOverCard();
        if (hAdapter != null) {
//            if (ind == 0) {
            hAdapter.mnotifyDataSetChanged();
//            } else {
//                hAdapter.notifyItemInserted(hAdapter.getiPosion(ind));
//            }
        } else {
//            if (ind == 0) {
            mnotifyDataSetChanged();
//            } else {
//                this.notifyItemInserted(ind);
//            }
        }
    }

    public void mnotifyDataSetChanged() {
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
        } else {
            notifyDataSetChanged();
        }
        if (onNotifyChangedListener != null) {
//            onNotifyChangedListener.onNotifyChanged(this);
        }
    }

    public void remove(Object item) {
        for (int i = 0; i < getList().size(); i++) {
            if (this.getList().get(i) == item) {
                remove(i);
                break;
            }
        }
        resetOverCard();
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
//            hAdapter.notifyItemRemoved(hAdapter.getiPosion(posion));
        } else {
//            this.notifyItemRemoved(posion);
            mnotifyDataSetChanged();
        }
    }

    public void remove(int posion) {
        this.getList().remove(posion);
        resetOverCard();
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
//            hAdapter.notifyItemRemoved(hAdapter.getiPosion(posion));
        } else {
//            this.notifyItemRemoved(posion);
            mnotifyDataSetChanged();
        }
    }

    public void clear() {
        int size = this.getList().size();
        this.overCard.clear();
        this.getList().clear();
        if (hAdapter != null) {
            hAdapter.mnotifyDataSetChanged();
//            hAdapter.notifyItemRangeRemoved(hAdapter.getiPosion(0), size);
        } else {
            mnotifyDataSetChanged();
            this.notifyItemRangeRemoved(0, size);
        }
    }

    public void resetOverCard() {
        this.overCard.clear();
        for (int i = 0; i < list.size(); i++) {
            Card item = (Card) list.get(i);
            if (item.getShowType() != 0) {
                overCard.add(item);
            }
        }
    }

    public void setOnNotifyChangedListener(OnNotifyChangedListener onNotifyChangedListener) {
        this.onNotifyChangedListener = onNotifyChangedListener;
    }

    public long getItemId(int position) {
        return 99900000 + position;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public List<Card> getList() {
        return list;
    }

    public Object get(int ind) {
        return list.get(ind);
    }

    public int getPosion(Card card) {
        return getList().indexOf(card);
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        mViewAnimator = new ViewAnimator(recyclerView);
    }
}
