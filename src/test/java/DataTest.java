import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void testConvertToMegabytes() {
        Data data1 = new Data(1024, "bytes", 100);
        assertEquals(0.0009765625, data1.convertToMegabytes(), 0.01);

        Data data2 = new Data(512, "kilobytes", 100);
        assertEquals(0.5, data2.convertToMegabytes(), 0.01);

        Data data3 = new Data(1, "megabytes", 100);
        assertEquals(1.0, data3.convertToMegabytes(), 0.01);

        Data data4 = new Data(2, "gigabytes", 100);
        assertEquals(2048.0, data4.convertToMegabytes(), 0.01);

        assertThrows(IllegalArgumentException.class, () -> new Data(1, "invalidunit", 100).convertToMegabytes());
    }

    @Test
    void testCalculateDownloadTime() {
        Data data1 = new Data(1024, "kilobytes", 100);
        assertEquals(0.080, data1.calculateDownloadTime(), 0.01);

        Data data2 = new Data(512, "megabytes", 200);
        assertEquals(20.48, data2.calculateDownloadTime(), 0.01);
    }

    @Test
    void testGetFormattedDownloadTime() {
        Data data1 = new Data(1024, "kilobytes", 100);
        assertEquals("0 minutes 0 seconds", data1.getFormattedDownloadTime());

        Data data2 = new Data(512, "megabytes", 200);
        assertEquals("0 minutes 20 seconds", data2.getFormattedDownloadTime());

        Data data3 = new Data(1536, "megabytes", 512);
        assertEquals("0 minutes 24 seconds", data3.getFormattedDownloadTime());

        Data data4 = new Data(5120, "kilobytes", 512);
        assertEquals("0 minutes 0 seconds", data4.getFormattedDownloadTime());
    }

    @Test
    void testToString() {
        Data data1 = new Data(20, "gigabytes", 100);
        assertEquals("Data: 20.0 gigabytes\nDownload Time: 27 minutes 18 seconds", data1.toString());

        Data data2 = new Data(512, "megabytes", 200);
        assertEquals("Data: 512.0 megabytes\nDownload Time: 0 minutes 20 seconds", data2.toString());
    }
}
