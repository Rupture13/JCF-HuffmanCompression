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
        StringBuilder sb = new StringBuilder();
        Node current = result.getHuffmanTree();
        int i = 0;
        while (i < result.getEncodedData().length()) {            
            while (!current.isLeaf()) {                
                char bit = result.getEncodedData().charAt(i);
                if (bit == '1') {
                    current = current.getRightChild();
                } else if (bit == '0') {
                    current = current.getLeftChild();
                } else {
                    throw new IllegalArgumentException("Invalid bit in message: " + bit);
                }
                i++;
            }
            sb.append(current.getCharacter());
            current = result.getHuffmanTree();
        }
        
        return sb.toString();
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
            if (freq[i] > 0) {
                queue.add(new Node(i, freq[i], null, null));
            }
        }
        
        if (queue.size() == 1) {
           queue.add(new Node('\0', 1, null, null));
        }
        
        while (queue.size() > 1) {            
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node('\0', (left.getFrequency() + right.getFrequency()), left, right);
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
        if (!n.isLeaf()) {
            buildLookupTableSubPart(n.getLeftChild(), s + '0', table);
            buildLookupTableSubPart(n.getRightChild(), s + '1', table);
        } else {
            table.put(n.getCharacter(), s);
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
