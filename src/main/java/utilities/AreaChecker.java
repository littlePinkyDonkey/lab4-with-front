package main.java.utilities;

public class AreaChecker {
    public static boolean isHit(Double x, Double y, Double r){
        double ax = r / 7.0;
        double ay = r / 6.0;
        boolean ellipse = (Math.pow(x, 2)) / (49 * Math.pow(ax, 2)) + (Math.pow(y, 2)) / (9 * Math.pow(ay, 2)) - 1.0 <= 0;
        boolean ellipseBottomX = (Math.abs(x / ax)) >= 4;
        boolean ellipseBottomY = (y / ay >= -3 * Math.sqrt(33) / 7.0) && (y / ay <= 0);
        boolean ellipseTopX = (Math.abs(x / ax)) >= 3;
        boolean ellipseTopY = y >= 0;
        if (ellipse && ellipseBottomX && ellipseBottomY) {
            return true;
        }
        if (ellipse && ellipseTopX && ellipseTopY) {
            return true;
        }
        boolean tail = (((3 * Math.sqrt(33) - 7) * Math.pow(x, 2)) / (-112.0 * Math.pow(ax, 2))
                + Math.abs(x / ax) / 2
                + Math.sqrt(1 - Math.pow(Math.abs((Math.abs(x / ax)) - 2) - 1, 2)) - y / ay - 3) <= 0;
        boolean tailX = (x / ax <= 4) && (x / ax >= -4);
        boolean tailY = (y / ay >= -3) && (y / ay <= 0);
        if (tail && tailX && tailY) {
            return true;
        }
        boolean ear1 = -8 * Math.abs(x / ax) - y / ay + 9 >= 0;
        boolean earsY = y >= 0;
        boolean ear1X = Math.abs(x / ax) <= 1 && Math.abs(x / ax) >= 0.75;
        if (ear1 && earsY && ear1X) {
            return true;
        }
        boolean ear2 = 3 * Math.abs(x / ax) - y / ay + 0.75 >= 0;
        boolean ears2X = Math.abs(x / ax) <= 0.75 && Math.abs(x / ax) >= 0.5;
        if (ear2 && earsY && ears2X) {
            return true;
        }
        boolean head = 9.0 / 4.0 - y / ay >= 0;
        boolean headX = Math.abs(x / ax) <= 0.5;
        boolean headY = y >= 0;
        if (head && headX && headY) {
            return true;
        }
        boolean wings = -Math.abs(x / ax) / 2 - (3.0 / 7.0) * Math.sqrt(10) * Math.sqrt(4 - Math.pow(Math.abs(x / ax) - 1, 2)) - y / ay + (6 * Math.sqrt(10)) / 7.0 + 1.5 >= 0;
        boolean wingsX = Math.abs(x / ax) <= 3 && Math.abs(x / ax) >= 1;
        boolean wingsY = y >= 0;
        if (wings && wingsX && wingsY) {
            return true;
        }
        return false;
    }
}
