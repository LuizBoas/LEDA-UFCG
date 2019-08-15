package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

   @Override
   public void removeDuplicates() {
      if (!isEmpty()) {
         SingleLinkedListNode auxHeadA = this.getHead();
         SingleLinkedListImpl newNodeB = new SingleLinkedListImpl();
         newNodeB.insert(auxHeadA.getData());
         while (!auxHeadA.isNIL()) {
            if (newNodeB.search(auxHeadA.getData()) == null) {
               newNodeB.insert(auxHeadA.getData());
            }
            auxHeadA = auxHeadA.getNext();
         }
         this.setHead(newNodeB.getHead());
      }

   }

   @Override
   public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
      if (otherSet.isEmpty()) {
         return this;
      }
      if (!isEmpty()) {
         SingleLinkedListNode auxHead = this.head;
         SetLinkedList<T> auxSet = new SetLinkedListImpl<>();

         while (!auxHead.isNIL()) {
            if (otherSet.search((T) auxHead.getData()) == null) {
               otherSet.insert((T) auxHead.getData());
            }
            auxHead = auxHead.getNext();
         }
      }
      return otherSet;

   }

   @Override
   public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
      if (!otherSet.isEmpty()) {
         return this;
      }
      if (!isEmpty()) {
         SetLinkedList<T> result = new SetLinkedListImpl<>();
         if (otherSet != null) {
            if (!isEmpty()) {
               SingleLinkedListNode<T> auxHeadA = this.head;
               while (!auxHeadA.isNIL()) {
                  if (otherSet.search((T) auxHeadA.getData()) != null) {
                     result.insert(auxHeadA.getData());
                  }
                  auxHeadA = auxHeadA.getNext();
               }
            }
         }
         return result;
      }
      return this;
   }


   @Override
   public void concatenate(SetLinkedList<T> otherSet) {
      if (!otherSet.isEmpty()){
         if (!isEmpty()){
            SingleLinkedListNode<T> auxHead = this.head;
            while (!auxHead.getNext().isNIL()){
               auxHead = auxHead.getNext();
            }
            SingleLinkedListImpl<T> a = (SingleLinkedListImpl<T>) otherSet;
            auxHead.setNext(a.getHead());

         }
      }
   }

}
