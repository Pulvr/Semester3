package refactoring.temperatureconverter;

class TemperatureConverter {

    public static float convertCelsiusToFahrenheit(float celsius) {
        return (float) ((celsius * (1.8)) + 32);
    }

    public static float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }
}