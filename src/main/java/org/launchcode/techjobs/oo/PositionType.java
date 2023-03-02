package org.launchcode.techjobs.oo;

import java.util.Objects;

public class PositionType extends JobField {

    public PositionType() {
        super();
    }

    public PositionType(String value) {
        super(value);
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        PositionType that = (PositionType) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
