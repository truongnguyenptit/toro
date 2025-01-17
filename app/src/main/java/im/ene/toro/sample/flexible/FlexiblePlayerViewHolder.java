/*
 * Copyright (c) 2017 Nam Nguyen, nam@ene.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.ene.toro.sample.flexible;

import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import im.ene.toro.ToroPlayer;
import im.ene.toro.ToroUtil;
import im.ene.toro.exoplayer.ExoPlayerViewHelper;
import im.ene.toro.media.PlaybackInfo;
import im.ene.toro.sample.R;
import im.ene.toro.widget.Container;

/**
 * @author eneim (7/1/17).
 */

@SuppressWarnings("WeakerAccess") //
public class FlexiblePlayerViewHolder extends RecyclerView.ViewHolder implements ToroPlayer {

  private static final String TAG = "Toro:Flex:Holder";

  static final int LAYOUT_RES = R.layout.view_holder_exoplayer_flexible;

  ExoPlayerViewHelper helper;
  Uri mediaUri;
  View.OnClickListener clickListener;

  @BindView(R.id.player) PlayerView playerView;

  public FlexiblePlayerViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void setClickListener(View.OnClickListener clickListener) {
    this.clickListener = clickListener;
    itemView.setOnClickListener(clickListener);
    playerView.setOnClickListener(clickListener);
  }

  @NonNull @Override public View getPlayerView() {
    return playerView;
  }

  @NonNull @Override public PlaybackInfo getCurrentPlaybackInfo() {
    return helper != null ? helper.getLatestPlaybackInfo() : new PlaybackInfo();
  }

  @Override
  public void initialize(@NonNull Container container, @NonNull PlaybackInfo playbackInfo) {
    if (helper == null) {
      helper = new ExoPlayerViewHelper(this, mediaUri);
    }
    helper.initialize(container, playbackInfo);
  }

  @Override public void play() {
    if (helper != null) helper.play();
  }

  @Override public void pause() {
    if (helper != null) helper.pause();
  }

  @Override public boolean isPlaying() {
    return helper != null && helper.isPlaying();
  }

  @Override public void release() {
    if (helper != null) {
      helper.release();
      helper = null;
    }
  }

  @Override public boolean wantsToPlay() {
    return ToroUtil.visibleAreaOffset(this, itemView.getParent()) >= 0.85;
  }

  @Override public int getPlayerOrder() {
    return getAdapterPosition();
  }

  @Override public String toString() {
    return "ExoPlayer{" + hashCode() + " " + getAdapterPosition() + "}";
  }

  void bind(Content.Media media, int position) {
    if (position % 3 == 0) {
      playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH);
    } else {
      playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
    }

    this.mediaUri = media.mediaUri;
  }
}
