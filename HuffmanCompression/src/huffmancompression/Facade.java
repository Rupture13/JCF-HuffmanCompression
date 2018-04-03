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
public class Facade {
    private HuffmanCompressor hf;
    private FileWriter fw;

    public Facade() {
        hf = new HuffmanCompressor();
        fw = new FileWriter();
    }
    
    public HuffmanEncodedResult compressData(String input) {
        return hf.compress(input);
    }
    
    public String decompressData(HuffmanEncodedResult result) {
        return hf.decompress(result);
    }
}
