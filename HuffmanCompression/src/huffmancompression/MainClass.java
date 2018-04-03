/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rupture13
 */
public class MainClass {
    static Facade huffmanCompressor;
    static final String INPUT_TEXT = "huffman input text to be compressed";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testMethod1();
    }
    
    public static void testMethod1() {
        huffmanCompressor = new Facade();
        HuffmanEncodedResult result;
        
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, "Input:");
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, INPUT_TEXT);
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, "\nEncoded Input:");
        result = huffmanCompressor.compressData(INPUT_TEXT);
        
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, "Saved:");
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, result.getEncodedData());
        
        huffmanCompressor.save(result);
        
        huffmanCompressor.load();
        HuffmanEncodedResult loaded = new HuffmanEncodedResult(huffmanCompressor.getMessage(), huffmanCompressor.getHuffmanTree());
        
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, "\nLoaded again:");
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, loaded.getEncodedData());
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, "\nDecoded again:");
        Logger.getLogger(FileWriter.class.getName()).log(Level.INFO, huffmanCompressor.decompressData(loaded));
    }
}