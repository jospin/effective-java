package br.com.effective.java.cap2.item2.hierarchical;

import java.util.Objects;

/**
 * @author Lucien Carbonare Jospin
 * @since 08/2021
 * @param Color color
 */
public class Ford extends Car{

    public enum Color { YELLOW, RED, BLACK, GRAY }
    private final Color color;

    private Ford(Builder builder) {
        super(builder);
        color = builder.color;
    }

    public Color getColor() {
        return color;
    }

    @Override public String toString() {
        return "Ford Car with " + types + super.toString();
    }

    public static class Builder extends Car.Builder<Builder> {
        private final Color color;

        public Builder(Color size) {
            this.color = Objects.requireNonNull(size);
        }

        @Override public Ford build() {
            return new Ford(this);
        }

        @Override protected Builder self() { return this; }
    }


}
