package ki302.semon.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class {@code Pistol} models a simple pistol with barrel, magazine and trigger.
 * It implements basic behaviors: shooting, reloading, safety control, aiming and logging.
 *
 * <p>Logs are written to file {@code PistolLog.txt}. Remember to call {@link #dispose()} to close the log.</p>
 */
public class Pistol {

    /** The barrel component of the pistol. */
    private Barrel barrel;

    /** The removable magazine. */
    private Magazine magazine;

    /** The trigger mechanism. */
    private Trigger trigger;

    /** Whether the safety is on. */
    private boolean safetyOn;

    /** Current aiming distance (meters). */
    private int aimDistanceMeters;

    /** Logger for recording actions. */
    private PrintWriter fout;

    /**
     * Default constructor. Creates pistol with default components and empty magazine.
     *
     * @throws FileNotFoundException if log file cannot be created
     */
    public Pistol() throws FileNotFoundException {
        this.barrel = new Barrel(0.5); // barrel length in decimeters, example
        this.magazine = new Magazine(15); // default capacity
        this.trigger = new Trigger();
        this.safetyOn = true;
        this.aimDistanceMeters = 10;
        this.fout = new PrintWriter(new File("PistolLog.txt"));
        log("Pistol constructed with empty magazine (capacity " + magazine.getCapacity() + ")");
    }

    /**
     * Constructor with specified magazine.
     *
     * @param magazine initial magazine to insert
     * @throws FileNotFoundException if log file cannot be created
     */
    public Pistol(Magazine magazine) throws FileNotFoundException {
        this();
        this.magazine = magazine;
        log("Pistol constructed with provided magazine (capacity " + magazine.getCapacity() + ")");
    }

    /**
     * Fire one round if safety is off and magazine has ammo.
     *
     * @return true if a shot was fired, false otherwise
     */
    public boolean shoot() {
        if (safetyOn) {
            log("Attempt to shoot blocked: safety is ON.");
            return false;
        }
        if (magazine == null || magazine.getAmmoCount() == 0) {
            log("Attempt to shoot: no ammo (dry fire).");
            dryFire();
            return false;
        }
        // Fire: consume one round and increase barrel wear
        magazine.decreaseAmmo(1);
        barrel.increaseWear(1);
        trigger.pull();
        log("Shot fired. Ammo left: " + magazine.getAmmoCount() + ". Barrel wear: " + barrel.getWear());
        return true;
    }

    /**
     * Simulate a dry fire (no ammo).
     */
    public void dryFire() {
        trigger.pull();
        log("Dry fire (no ammunition).");
    }

    /**
     * Reload the pistol with a new magazine.
     *
     * @param newMag new magazine to insert
     */
    public void reload(Magazine newMag) {
        if (newMag == null) {
            log("Reload called with null magazine - ignored.");
            return;
        }
        this.magazine = newMag;
        log("Magazine inserted. Ammo: " + magazine.getAmmoCount() + "/" + magazine.getCapacity());
    }

    /**
     * Remove current magazine (returns it).
     *
     * @return removed magazine (may be null)
     */
    public Magazine removeMagazine() {
        Magazine removed = this.magazine;
        this.magazine = null;
        log("Magazine removed. Returned magazine: " + (removed == null ? "null" : removed.getAmmoCount() + " rounds"));
        return removed;
    }

    /**
     * Toggle safety on/off.
     */
    public void toggleSafety() {
        safetyOn = !safetyOn;
        log("Safety toggled. Now safetyOn=" + safetyOn);
    }

    /**
     * Set safety explicitly.
     *
     * @param on true to set safety on, false to set off
     */
    public void setSafety(boolean on) {
        safetyOn = on;
        log("Safety set to " + (safetyOn ? "ON" : "OFF"));
    }

    /**
     * Check if safety is on.
     *
     * @return true if safety is on
     */
    public boolean isSafetyOn() {
        return safetyOn;
    }

    /**
     * Get current ammo count (0 if no magazine).
     *
     * @return number of rounds available
     */
    public int getAmmoCount() {
        return magazine == null ? 0 : magazine.getAmmoCount();
    }

    /**
     * Set aim distance (meters).
     *
     * @param meters aiming distance in meters (non-negative)
     */
    public void setAimDistance(int meters) {
        if (meters < 0) meters = 0;
        aimDistanceMeters = meters;
        log("Aim distance set to " + aimDistanceMeters + " m.");
    }

    /**
     * Get current aim distance.
     *
     * @return aim distance in meters
     */
    public int getAimDistance() {
        return aimDistanceMeters;
    }

    /**
     * Repair barrel (reduce wear).
     *
     * @param amount wear units to remove (non-negative)
     */
    public void repairBarrel(int amount) {
        barrel.decreaseWear(amount);
        log("Barrel repaired by " + amount + ". Current wear: " + barrel.getWear());
    }

    /**
     * Replace barrel with a new one of given length.
     *
     * @param lengthDecimeters new barrel length in decimeters
     */
    public void replaceBarrel(double lengthDecimeters) {
        barrel = new Barrel(lengthDecimeters);
        log("Barrel replaced. New barrel length: " + lengthDecimeters + " dm.");
    }

    /**
     * Return a short textual status of the pistol.
     *
     * @return brief status string
     */
    public String getStatus() {
        String s = String.format("Pistol status: safety=%s, ammo=%d/%d, barrelWear=%d, aim=%dm",
                safetyOn, getAmmoCount(), magazine == null ? 0 : magazine.getCapacity(), barrel.getWear(), aimDistanceMeters);
        log("Status requested: " + s);
        return s;
    }

    /**
     * Releases resources (closes the log file). Call when done with the object.
     */
    public void dispose() {
        if (fout != null) {
            log("Disposing pistol and closing log.");
            fout.close();
            fout = null;
        }
    }

    /**
     * Internal logging helper.
     *
     * @param msg message to write to log (and flush)
     */
    private void log(String msg) {
        if (fout != null) {
            fout.println(msg);
            fout.flush();
        }
    }

    // -------------------------
    // Inner helper component classes
    // -------------------------

    /**
     * Barrel component: has length and wear counter.
     */
    static class Barrel {
        private final double lengthDm;
        private int wear;

        /**
         * Create barrel.
         *
         * @param lengthDecimeters barrel length in decimeters
         */
        public Barrel(double lengthDecimeters) {
            this.lengthDm = lengthDecimeters;
            this.wear = 0;
        }

        public double getLengthDm() {
            return lengthDm;
        }

        public int getWear() {
            return wear;
        }

        public void increaseWear(int amount) {
            if (amount > 0) wear += amount;
        }

        public void decreaseWear(int amount) {
            wear -= amount;
            if (wear < 0) wear = 0;
        }
    }

    /**
     * Magazine component: holds ammo count and capacity.
     */
    static class Magazine {
        private final int capacity;
        private int ammoCount;

        /**
         * Create magazine with given capacity. Initially empty.
         *
         * @param capacity maximum rounds
         */
        public Magazine(int capacity) {
            this.capacity = Math.max(0, capacity);
            this.ammoCount = 0;
        }

        /**
         * Create prefilled magazine.
         *
         * @param capacity maximum rounds
         * @param fill     initial ammo count (will be clamped to capacity)
         */
        public Magazine(int capacity, int fill) {
            this.capacity = Math.max(0, capacity);
            this.ammoCount = Math.max(0, Math.min(fill, this.capacity));
        }

        public int getCapacity() {
            return capacity;
        }

        public int getAmmoCount() {
            return ammoCount;
        }

        public void decreaseAmmo(int n) {
            ammoCount = Math.max(0, ammoCount - Math.max(0, n));
        }

        public void fillToCapacity() {
            ammoCount = capacity;
        }
    }

    /**
     * Trigger component: simple stateful trigger with pull action.
     */
    static class Trigger {
        private boolean pulled;

        public Trigger() {
            this.pulled = false;
        }

        public void pull() {
            pulled = true;
            // small internal logic could be added
        }

        public void reset() {
            pulled = false;
        }

        public boolean isPulled() {
            return pulled;
        }
    }
}