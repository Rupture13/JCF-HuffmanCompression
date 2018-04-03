/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rupture13
 */
public class FileWriterTest {
    FileWriter fw;
    HuffmanCompressor hc;
    
    public FileWriterTest() {
        fw = new FileWriter();
        hc = new HuffmanCompressor();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @Test
    public void saveTest() {
        fw.setPath("exportTest");
        HuffmanEncodedResult result = hc.compress("bbq"); //Should become 110 when encoded
        fw.save(result);
        
        File f = new File(fw.getPath());
        assertTrue(f.exists() && !f.isDirectory());
    }
    
    @Test
    public void loadTest() {
        fw.setPath("exportTest");
        fw.load();
        
        assertEquals("110", fw.getMessage());
    }
}
