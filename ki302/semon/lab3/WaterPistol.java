package ki302.semon.lab3;

import java.io.FileNotFoundException;

/**
 * Class representing a water pistol that can shoot and be refilled.
 */
public class WaterPistol extends Pistol implements Refillable {

    private final int capacityMl;
    private int currentWater;
    private int pressureLevel; // 1–10 scale

    public WaterPistol(int capacityMl, int initialWater) throws FileNotFoundException {
        super();
        this.capacityMl = Math.max(0, capacityMl);
        this.currentWater = Math.min(capacityMl, initialWater);
        this.pressureLevel = 5;
        log("Water pistol constructed with " + currentWater + "/" + capacityMl + " ml.");
    }

    @Override
    public boolean shoot() {
        if (safetyOn) {
            log("Attempt to shoot blocked: safety is ON.");
            return false;
        }
        if (currentWater <= 0) {
            log("No water left – cannot shoot.");
            return false;
        }

        int used = Math.min(50, currentWater); // 50 мл за один постріл
        currentWater -= used;
        log("Shot fired! Used " + used + " ml. Remaining: " + currentWater + " ml.");
        return true;
    }

    @Override
    public void refill() {
        currentWater = capacityMl;
        log("Refilled water tank to " + capacityMl + " ml.");
    }

    @Override
    public int getCurrentLevel() {
        return currentWater;
    }

    @Override
    public int getCapacity() {
        return capacityMl;
    }

    public void pumpPressure(int amount) {
        pressureLevel = Math.min(10, Math.max(1, pressureLevel + amount));
        log("Pressure adjusted to " + pressureLevel + "/10.");
    }

    @Override
    public String getStatus() {
        String s = String.format("WaterPistol: safety=%s, water=%d/%d ml, pressure=%d/10, aim=%dm",
                safetyOn, currentWater, capacityMl, pressureLevel, aimDistanceMeters);
        log("Status: " + s);
        return s;
    }
}
