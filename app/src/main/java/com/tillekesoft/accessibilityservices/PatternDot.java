package com.tillekesoft.accessibilityservices;

/* loaded from: classes.dex */
public class PatternDot {
    private final int coordinateX;
    private final int coordinateY;
    private final long f25ts;
    private final int number;

    public PatternDot(int i, int i2, int i3, long j) {
        this.coordinateX = i;
        this.coordinateY = i2;
        this.number = i3;
        this.f25ts = j;
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public int getCoordinateY() {
        return this.coordinateY;
    }

    public int getNumber() {
        return this.number;
    }

    public long getTs() {
        return this.f25ts;
    }

    public String toString() {
        return "Number " + this.number + " | " + this.coordinateX + "x" + this.coordinateY + " | timeStamp - " + this.f25ts;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PatternDot) && ((PatternDot) obj).number == this.number;
    }
}
