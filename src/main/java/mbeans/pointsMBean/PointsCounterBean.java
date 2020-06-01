package main.java.mbeans.pointsMBean;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class PointsCounterBean extends NotificationBroadcasterSupport implements PointsCounterBeanMBean, PointsCounter {
    private final String MBEAN_NAME = "main.java.mbeans.pointsMBean:type=PointsCounter";

    private static final String OUT_OF_BOUNDS_NOTIFICATION_TYPE = "main.java.mbeans.pointsMBean.OutOfBounds";
    private static final String OUT_OF_BOUNDS_NOTIFICATION = "Query (%s, %s, %s) is out of bounds";

    private final AtomicLong allPointsCounter = new AtomicLong();
    private final AtomicLong missedPointsCounter = new AtomicLong();
    private final AtomicLong outOfAreaPointsCounter = new AtomicLong();

    @PostConstruct
    public void init() {
        try {
            ObjectName bean = new ObjectName(MBEAN_NAME);
            ManagementFactory.getPlatformMBeanServer().registerMBean(this, bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPointsResult(boolean result) {
        allPointsCounter.incrementAndGet();

        if (!result) missedPointsCounter.incrementAndGet();
    }

    @Override
    public long getAllPointsCounter() {
        return allPointsCounter.get();
    }

    @Override
    public long getMissedPoints() {
        return missedPointsCounter.get();
    }

    @Override
    public void sendNotification(double x, double y, double r) {
        sendNotification(new Notification(OUT_OF_BOUNDS_NOTIFICATION_TYPE, this,
                outOfAreaPointsCounter.getAndIncrement(), System.currentTimeMillis(),
                String.format(OUT_OF_BOUNDS_NOTIFICATION, x, y, r)));
    }
}
