/*
 * Copyright (c) 2019 Nam Nguyen, nam@ene.im
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

package im.ene.toro.epoxy;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.VisibilityState;
import java.util.List;

public abstract class ToroEpoxyModelWithHolder<T extends EpoxyHolder> extends EpoxyModel<T> {

  public ToroEpoxyModelWithHolder() {
  }

  public ToroEpoxyModelWithHolder(long id) {
    super(id);
  }

  /** This should return a new instance of your {@link com.airbnb.epoxy.EpoxyHolder} class. */
  protected abstract T createNewHolder();

  private T holder;

  public T getHolder(){
    return holder;
  }

  @Override
  public void bind(@NonNull T holder) {
    super.bind(holder);
    this.holder = holder;
  }

  @Override
  public void bind(@NonNull T holder, @NonNull List<Object> payloads) {
    super.bind(holder, payloads);
  }

  @Override
  public void bind(@NonNull T holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
    super.bind(holder, previouslyBoundModel);
  }

  @Override
  public void unbind(@NonNull T holder) {
    super.unbind(holder);
  }


  @Override
  public void onVisibilityStateChanged(@VisibilityState.Visibility int visibilityState, @NonNull T view) {
    super.onVisibilityStateChanged(visibilityState, view);
  }

  @Override
  public void onVisibilityChanged(
      @FloatRange(from = 0, to = 100) float percentVisibleHeight,
      @FloatRange(from = 0, to = 100) float percentVisibleWidth,
      @Px int visibleHeight, @Px int visibleWidth,
      @NonNull T view) {
    super.onVisibilityChanged(
        percentVisibleHeight, percentVisibleWidth,
        visibleHeight, visibleWidth,
        view);
  }

  @Override
  public boolean onFailedToRecycleView(T holder) {
    return super.onFailedToRecycleView(holder);
  }

  @Override
  public void onViewAttachedToWindow(T holder) {
    super.onViewAttachedToWindow(holder);
  }

  @Override
  public void onViewDetachedFromWindow(T holder) {
    super.onViewDetachedFromWindow(holder);
  }
}