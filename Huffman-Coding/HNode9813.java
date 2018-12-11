/* Uzzul Hussain cs435 9813 mp */

public class HNode9813 {
    int value = -1;
    int freq;
    
    public HNode9813() { }
    public HNode9813(int value, int freq) {
        setValue(value);
        setFreq(freq);
    }
    
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public int getFreq() { return freq; }
    public void setFreq(int freq) { this.freq = freq; }
}