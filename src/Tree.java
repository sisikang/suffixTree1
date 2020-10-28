//Programmer: Sisi Kang

//Date: Oct 26
//Description: Suffix Tree

import java.util.ArrayList;

public class Tree<T> {


        Node root;//record the root
        int L;
        /** Initialize your data structure here. */
        public Tree(int l) {
            root = new Node();
            L = l;
        }

        void train(ArrayList<T> input) {
            for(int i = 1; i<=L ; i++) {
                for(int j = 0; j<input.size()-(i-1); j++) {
                    ArrayList<T> curSequence = new ArrayList<>(input.subList(j, j+i));
                    Node theNewNode = new Node(curSequence);
//                    System.out.println(theNewNode.tokenSequence);
                    root.addNode(theNewNode);
                    // curSequence = find the current sequence of size i
                    // create a new node with the current sequence, theNewNode root.addNode(theNewNode)
                }
            }
        }

        void print() {
            root.print();
        }
}
