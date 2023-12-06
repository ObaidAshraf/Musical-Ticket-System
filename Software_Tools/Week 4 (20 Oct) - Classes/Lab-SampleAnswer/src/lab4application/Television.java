// The purpose of this class is to model a television
package lab4application;

public class Television {

    private String manufacturer; // the brand name

    private int screen_size; //the size of the television

    private boolean powerOn = false; // the value true means the power is on and if the value false that means the is power is off

    private int channel = 2; // the value of the channel that TV is showing

    private int volume = 20; // the value that representing the loudness and 0 means no sound

    public Television(String brand, int size) {
        manufacturer = brand;
        screen_size = size;
    }

    public void setChannel(int station) {   // this is a mutator method which accepts value and stored in channel field

        channel = station;
    }

    public void power() {   // this method will toggle the power between ON and OFF

        powerOn = !powerOn;

    }

    public void increaseVolume() {   // this method will increase the volume

       volume++;
    }

    public void decreaseVolume() {  // this method will decrese the volume

        volume--;
    }

    public int getChannel() {   // this is accessor method that return the value stored in the channel field

        return channel;
    }

    public int getVolume() {  // this is accessor method that return the value stored in the volume filed

        return volume;
    }

    public String getManufacturer() {   // this is accessor method that return the constant value stored in the manufacturer field

        return manufacturer;
    }

    public int getScreenSize() {    // this is accessor method that return the constant value stored in the screen size field

        return screen_size;
    }

}
