package main.java.mbeans.areaMBean;

import javax.ejb.Remote;
import java.math.BigDecimal;

@Remote
public interface Area {
    void addPoint(BigDecimal x, BigDecimal y);
}
