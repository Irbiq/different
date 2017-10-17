package com.bsu.triangle.entity;

import lombok.*;

/**
 * Created by ASUS on 07.10.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Point {
    private double x;
    private double y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
