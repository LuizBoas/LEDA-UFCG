package adt.avltree;

import adt.bst.BSTNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

   private int LLcounter;
   private int LRcounter;
   private int RRcounter;
   private int RLcounter;

   public AVLCountAndFillImpl() {

   }

   @Override
   public int LLcount() {
      return LLcounter;
   }

   @Override
   public int LRcount() {
      return LRcounter;
   }

   @Override
   public int RRcount() {
      return RRcounter;
   }

   @Override
   public int RLcount() {
      return RLcounter;
   }

   @Override
   public void fillWithoutRebalance(T[] array) {
      List<T[]> listAux = new ArrayList<T[]>();
      Arrays.sort(array);
      listAux.add(array);
      int i = 0;
      while (i < listAux.size()) {
         T[] arrayAux = listAux.get(i);
         int meio = arrayAux.length / 2;
         T[] arrayAux1 = Arrays.copyOfRange(arrayAux, 0, meio);
         T[] arrayAux2 = Arrays.copyOfRange(arrayAux, meio + 1, arrayAux.length);
         if (arrayAux.length > 1) {
            listAux.add(arrayAux1);
            listAux.add(arrayAux2);
         }
         insert(arrayAux[meio]);
         i++;
      }
   }

   @Override
   protected void rebalance(BSTNode<T> node) {
      if (!node.isEmpty()) {
         if (calculateBalance(node) > 1) {

            if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
               rightRotation(node);
               LLcounter++;

            } else {
               leftRotation((BSTNode<T>) node.getLeft());
               rightRotation(node);
               LRcounter++;

            }

         }
         if (calculateBalance(node) < -1) {

            if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
               leftRotation(node);
               RRcounter++;

            } else {
               rightRotation((BSTNode<T>) node.getRight());
               leftRotation(node);
               RLcounter++;
            }

         }
      }
   }

}
