import java.text.DecimalFormat;

public class Data {
//    Instance variables amount, unit, and downloadSpeed ---- DONE
    private static double amount;
    private static String unit;
    private static int downloadSpeed;

//    Constructor ---- DONE
    public Data(double amount, String unit, int downloadSpeed) {
        setAmount(amount);
        setUnit(unit);
        setDownloadSpeed(downloadSpeed);
    }

//    Getters & Setters
    // I should really start using these..
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        Data.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        Data.unit = unit;
    }

    public int getDownloadSpeed() {
        return downloadSpeed;
    }

    public void setDownloadSpeed(int downloadSpeed) {
        Data.downloadSpeed = downloadSpeed;
    }

//    Global Variables
    public static double megabyteAmount;
    public static double downloadTime;
    public static double downloadTimeMinute;
    public static double downloadTimeSeconds;
    public static String formattedDownloadTime;

//    Class methods
    public static double convertToMegabytes() {
        // This works, I like to use the enhanced switch since
        // you don't have to worry about breaks, and it's fewer lines.
        switch (unit) {
            case "bytes" -> megabyteAmount = (amount / 1024) / 1024;
            case "kilobytes" -> megabyteAmount = amount / 1024;
            case "gigabytes" -> megabyteAmount = amount * 1024;
            case "megabytes" -> megabyteAmount = amount;
            default -> throw new IllegalArgumentException();
        }
        return megabyteAmount;
    }

    public static double calculateDownloadTime() {
        // Replacing the variable with its respective method
        // is quite useful, so you don't have to call it on its own.
        //convertToMegabytes();
        downloadTime = convertToMegabytes() / ((double) downloadSpeed / 8);

        return downloadTime;
    }

    public static String getFormattedDownloadTime() {
        calculateDownloadTime();
        downloadTimeSeconds = downloadTime % 60;
        downloadTimeMinute = (downloadTime - downloadTimeSeconds) / 60;

        // I like the usage of DecimalFormat here, very creative!
        DecimalFormat formatTime = new DecimalFormat("#");

        return formattedDownloadTime = formatTime.format(downloadTimeMinute) + " minutes " + formatTime.format(downloadTimeSeconds) + " seconds";
    }

//    toString using Class methods
    @Override
    public String toString() {
        // Calling all three works, but since they each call
        // the previous method, calling the last one works too.
        //convertToMegabytes();
        //calculateDownloadTime();
        getFormattedDownloadTime();

        return "Data: " + amount + " " + unit +
                "\nDownload Time: " + formattedDownloadTime;
    }
}
