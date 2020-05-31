package main.java.mbeans.pointsMBean;

import javax.management.NotificationEmitter;

public interface PointsCounterBeanMBean extends NotificationEmitter {
    double getAllPointsCounter();
}
