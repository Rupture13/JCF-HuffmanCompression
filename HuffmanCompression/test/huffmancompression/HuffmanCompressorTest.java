/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rupture13
 */
public class HuffmanCompressorTest {
    HuffmanCompressor hc;
    String input;
    HuffmanEncodedResult result1;
    HuffmanEncodedResult result2;
    
    public HuffmanCompressorTest() {
        hc = new HuffmanCompressor();
        input = "bbq";
        result2 = hc.compress("aaabbc");
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }

    @Test
    public void compressTest1() {
        result1 = hc.compress(input);
        
        assertEquals("110", result1.getEncodedData());
        assertTrue(!result1.getHuffmanTree().isLeaf() && result1.getHuffmanTree().getLeftChild() != null && result1.getHuffmanTree().getLeftChild().getLeftChild() == null);
    }
    
    @Test
    public void compressTest2() {
        result1 = hc.compress("aaabbc"); //Should have one extra branch
        
        assertEquals("111010100", result1.getEncodedData());
        assertTrue(!result1.getHuffmanTree().isLeaf() && result1.getHuffmanTree().getLeftChild() != null && result1.getHuffmanTree().getLeftChild().getLeftChild() != null);
    }
    
    @Test
    public void decompressTest() {
        assertEquals("aaabbc", hc.decompress(result2));
    }
}
