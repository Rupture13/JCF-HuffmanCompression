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
public class MainClass {
    static Facade huffmanCompressor;
    static final String INPUT_TEXT = "huffman input text to be compressed";
//    static final String INPUT_TEXT = "aaaaaaaaaa";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        huffmanCompressor = new Facade();
        HuffmanEncodedResult result;
        
        System.out.println("Input:");
        System.out.println(INPUT_TEXT);
        System.out.println("\nEncoded input:");
        result = huffmanCompressor.compressData(INPUT_TEXT);
        
        System.out.println("\nSaved:");
        System.out.println(result.getEncodedData());
        
        huffmanCompressor.save(result);
        
        huffmanCompressor.load();
        HuffmanEncodedResult loaded = new HuffmanEncodedResult(huffmanCompressor.getMessage(), huffmanCompressor.getHuffmanTree());
        
        System.out.println("\nLoaded again:");
        System.out.println(loaded.getEncodedData());
        System.out.println("\nDecoded again:");
        System.out.println(huffmanCompressor.decompressData(loaded));
    }
}