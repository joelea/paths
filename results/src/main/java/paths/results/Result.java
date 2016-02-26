package paths.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableResult.class)
@JsonDeserialize(as = ImmutableResult.class)
public interface Result {
    @JsonProperty("pupil") String pupil();
    @JsonProperty("score") long score();
}
