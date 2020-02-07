package org.hotilsframework.core.collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: ImmutableList
 * @Description: TODO
 * @Author: hireny
 * @Date: Created in 2020-01-10 1:43
 * @Version: 1.0
 */
public class ImmutableList {
    private ImmutableList() {}

    public static <T> List<T> copy(List<? extends T> list) {
        ImmutableList.Builder<T> builder = ImmutableList.builder();
        for (T t : list) {
            builder.add(t);
        }
        return builder.build();
    }

    public static <T> List<T> copy(Iterable<? extends T> iterable) {
        ImmutableList.Builder<T> builder = ImmutableList.builder();
        for (T t : iterable) {
            builder.add(t);
        }
        return builder.build();
    }

    public static <T> List<T> of(T... ts) {
        return ImmutableList.<T>builder().add(ts).build();
    }


    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private Stream.Builder<T> builder = Stream.builder();

        public Builder<T> add(T t) {
            builder.add(t);
            return this;
        }

        public final Builder<T> add(T... ts) {
            for (T t : ts) {
                builder.add(t);
            }
            return this;
        }

        public Builder<T> addAll(Iterable<T> iterable) {
            for (T t : iterable) {
                builder.add(t);
            }
            return this;
        }

        public Builder<T> addAll(Iterator<T> iterator) {
            while (iterator.hasNext()) {
                builder.add(iterator.next());
            }
            return this;
        }

        public List<T> build() {
            return Collections.unmodifiableList(builder.build().collect(Collectors.toList()));
        }
    }
}
