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
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (a != null ? !a.equals(triangle.a) : triangle.a != null) return false;
        if (b != null ? !b.equals(triangle.b) : triangle.b != null) return false;
        return c != null ? c.equals(triangle.c) : triangle.c == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }
}
