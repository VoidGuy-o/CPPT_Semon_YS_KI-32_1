package ki302.semon.lab2;

import java.io.FileNotFoundException;

/**
 * Driver application to demonstrate Pistol class behavior.
 */
public class PistolApp {

    /**
     * Demo entry point.
     *
     * @param args command line args (unused)
     */
    public static void main(String[] args) {
        Pistol pistol = null;
        try {
            // create pistol and a filled magazine
            Pistol.Magazine mag = new Pistol.Magazine(10, 10); // capacity 10, filled
            pistol = new Pistol(mag);

            System.out.println("Initial: " + pistol.getStatus());

            // try shooting with safety on (should be blocked)
            pistol.shoot();

            // switch safety off and shoot 3 rounds
            pistol.setSafety(false);
            for (int i = 0; i < 3; i++) {
                boolean fired = pistol.shoot();
                System.out.println("Shot " + (i + 1) + " fired? " + fired);
            }

            System.out.println("After shooting: " + pistol.getStatus());

            // remove magazine and attempt dry fire
            pistol.removeMagazine();
            pistol.shoot();

            // reload with new magazine, set aim, repair barrel
            Pistol.Magazine newMag = new Pistol.Magazine(12);
            newMag.fillToCapacity();
            pistol.reload(newMag);
            pistol.setAimDistance(25);
            pistol.repairBarrel(1);

            System.out.println("Final: " + pistol.getStatus());

        } catch (FileNotFoundException e) {
            System.err.println("Failed to create log file: " + e.getMessage());
            return;
        } finally {
            if (pistol != null) {
                pistol.dispose();
            }
        }
        System.out.println("Demo finished. Check PistolLog.txt for detailed log.");
    }
}
