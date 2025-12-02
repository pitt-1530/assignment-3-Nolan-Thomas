package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        int avg_bpms = 0;
        if (bpms == null || bpms.isEmpty()) {
            return "Invalid bpms";
        }
        
        for (Integer number : bpms) {
            avg_bpms += number;
        }

        avg_bpms /= bpms.size();

        if (avg_bpms >= 140) {
            return "HIGH";
        }
        else if (avg_bpms < 140 && avg_bpms >= 100) {
            return "MEDIUM";
        }
        else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if (title == null) return false;

        char[] title_array = title.toCharArray();
    
        int n = title.length();

        if (n < 1 || n > 30) {
            return false;
        }
        for (char ch : title_array) {
            if (ch == ' ') {
                continue;
            }
            else if (Character.isLetter(ch)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb > 100) {
            return 100;
        }
        else if (volumeDb < 0) {
            return 0;
        }

        return volumeDb;
    }
}
