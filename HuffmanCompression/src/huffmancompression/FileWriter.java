/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rupture13
 */
public class FileWriter {
    private String path;
    private BitSet bits;
    private Node tree;
    private String message;

    public FileWriter() {
        path = System.getProperty("user.dir") + File.separator + "export";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String file) {
        this.path = System.getProperty("user.dir") + File.separator + path;
    }

    public Node getHuffmanTree() {
        return tree;
    }

    public String getMessage() {
        return message;
    }
    
    
    
    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            bits = (BitSet) ois.readObject();
            tree = (Node) ois.readObject();
            
            int length = ois.readInt();
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (bits.get(i)) { // O(1)
                    sb.append("1");
                }
                else {
                    sb.append("0");
                }
            }
            
            message = sb.toString();
            System.out.println("File successfully read");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save(HuffmanEncodedResult her) {
        BitSet b = new BitSet();
        String encoded = her.getEncodedData();
        
        for (int i = 0; i < encoded.length(); i++) {
            Character c = encoded.charAt(i);
            if (c == '1') {
                b.set(i, true); //O(1)
            }
            else if (c == '0') {
                b.set(i, false); //O(1)
            }
            else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(b);
            oos.writeObject(her.getHuffmanTree());
            oos.writeInt(encoded.length());
            oos.close();
            System.out.println("File successfully saved");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
