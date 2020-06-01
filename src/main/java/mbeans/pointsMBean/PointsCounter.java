package main.java.mbeans.pointsMBean;

import javax.ejb.Remote;

@Remote
public interface PointsCounter {
    void addPointsResult(boolean result);
    void sendNotification(double x, double y, double r);
}
