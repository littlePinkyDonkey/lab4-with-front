package main.java.mbeans.pointsMBean;

import javax.management.NotificationEmitter;
import java.math.BigDecimal;

public interface PointsCounterBeanMBean extends NotificationEmitter {
    long getAllPointsCounter();
    long getMissedPoints();
}
