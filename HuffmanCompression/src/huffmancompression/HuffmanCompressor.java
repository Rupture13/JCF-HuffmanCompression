/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Rupture13
 */
public class HuffmanCompressor {
    private static final int ALPHABET_SIZE = 256; //ASCII table
    
    //Main two methods
    public HuffmanEncodedResult compress(String data) {
        int[] freq = buildFrequencyTable(data);
        Node huffmanTree = buildHuffmanTree(freq);
        Map<Character, String> lookupTable = buildLookupTable(huffmanTree);
        
        return new HuffmanEncodedResult(generateEncodedData(data, lookupTable), huffmanTree);
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
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for (char i = 0; i < ALPHABET_SIZE; i++) {
            if (freq[i] == 1) {
                queue.add(new Node('\0', 1, null, null));
            }
            else if (freq[i] > 1) {
                queue.add(new Node(i, freq[i], null, null));
            }
            else {
                
            }
        }
        
        while (queue.size() > 1) {            
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node('\0', (left.frequency + right.frequency), left, right);
            queue.add(parent);
        }
        
        return queue.poll();
    }
    
    private Map<Character, String> buildLookupTable(Node huffmanTree) {
        Map<Character, String> lookupTable = new HashMap<>();
        buildLookupTableSubPart(huffmanTree, "", lookupTable);
        return lookupTable;
    }
    
    private void buildLookupTableSubPart(Node n, String s, Map<Character, String> table) {
        if (n.isLeaf()) {
            buildLookupTableSubPart(n.leftChild, s + '0', table);
            buildLookupTableSubPart(n.rightChild, s + '1', table);
        } else {
            table.put(n.c, s);
        }
    }
    
    private String generateEncodedData(String data, Map<Character, String> table) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            sb.append(table.get(c));
        }
        return sb.toString();
    }
}
