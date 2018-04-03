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
    HuffmanCompressor hf;
    FileWriter fw;

    public Facade() {
        hf = new HuffmanCompressor();
        fw = new FileWriter();
    }
    
    
}
