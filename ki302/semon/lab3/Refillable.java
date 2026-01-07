package ki302.semon.lab3;

/**
 * Interface representing refillable objects (e.g., tanks, reservoirs).
 */
public interface Refillable {
    /**
     * Refill the tank or reservoir to full capacity.
     */
    void refill();

    /**
     * Check current fill level (in milliliters).
     * @return current volume of liquid
     */
    int getCurrentLevel();

    /**
     * Check total capacity (in milliliters).
     * @return max volume
     */
    int getCapacity();
}
