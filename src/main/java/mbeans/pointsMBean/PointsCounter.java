package main.java.mbeans.pointsMBean;

import javax.ejb.Remote;

@Remote
public interface PointsCounter {
    void addPointCheckingResult(boolean result);
}
