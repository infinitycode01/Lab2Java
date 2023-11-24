package com.infinity;

public abstract class Department {
    private final String name;

    protected Department(Builder<?> builder) {
        this.name = builder.name;
    }

    public abstract void describeDepartment();

    public String getName() {
        return name;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private String name;

        public T setName(String name) {
            this.name = name;
            return self();
        }

        protected abstract T self();

        public abstract Department build();
    }

    // ... інші методи ...
}
