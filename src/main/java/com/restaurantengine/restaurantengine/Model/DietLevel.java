package com.restaurantengine.restaurantengine.Model;

public enum DietLevel {
    ONLY, YES, LIMITED, NO;

    public static DietLevel fromString(String value) {
        if (value == null) return null;
        return switch (value.toLowerCase()) {
            case "only" -> ONLY;
            case "yes" -> YES;
            case "limited" -> LIMITED;
            case "no" -> NO;
            default -> null; // or throw an exception if preferred
        };
    }
}
