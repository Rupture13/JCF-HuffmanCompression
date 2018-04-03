/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

/**
 *
 * @author Rupture13
 */
public class HuffmanCompressor {
    private static final int ALPHABET_SIZE = 256; //ASCII table
    
    //Main two methods
    public HuffmanEncodedResult compress(String data) {
        int[] freq = buildFrequencyTable(data);
        
        
        return null;
    }
    
    public String decompress(HuffmanEncodedResult result) {
        return null;
    }
    
    private int[] buildFrequencyTable(String data) {
        int[] freq = new int[ALPHABET_SIZE];
        for (char c : data.toCharArray()) {
            freq[c]++;  //Char als index gebruiken kan
        }
        return freq;
    }
    
    private Node buildHuffmanTree(int[] freq) {
        return null;
    }
}
