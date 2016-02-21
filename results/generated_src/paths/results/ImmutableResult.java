package paths.results;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.Collection;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Result}.
 * <p>
 * Use builder to create immutable instances:
 * {@code ImmutableResult.builder()}.
 */
@SuppressWarnings("all")
@Generated({"Immutables.generator", "Result"})
public final class ImmutableResult implements Result {
  private final String pupil;
  private final long score;

  private ImmutableResult(String pupil, long score) {
    this.pupil = pupil;
    this.score = score;
  }

  /**
   * @return value of {@code pupil} attribute
   */
  @Override
  public String pupil() {
    return pupil;
  }

  /**
   * @return value of {@code score} attribute
   */
  @Override
  public long score() {
    return score;
  }

  /**
   * Copy current immutable object by setting value for {@link Result#pupil() pupil}.
   * Shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value new value for pupil
   * @return modified copy of the {@code this} object
   */
  public final ImmutableResult withPupil(String value) {
    if (this.pupil == value) {
      return this;
    }
    String newValue = Preconditions.checkNotNull(value);
    return new ImmutableResult(newValue, this.score);
  }

  /**
   * Copy current immutable object by setting value for {@link Result#score() score}.
   * Value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value new value for score
   * @return modified copy of the {@code this} object
   */
  public final ImmutableResult withScore(long value) {
    if (this.score == value) {
      return this;
    }
    long newValue = value;
    return new ImmutableResult(this.pupil, newValue);
  }

  /**
   * This instance is equal to instances of {@code ImmutableResult} with equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    return this == another
        || (another instanceof ImmutableResult && equalTo((ImmutableResult) another));
  }

  private boolean equalTo(ImmutableResult another) {
    return pupil.equals(another.pupil)
        && score == another.score;
  }

  /**
   * Computes hash code from attributes: {@code pupil}, {@code score}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + pupil.hashCode();
    h = h * 17 + Longs.hashCode(score);
    return h;
  }

  /**
   * Prints immutable value {@code Result{...}} with attribute values,
   * excluding any non-generated and auxiliary attributes.
   * @return string representation of value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Result")
        .add("pupil", pupil)
        .add("score", score)
        .toString();
  }

  /**
   * Simple representation of this value type suitable Jackson binding
   * @deprecated Do not use this type directly, it exists only for <em>Jackson</em>-binding infrastructure
   */
  static final class Json {
    @JsonProperty(value = "pupil")
    String pupil;
    @JsonProperty(value = "score")
    Long score;
  }

  /**
   * @return JSON-bindable data structure
   * @deprecated Do not use this method directly, it exists only for <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonValue
  Json toJson() {
    Json json = new Json();
    json.pupil = this.pupil;
    json.score = this.score;
    return json;
  }

  /**
   * @param json JSON-bindable data structure
   * @return immutable value type
   * @deprecated Do not use this method directly, it exists only for <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableResult fromJson(Json json) {
    ImmutableResult.Builder builder = ImmutableResult.builder();
    if (json.pupil != null) {
      builder.pupil(json.pupil);
    }
    if (json.score != null) {
      builder.score(json.score);
    }
    return builder.build();
  }

  /**
   * Creates immutable copy of {@link Result}.
   * Uses accessors to get values to initialize immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance instance to copy
   * @return copied immutable Result instance
   */
  public static ImmutableResult copyOf(Result instance) {
    if (instance instanceof ImmutableResult) {
      return (ImmutableResult) instance;
    }
    return ImmutableResult.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates builder for {@link paths.results.ImmutableResult ImmutableResult}.
   * @return new ImmutableResult builder
   */
  public static ImmutableResult.Builder builder() {
    return new ImmutableResult.Builder();
  }

  /**
   * Builds instances of {@link paths.results.ImmutableResult ImmutableResult}.
   * Initialize attributes and then invoke {@link #build()} method to create
   * immutable instance.
   * <p><em>{@code Builder} is not thread safe and generally should not be stored in field or collection,
   * but used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INITIALIZED_BITSET_ALL = 0x3;
    private static final long INITIALIZED_BIT_PUPIL = 0x1L;
    private static final long INITIALIZED_BIT_SCORE = 0x2L;
    private long initializedBitset;
    private String pupil;
    private long score;

    private Builder() {}

    /**
     * Fill builder with attribute values from provided {@link Result} instance.
     * Regular attribute values will be overridden, i.e. replaced with ones of an instance.
     * Instance's absent optional values will not be copied (will not override current).
     * Collection elements and entries will be added, not replaced.
     * @param instance instance to copy values from
     * @return {@code this} builder for chained invocation
     */
    public final Builder from(Result instance) {
      Preconditions.checkNotNull(instance);
      pupil(instance.pupil());
      score(instance.score());
      return this;
    }

    /**
     * Initializes value for {@link Result#pupil() pupil}.
     * @param pupil value for pupil
     * @return {@code this} builder for chained invocation
     */
    public final Builder pupil(String pupil) {
      this.pupil = Preconditions.checkNotNull(pupil);
      initializedBitset |= INITIALIZED_BIT_PUPIL;
      return this;
    }

    /**
     * Initializes value for {@link Result#score() score}.
     * @param score value for score
     * @return {@code this} builder for chained invocation
     */
    public final Builder score(long score) {
      this.score = score;
      initializedBitset |= INITIALIZED_BIT_SCORE;
      return this;
    }

    /**
     * Builds new {@link paths.results.ImmutableResult ImmutableResult}.
     * @return immutable instance of Result
     */
    public ImmutableResult build() {
      checkRequiredAttributes();
      return new ImmutableResult(pupil, score);
    }

    private boolean pupilIsSet() {
      return (initializedBitset & INITIALIZED_BIT_PUPIL) != 0;
    }

    private boolean scoreIsSet() {
      return (initializedBitset & INITIALIZED_BIT_SCORE) != 0;
    }

    private void checkRequiredAttributes() {
      if (initializedBitset != INITIALIZED_BITSET_ALL) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      Collection<String> attributes = Lists.newArrayList();
      if (!pupilIsSet()) {
        attributes.add("pupil");
      }
      if (!scoreIsSet()) {
        attributes.add("score");
      }
      return "Cannot build Result, some of required attributes are not set " + attributes;
    }
  }
}
