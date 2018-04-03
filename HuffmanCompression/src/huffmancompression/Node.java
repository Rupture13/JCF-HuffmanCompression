/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancompression;

import java.io.Serializable;

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
}
