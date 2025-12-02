package edu.pitt.se;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlaylistRecommenderTest {

    @Test
    public void testClassifyValidEnergy() {
       assertEquals("HIGH", PlaylistRecommender.classifyEnergy(Arrays.asList(150, 160, 155)));
       assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(Arrays.asList(100, 110, 120)));
       assertEquals("LOW", PlaylistRecommender.classifyEnergy(Arrays.asList(90, 80, 70)));
    }

    @Test
    public void testClassifyInvalidEnergy() {
        assertEquals("Invalid bpms", PlaylistRecommender.classifyEnergy(Collections.emptyList()));
        assertEquals("Invalid bpms", PlaylistRecommender.classifyEnergy(null));
    }

    @Test
    public void testValidTrackTitles() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Hello World"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("h e l l o w o r l d"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("                     "));
        assertTrue(PlaylistRecommender.isValidTrackTitle("helloworld"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("thistitle is thirty chars long"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("a"));
    }

    @Test 
    public void testInvalidTrackTitles() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
        assertFalse(PlaylistRecommender.isValidTrackTitle("i 5n .v)aL 1:d"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("pitt. "));
        assertFalse(PlaylistRecommender.isValidTrackTitle("123"));
        assertFalse(PlaylistRecommender.isValidTrackTitle(""));
        assertFalse(PlaylistRecommender.isValidTrackTitle("this is a reallyyyyyyyyyyyyyyyy long track title"));
    }

    @Test
    public void testNormalizeVolumeInRange() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(100));
        assertEquals(99, PlaylistRecommender.normalizeVolume(99));
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
        assertEquals(0, PlaylistRecommender.normalizeVolume(0));
        assertEquals(1, PlaylistRecommender.normalizeVolume(1));
    }

    @Test
    public void testNormalizeVolumeOutOfRange() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(1000));
        assertEquals(100, PlaylistRecommender.normalizeVolume(101));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-101));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-1));

    }
}
