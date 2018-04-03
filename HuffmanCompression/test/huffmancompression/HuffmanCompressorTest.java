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
public class HuffmanCompressorTest {
    static final String MSG1 = "aaabbc";
    static final String MSG2 = "bbq";
    
    HuffmanCompressor hc;
    String input;
    HuffmanEncodedResult result1;
    HuffmanEncodedResult result2;
    
    public HuffmanCompressorTest() {
        hc = new HuffmanCompressor();
        input = MSG2;
        result2 = hc.compress(MSG1);
    }

    @Test
    public void compressTest1() {
        result1 = hc.compress(input);
        
        assertEquals("110", result1.getEncodedData());
        assertTrue(!result1.getHuffmanTree().isLeaf() && result1.getHuffmanTree().getLeftChild() != null && result1.getHuffmanTree().getLeftChild().getLeftChild() == null);
    }
    
    @Test
    public void compressTest2() {
        result1 = hc.compress(MSG1); //Should have one extra branch
        
        assertEquals("111010100", result1.getEncodedData());
        assertTrue(!result1.getHuffmanTree().isLeaf() && result1.getHuffmanTree().getLeftChild() != null && result1.getHuffmanTree().getLeftChild().getLeftChild() != null);
    }
    
    @Test
    public void decompressTest() {
        assertEquals(MSG1, hc.decompress(result2));
    }
}
