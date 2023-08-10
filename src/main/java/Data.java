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
        switch (unit) {
            case "bytes":
                megabyteAmount = (amount / 1024) / 1024;
                break;
            case "kilobytes":
                megabyteAmount = amount / 1024;
                break;
            case "gigabytes":
                megabyteAmount = amount * 1024;
                break;
            case "megabytes":
                megabyteAmount = amount;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return megabyteAmount;
    }

    public static double calculateDownloadTime() {
        convertToMegabytes();
        downloadTime = megabyteAmount / ((double) downloadSpeed / 8);

        return downloadTime;
    }

    public static String getFormattedDownloadTime() {
        calculateDownloadTime();
        downloadTimeSeconds = downloadTime % 60;
        downloadTimeMinute = (downloadTime - downloadTimeSeconds) / 60;

        DecimalFormat formatTime = new DecimalFormat("#");

        return formattedDownloadTime = formatTime.format(downloadTimeMinute) + " minutes " + formatTime.format(downloadTimeSeconds) + " seconds";
    }

//    toString using Class methods
    @Override
    public String toString() {
        convertToMegabytes();
        calculateDownloadTime();
        getFormattedDownloadTime();

        return "Data: " + amount + " " + unit +
                "\nDownload Time: " + formattedDownloadTime;
    }
}
