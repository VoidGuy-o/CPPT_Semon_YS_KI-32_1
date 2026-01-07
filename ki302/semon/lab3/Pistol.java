package ki302.semon.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Abstract class representing a generic pistol with safety and aiming features.
 * Subclasses must implement specific shooting logic.
 */
public abstract class Pistol {

    protected boolean safetyOn;
    protected int aimDistanceMeters;
    protected PrintWriter fout;

    public Pistol() throws FileNotFoundException {
        this.safetyOn = true;
        this.aimDistanceMeters = 10;
        this.fout = new PrintWriter(new File("PistolLog.txt"));
        log("Abstract pistol created.");
    }

    /** Fire the weapon (implemented by subclasses). */
    public abstract boolean shoot();

    public void setSafety(boolean on) {
        safetyOn = on;
        log("Safety set to " + (safetyOn ? "ON" : "OFF"));
    }

    public boolean isSafetyOn() {
        return safetyOn;
    }

    public void setAimDistance(int meters) {
        if (meters < 0) meters = 0;
        aimDistanceMeters = meters;
        log("Aim distance set to " + aimDistanceMeters + " m.");
    }

    public int getAimDistance() {
        return aimDistanceMeters;
    }

    protected void log(String msg) {
        if (fout != null) {
            fout.println(msg);
            fout.flush();
        }
    }

    public void dispose() {
        if (fout != null) {
            log("Closing log.");
            fout.close();
            fout = null;
        }
    }

    /** Return brief status info. */
    public abstract String getStatus();
}