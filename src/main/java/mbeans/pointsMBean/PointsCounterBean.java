package main.java.mbeans.pointsMBean;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@Singleton
public class PointsCounterBean extends NotificationBroadcasterSupport implements PointsCounterBeanMBean, PointsCounter {
    private final String MBEAN_NAME = "main.java.mbeans.pointsMBean:type=PointsCounter";

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
    public void addPointCheckingResult(boolean result) {

    }

    @Override
    public double getAllPointsCounter() {
        return 0;
    }
}
