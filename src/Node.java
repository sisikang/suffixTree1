//Programmer: Sisi Kang

//Date: Oct 26
//Description: Suffix Tree

import java.util.ArrayList;

  public class Node<T> {
      ArrayList<T> tokenSequence; //record if it is the end of the word
      ArrayList<Node> children;

      public Node(){
          tokenSequence = new ArrayList();
          children = new ArrayList();
      }

      public Node(ArrayList<T> input){//
        tokenSequence = new ArrayList(input);
        children = new ArrayList();
      }

      boolean addNode(Node node) {
        boolean found = false; // whether the node has been added or not yet

        if (tokenSequence.equals(node.tokenSequence))
        {
          found = true;
          //do NOTHING else. You will do things here in the future. But not for now;
        }
        else if( amIaSuffix(node) || (tokenSequence.size()==0)) //note that the empty sequence is always a suffix!
        {
          for (Node c: children) {
            if (c.addNode(node)) {
              found = true;
              
              //add one to count
              
              
            }
          }
          if (!found && tokenSequence.size() == node.tokenSequence.size()-1) {
            found = true;
            children.add(node);
          }
        // 1.	try to add the node to all the children nodes.
        // 2.	Did one your child nodes add the node? **keep track of this via the found variable**
        // If NOT found and the length of node’s tokenSequence is one less than this tokenSequence Add the node to our children array. Thus- found=true.
        // children.add(node);
        }

        return found;

      }

      void print() {
        System.out.println(tokenSequence);
        for (Node node: children) {
          node.print(1);
        }
      }

      void print(int numSpacesBefore) {
        for (int i=1; i<=numSpacesBefore; i++) {
          System.out.print(" ");
        }

        System.out.print("-->"); //if you like, it will be clearer print the token
        System.out.println(tokenSequence);
        for (Node node: children)
        {
          node.print(numSpacesBefore + 1);
        //each time you call this from the next child the number of spaces will increase by 1 node.print(numSpacesBefore + 1);
        }

      }


      boolean amIaSuffix(Node node) {
        int len1 = tokenSequence.size();
        int len2 = node.tokenSequence.size();
        return tokenSequence.equals(node.tokenSequence.subList(len2 - len1, len2));
      // determines whether the tokenSequence of this node is a suffix of the tokenSequence of the input node Hint #1: using the sublist() method makes this much easier.
      // Hint #2: note the difference between .equals() and ==.

      // Hint #3: You MUST test this separately to make sure it works. That means calling it temporarily from the main class to make sure it works.

      // Nothing in your Node adding will work if this is incorrect and you cannot simply assume it is correct if you haven’t tested it.
      }

  }
