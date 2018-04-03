/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void save(HuffmanEncodedResult her) {
        fw.save(her);
    }
    
    public void load() {
        fw.load();
    }
    
    public Node getHuffmanTree() {
        return fw.getHuffmanTree();
    }
    
    public String getMessage() {
        return fw.getMessage();
    }
    
    public String readInputFromFile(boolean large) { 
        String path; 
        if (large) { 
            path = System.getProperty("user.dir") + File.separator + "input1000000.txt"; 
        } 
        else { 
            path = System.getProperty("user.dir") + File.separator + "input10000.txt"; 
        } 
        String content = "test test"; 
         try { 
            content = new String(Files.readAllBytes(Paths.get(path))); 
        } catch (IOException e) { 
            Logger.getGlobal().log(Level.SEVERE, "Reading files failed."); 
            return "nothing"; 
        } 
         return content; 
    } 
}
