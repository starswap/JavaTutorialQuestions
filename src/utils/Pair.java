package utils;

public record Pair<A, B>(A first, B second) {
    public boolean equals(Object other) {
        if (other instanceof Pair<?, ?> otherPair) { // for the casting
            return otherPair.first().equals(this.first()) && otherPair.second()
                .equals(this.second());
        }
        else {
            return false;
        }
    }
}
