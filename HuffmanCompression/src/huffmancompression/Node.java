/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Rupture13
 */
public class Node implements Comparable<Node>, Serializable {
    private char c;
    private int frequency;
    private Node leftChild;
    private Node rightChild;

    public Node(char c, int frequency, Node leftChild, Node rightChild) {
        this.c = c;
        this.frequency = frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public char getCharacter() {
        return c;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
    
    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    @Override
    public int compareTo(Node other) {
        int frequencyComparison = Integer.compare(this.frequency, other.frequency);
        if (frequencyComparison != 0) {
            return frequencyComparison;
        }
        return Integer.compare(this.c, other.c);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        
        Node node = (Node) obj;
        
        return node.c == c && 
                node.frequency == frequency && 
                node.leftChild == leftChild && 
                node.rightChild == rightChild;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.c;
        hash = 37 * hash + this.frequency;
        hash = 37 * hash + Objects.hashCode(this.leftChild);
        hash = 37 * hash + Objects.hashCode(this.rightChild);
        return hash;
    }
    
    
}
