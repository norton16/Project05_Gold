import java.util.ArrayList;
/**
 * Project 05 -- Amazon Warehouse
 *
 * This program uses classes and interfaces to simulate Amazon.
 *
 * @author Brian Norton, Briana Crowe, lab sec 015
 *
 * @version December 9, 2018
 *
 */
/**
 * <h1>Vehicle</h1> Represents a vehicle
 */

public class Vehicle implements Profitable {
    private String licensePlate;
    private double maxWeight;
    private double currentWeight;
    private int zipDest;
    private ArrayList<Package> packages;



    /**
     * Default Constructor
     */
    //============================================================================
    //TODO
    public Vehicle() {

    }

    //============================================================================


    /**
     * Constructor
     *
     * @param licensePlate license plate of vehicle
     * @param maxWeight    maximum weight of vehicle
     */
    //============================================================================
    //TODO

    public Vehicle(String licensePlate, double maxWeight) {
        this.licensePlate = licensePlate;
        this.maxWeight = maxWeight;
    }

    //============================================================================


    /**
     * Returns the license plate of this vehicle
     *
     * @return license plate of this vehicle
     */
    public String getLicensePlate() {
        return licensePlate;
    }





    /**
     * Updates the license plate of vehicle
     *
     * @param licensePlate license plate to be updated to
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }







    /**
     * Returns the maximum weight this vehicle can carry
     *
     * @return the maximum weight that this vehicle can carry
     */
    public double getMaxWeight() {
        return maxWeight;
    }





    /**
     * Updates the maximum weight of this vehicle
     *
     * @param maxWeight max weight to be updated to
     */
    public void setMaxWeight(double maxWeight) {

        this.maxWeight = maxWeight;

    }






    /**
     * Returns the current weight of all packages inside vehicle
     *
     * @return current weight of all packages inside vehicle
     */
    public double getCurrentWeight() {
        return currentWeight;
    }






    /**
     * Returns the current ZIP code desitnation of the vehicle
     *
     * @return current ZIP code destination of vehicle
     */
    public int getZipDest() {

        return zipDest;

    }






    /**
     * Updates the ZIP code destination of vehicle
     *
     * @param zipDest ZIP code destination to be updated to
     */
    public void setZipDest(int zipDest) {
        this.zipDest = zipDest;
    }






    /**
     * Returns ArrayList of packages currently in Vehicle
     *
     * @return ArrayList of packages in vehicle
     */
    public ArrayList<Package> getPackages() {

        return packages;

    }

    public int getMaxRange() {
        int maxRange = 0;
        for (int i = 0; i < packages.size(); i++) {
            if (Math.abs(getZipDest() - packages.get(i).getDestination().getZipCode()) > maxRange) {
                maxRange = (Math.abs(getZipDest() - packages.get(i).getDestination().getZipCode()));
            }

        }
        return maxRange;

    }






    /**
     * Adds Package to the vehicle only if has room to carry it (adding it would not
     * cause it to go over its maximum carry weight).
     *
     * @param pkg Package to add
     * @return whether or not it was successful in adding the package
     */
    public boolean addPackage(Package pkg) {
        if (pkg.getWeight() + currentWeight > maxWeight) {
            return false;
        } else {
            packages.add(pkg);
            currentWeight += pkg.getWeight();
            return true;
        }

    }






    /**
     * Clears vehicle of packages and resets its weight to zero
     */
    public void empty() {

        ArrayList<Package> newPackages = new ArrayList<>(packages.size());
        packages = newPackages;
        currentWeight = 0;
    }






    /**
     * Returns true if the Vehicle has reached its maximum weight load, false
     * otherwise.
     *
     * @return whether or not Vehicle is full
     */
    public boolean isFull() {
        if (maxWeight - currentWeight < 0.0000001) {
            return true;
        }
        return false;
    }


    /**
     * Fills vehicle with packages with preference of date added and range of its
     * destination zip code. It will iterate over the packages intially at a range
     * of zero and fill it with as many as it can within its range without going
     * over its maximum weight. The amount the range increases is dependent on the
     * vehicle that is using this. This range it increases by after each iteration
     * is by default one.
     *
     * @param warehousePackages List of packages to add from
     */


    public void fill(ArrayList<Package> warehousePackages) {
        //TODO

        int maxRange = 0;

        for (int i = 0; i < warehousePackages.size(); i++) {
            int thisRange = Math.abs(getZipDest() - warehousePackages.get(i).getDestination().getZipCode());
            if (thisRange > maxRange) {
                maxRange = thisRange;
            }

        }

        for (int i = 0; i < warehousePackages.size(); i++) {
            for (int j = 0; j <= maxRange; j++) {

                if (Math.abs(warehousePackages.get(i).getDestination().getZipCode() - getZipDest()) == j) {
                    Package currentPackage = warehousePackages.get(i);
                    if (currentPackage.getWeight() + currentWeight < maxWeight) {
                        packages.add(currentPackage);
                        currentWeight += currentPackage.getWeight();
                    }
                }
            }


        }
    }

    public double getProfit() {

        return 0;

    }

    public String report() {
        return "";
    }







}