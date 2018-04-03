/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rupture13
 */
public class PerformanceTest {
    Facade f;
    
    public PerformanceTest() {
        f = new Facade();
    }

    @Test //Test with 10,000 words
    public void performanceTest1() {
        String input = f.readInputFromFile(false);
        executeEntireRoutine(input);
        assertTrue(true);
    }
    
    @Test //Test with 1,000,000 words
    public void performanceTest2() {
        String input = f.readInputFromFile(true);
        executeEntireRoutine(input);
        assertTrue(true);
    }
    
    private void executeEntireRoutine(String input) {
        HuffmanEncodedResult result;
        result = f.compressData(input);
        
        f.save(result);
        
        f.load();
        HuffmanEncodedResult loaded = new HuffmanEncodedResult(f.getMessage(), f.getHuffmanTree());
        
        f.decompressData(loaded);
    }
}
