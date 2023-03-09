package Cac.Converter;

public class Converter {
    double factor;


    public Converter(double factor) {
        this.factor = factor;
    }
    /**
     * Constructor of Converter sets factor to one to avoid errors
     */
    public Converter() {
        factor = 1;
    }

    /**
     * Converts the given value through the given factor
     *
     * @param x value
     * @return x times f
     */
    public double convertFrom(double x) {
        return x * factor;
    }

    /**
     * Converts the given value through the reciprocal of the given factor
     *
     * @param x value
     * @return x times reciprocal of factor
     */
    public double convertTo(double x) {
        return x * (1 / factor);
    }

    /**
     * Sets the factor for the converter
     *
     * @param factor factor
     */
    public void setFactor(double factor) {
        this.factor = factor;
    }
    
    public double getFactor(){
        return factor;
    }
}
