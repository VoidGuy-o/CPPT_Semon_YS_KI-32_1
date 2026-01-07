package ki302.semon.lab3;

/**
 * Driver class to demonstrate WaterPistol functionality.
 */
public class WaterPistolApp {
    public static void main(String[] args) {
        try {
            WaterPistol wp = new WaterPistol(500, 300);
            System.out.println("Initial: " + wp.getStatus());

            wp.setSafety(false);
            wp.setAimDistance(8);
            wp.pumpPressure(2);

            for (int i = 0; i < 5; i++) {
                wp.shoot();
            }

            System.out.println("After shooting: " + wp.getStatus());

            wp.refill();
            System.out.println("After refill: " + wp.getStatus());

            wp.dispose();
            System.out.println("Demo finished. Check PistolLog.txt for log.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}