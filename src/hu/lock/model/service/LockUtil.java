package hu.lock.model.service;

public class LockUtil {

    public static String open(String actualKey, String key) {
        String result;
        if (!isSameLength(actualKey, key)) {
            result = "hibás hossz";
        } else {
            result = nyit(actualKey, key) ? "sikeres" : "hibás kódszám";
        }
        return result;
    }

    public static boolean isSameLength(String actualKey, String key) {
        return actualKey.length() == key.length();
    }

    private static boolean nyit(String jo, String proba) {
        boolean egyezik = isSameLength(jo, proba);
        if (egyezik) {
            int elteres = (int) jo.charAt(0) - (int) proba.charAt(0);
            for (int i = 1; i < jo.length(); i++) {
                if ((elteres - ((int) jo.charAt(i) - (int) proba.charAt(i))) % 10 != 0) {
                    egyezik = false;
                }
            }
        }
        return egyezik;
    }
}
