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
class HuffmanEncodedResult {
    String encodedData;
    Node huffmanTree;

    public HuffmanEncodedResult(String encodedData, Node huffmanTree) {
        this.encodedData = encodedData;
        this.huffmanTree = huffmanTree;
    }
}
