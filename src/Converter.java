public class Converter {

    double convertStepstoDistance(double steps)
    {
    double Distance = steps * 0.75 / 1000;
    return Distance;
    }

    double convertStepstoKiloCalories(double steps)
    {
        double KiloCalories = steps * 0.05;
        return KiloCalories;
    }


}
