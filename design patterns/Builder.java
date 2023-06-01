class Pizza {
    private int size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean meat;

    public static class Builder {
        // Required
        private final int size;

        // Optional
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean meat = false;

        public Builder(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Size must be greater than 0.");
            }
            this.size = size;
        }

        public Builder withCheese() {
            this.cheese = true;
            return this;
        }

        public Builder withPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder withMeat() {
            this.meat = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        size = builder.size;
        cheese = builder.cheese;
        pepperoni = builder.pepperoni;
        meat = builder.meat;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", meat=" + meat + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder(12)
                .withCheese()
                .withPepperoni()
                .withMeat()
                .build();

        System.out.println(pizza);
    }
}
