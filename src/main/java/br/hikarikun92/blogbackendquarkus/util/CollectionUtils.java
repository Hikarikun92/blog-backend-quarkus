package br.hikarikun92.blogbackendquarkus.util;

import java.util.*;
import java.util.function.Function;

public final class CollectionUtils {
    private CollectionUtils() {
        throw new AssertionError();
    }

    public static <T, R> List<R> convertList(Collection<T> input, Function<T, R> mapper) {
        final List<R> converted = new ArrayList<>(input.size());
        for (T element : input) {
            converted.add(mapper.apply(element));
        }
        return converted;
    }

    public static <T, R> Set<R> convertSet(Collection<T> input, Function<T, R> mapper) {
        final Set<R> converted = new LinkedHashSet<>(input.size());
        for (T element : input) {
            converted.add(mapper.apply(element));
        }
        return converted;
    }
}
