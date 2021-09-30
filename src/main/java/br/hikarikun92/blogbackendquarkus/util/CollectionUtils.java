package br.hikarikun92.blogbackendquarkus.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class CollectionUtils {
    private CollectionUtils() {
        throw new AssertionError();
    }

    public static <T, R> List<R> convertList(List<T> input, Function<T, R> mapper) {
        final List<R> converted = new ArrayList<>(input.size());
        for (T element : input) {
            converted.add(mapper.apply(element));
        }
        return converted;
    }
}
