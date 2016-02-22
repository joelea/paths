package paths.results;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Results {
    volatile List<Result> results = ImmutableList.of();

    public static Results createDefault() {
        return new Results();
    }

    public List<Result> getAll() {
        return results;
    }

    public void add(Result resultToBeAdded) {
        results = ImmutableList.<Result>builder()
                .addAll(results)
                .add(resultToBeAdded)
                .build();
    }
}
