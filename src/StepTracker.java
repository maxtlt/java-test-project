public class StepTracker {

    double[] dayToData;

    StepTracker() {

        dayToData = new double[360];
        for (int i = 0; i < dayToData.length; i++) {
            dayToData[i] = 0;
        }

    }

    void SaveTrack(double steps, int month,int day)
    {
        if (month == 1) {dayToData[day-1]=dayToData[day-1]+steps;}
        else{
        dayToData[((month-1)*30)+day-1]=dayToData[((month-1)*30)+day-1]+steps;}

    }
    double ViewSteps(int month, int amountdays)
    {
        if (month == 1) { return dayToData[month-1+amountdays-1];}
        else return dayToData[((month-1)*30)+amountdays];

    }

}