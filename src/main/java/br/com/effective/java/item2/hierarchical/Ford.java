package br.com.effective.java.item2.hierarchical;

import java.util.Objects;

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

        public Builder(Color size, String name) {
            this.color = Objects.requireNonNull(size);
            this.name = name;
        }

        @Override public Ford build() {
            return new Ford(this);
        }

        @Override protected Builder self() { return this; }
    }


}
