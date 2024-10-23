package bakjoon.E12891;

public class Calculate {
    public int charToint(String s) {
        int result = 0;
        switch(s) {
            case "A":
                result = 1;
                break;
            case "C":
                result = 2;
                break;
            case "G":
                result = 3;
                break;
            case "T":
                result = 4;
                break;
            default:
                break;
        }

        return result;
    }
}